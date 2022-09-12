package com.tistory.amyyzzin.dividend.scheduler;

import com.tistory.amyyzzin.dividend.model.Company;
import com.tistory.amyyzzin.dividend.model.ScrapedResult;
import com.tistory.amyyzzin.dividend.model.constants.CacheKey;
import com.tistory.amyyzzin.dividend.persist.CompanyRepository;
import com.tistory.amyyzzin.dividend.persist.DividendRepository;
import com.tistory.amyyzzin.dividend.persist.entity.CompanyEntity;
import com.tistory.amyyzzin.dividend.persist.entity.DividendEntity;
import com.tistory.amyyzzin.dividend.scraper.Scraper;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableCaching
@AllArgsConstructor
public class ScraperScheduler {

    private final CompanyRepository companyRepository;
    private final DividendRepository dividendRepository;
    private final Scraper yahooFinanceScraper;


    // 일정 주기마다 수행
    @Scheduled(cron = "${scheduler.scrap.yahoo}")
    @CacheEvict(value = CacheKey.KEY_FINANCE, allEntries = true)
    public void yahooFinanceScheduling() {

        log.info("scraping scheduler is started");

        //저장된 회사 목록을 조회
        List<CompanyEntity> companies = this.companyRepository.findAll();

        //회사마다 배당금 정보를 새로 스크래핑
        for (var company : companies) {
            log.info("scraping scheduler is Start -> " + company.getName());
            ScrapedResult scrapedResult = this.yahooFinanceScraper.scrap(
                new Company(company.getName(), company.getTicker()));

            //스크래핑 한 배당금 정보중 데이터베이스에 없는 값은 저장
            scrapedResult.getDividends().stream()

                //디비든 모델을 디비든 엔티티로 매핑
                .map(e -> new DividendEntity(company.getId(), e))

                //엘리먼트 하나씩 디비든 레파지토리에 삽입
                .forEach(e -> {
                    boolean exists = this.dividendRepository.existsByCompanyIdAndDate(
                        e.getCompanyId(), e.getDate());
                    if (!exists) {
                        this.dividendRepository.save(e);
                        log.info("insert new dividend -> " + e.toString());
                    }
                });

            //연속적으로 스크래핑 대상 사이트 서버에 요청을 날리지 않도록 일시정지
            try {
                Thread.sleep(3000); // 3second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

package com.tistory.amyyzzin.dividend.scraper;

import com.tistory.amyyzzin.dividend.model.Company;
import com.tistory.amyyzzin.dividend.model.ScrapedResult;

public interface Scraper {

    Company scrapCompanyByTicker(String ticker);

    ScrapedResult scrap(Company company);
}

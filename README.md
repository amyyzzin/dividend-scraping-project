# 나의 배당금 조회
### 스크래핑을 통해 회사의 배당금을 조회 및 저장 할 수 있습니다.
<div>
   <a href="https://amyyzzin.notion.site/93d6282c62ab4beab68ef9050a4935b7">
        <text>▶ NOTION for project</text>
    </a>
</div>

## **👩‍🔧 기술 스택**
<section>
<div>
    <img src="https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=coffeeScript&logoColor=white">
    <img src="https://img.shields.io/badge/Spring%20Boot-FF6600?style=flat-square&logo=springBoot&logoColor=white">
    <img src="https://img.shields.io/badge/Spring%20Data%20Jpa-6DB33F?style=flat-sqaure&logo=aqua&logoColor=white">
    <img src="https://img.shields.io/badge/Jsoup-purple?style=flat-square&logo=coffeeScript&logoColor=white">
    <img src="https://img.shields.io/badge/MySql-4479A1?style=flat-sqaure&logo=mysql&logoColor=white">
    <img src="https://img.shields.io/badge/Redis-DC382D?style=flat-sqaure&logo=redis&logoColor=white">
    <img src="https://img.shields.io/badge/H2-blue?style=flat-sqaure&logoColor=white">
</div>
</section>

## **👩‍💻 주요 기능**
- 회원가입 및 로그인을 할 수 있습니다.
- 중복 ID는 허용하지 않으며, 패스워드는 암호화 된 형태로 저장됩니다. 
- 회원가입이 되어있고, 아이디/패스워드 정보가 일치하면 JWT를 발급합니다. 
- 검색하고자 하는 prefix 를 입력으로 받고, 해당 prefix 로 검색되는 회사명 리스트 조회 가능합니다.
- 회사 이름을 인풋으로 받아서 해당 회사의 메타 정보와 배당금 정보를 조회 할 수 있습니다.
- 내가 관심있는 회사의 정보를 추가 할 수 있습니다.
- 내가 추가 한 모든 회사 목록을 확인 할 수 있습니다. 
- 추가하고자 하는 회사의 ticker 를 입력으로 받아 해당 회사의 정보를 스크래핑하고 저장 할 수 있습니다.
- ticker 에 해당하는 회사 정보 삭제 할 수 있습니다. 
- 삭제시 회사의 배당금 정보와 캐시도 모두 삭제됩니다. 

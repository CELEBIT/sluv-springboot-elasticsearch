# elastic_search_study
[sluv] 의 내부 검색 엔진 서비스입니다. 현재 아이템 검색, 질문 검색, 유저 검색 기능을 제공하거 전문 검색, 구문 검색, 다중 단어 검색, 동의어 검색 등의 기능을 제공합니다.
restful api로 개발되었으며 스럽 서비스 내부에서 해당 api를 호출하여 사용합니다.

![image](https://github.com/CELEBIT/sluv-springboot-elasticsearch/assets/81170119/29e74dca-dbe4-4047-91df-e728a27d2a2d)
![image](https://github.com/CELEBIT/sluv-springboot-elasticsearch/assets/81170119/2291f849-8d5f-49f0-98d9-a1620c5886ee)
![image](https://github.com/CELEBIT/sluv-springboot-elasticsearch/assets/81170119/2e0a2c03-39d5-4981-a51e-01aef99ac2d9)
![image](https://github.com/CELEBIT/sluv-springboot-elasticsearch/assets/81170119/0df8ed04-5e98-4d80-8810-5c5fd444d1f7)
![image](https://github.com/CELEBIT/sluv-springboot-elasticsearch/assets/81170119/63f834f0-f00a-47b5-842c-4a81ba99e0ac)
![image](https://github.com/CELEBIT/sluv-springboot-elasticsearch/assets/81170119/fdb7d3b0-a57d-480e-8f0e-8b2b85d30ba8)
![image](https://github.com/CELEBIT/sluv-springboot-elasticsearch/assets/81170119/48b4c275-1e43-457b-8167-9bac294b69a9)


## DEV version
- Java : OpenJDK 17
- Springboot : 2.7.5

## ELK version
elastic search - 7.0.0
kibana - 7.0.0
logstash - 7.0.0

## Structure
    > build
    > gradle
    > src.main.java.com.tree.elasticsearch
        > configuration
            | Config // @Configuration @EnableElasticsearchRepositories 어노테이션 사용.
        > controller 
            | ExampleController // controller 예시.
            | SearchController // 실질적 controller 역할 수행. 클라이언트에서 restful 방식으로 요청이 오는 
                                  URI와 매핑을 해주고 service단으로 요청을 전달.
        > document
            | search1.java // search1 index (for 아이템 검색) 의 필드 정의. 타입도 함꼐 명시. 
            | search2.java // search2 index (for 질문 검색) 의 필드 정의. 타입도 함꼐 명시. 
            | search3.java // search3 index (for 유저 검색) 의 필드 정의. 타입도 함꼐 명시. 
        > helper
            | Util 
        > repository
            | Search1Repository 
            | Search2Repository 
            | Search3Repository 
        > search
            > util
                | SearchUtil // elastic search에 검색 시 사용할 Query DSL 정의. 
            | SearchRequestDTO // 클라이언트측에서 전달받을 데이터를 정의. (쿼리스트링으로 사용됨) 
        > service 
            | IndexService // 인덱스와 관련된 실질적 서비스 제공. (매핑 로드, 인덱스 생성)
            | SearchService // 검색과 서비스 제공 
        | ElasticsearchApplication // 스프링 부트 실행 시작되는 파일. 
    > resources
        > static
            > logstashqueries
                | queriesForLogstash.xml // elasticsearch와 RDBMS 연동 시 사용되는 쿼리들 정의. 
            > mappings 
                | search1.json // search1에서 필드별로 사용할 분석기와 검색기 정의. 
                | search2.json // search2에서 필드별로 사용할 분석기와 검색기 정의. 
                | search3.json // search3에서 필드별로 사용할 분석기와 검색기 정의. 
            | searh1_settings.json // search1에서 사용할 분석기와 검색기 정의. 
            | searh2_settings.json // search2에서 사용할 분석기와 검색기 정의. 
            | searh3_settings.json // search3에서 사용할 분석기와 검색기 정의. 
        > templates
            | example.html
        | application.properties // 스프링부트 설정 파일. 
    > src.test.java.com.tree.elasticsearch
        | ElasticsearchAppicationTests 
        
    build.gradle 
    .gitignore


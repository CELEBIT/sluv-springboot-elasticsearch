# elastic_search_study
엘라스틱 서치 공부용 (테스트) 템플릿입니다. 검색 기능과 Logstash로 elasticsearch Mysql 동기화 기능, 총 두가지 기능을 수행합니다.

## version
현재 스프링부트는 '2.7.5' 자바는 11, elasticsearch, kibana, logstash 각 7.0 버전 사용중입니다.

## Structure
    > build
    > gradle
    > src.main.java.com.tree.elasticsearch
        > configuration
            | Config // @Configuration @EnableElasticsearchRepositories 어노테이션 사용합니다.
        > controller  // controller입니다. 클라이언트에서 요청이 오는 URI와 매핑을 해주고 service로 요청을 전달합니다.
            | ExampleController // controller 예시입니다.
            | TestController // 실질적으로 작동되는 controller입니다.
        > document
            | Test.java // 인덱스를 정의합니다. 타입도 명시해줘야합니다. 
        > helper
            | Util // 로그 파일 필요한 것을 정의합니다.
        > repository
            | TestRepository // 레포지토리를 정의합니다.
        > search
            > util
                | TestSearchUtil // 사용할 Query DSL을 정의합니다. 
            | SearchRequestDTO // 클라이언트측에서 전달받을 데이터를 정의합니다. ex. 쿼리스트링 
        > service // 실질적인 서비스를 하는 곳입니다.
            | IndexService // 인덱스와 관련된 서비스를 합니다.
            | TestService // 검색과 관련된 서비스를 합니다. 
        | ElasticsearchApplication // 스프링부트가 시작되는 곳입니다.
    > resources
        > static
            > logstashqueries
                | queriesForLogstash.xml // logstash를 통해 index로 만들 때 사용할 쿼리들을 정의하는 곳입니다. 
            > mappings 
                | test.json // 매핑을 정의합니다.
            | test_settings.json // 분석기를 정의합니다. 
        > templates
            | example.html
        | application.properties // 스프링부트 설정 파일입니다.
    > src.test.java.com.tree.elasticsearch
        | ElasticsearchAppicationTests 
        
    build.gradle 
    .gitignore


## SLUV_SEARCH_ENGINE

##Introduction
연예인의 아이템을 공유하는 SLUV 서비스입니다. 

![image](https://github.com/CELEBIT/sluv-springboot-elasticsearch/assets/81170119/29e74dca-dbe4-4047-91df-e728a27d2a2d)
![image](https://github.com/CELEBIT/sluv-springboot-elasticsearch/assets/81170119/2291f849-8d5f-49f0-98d9-a1620c5886ee)
![image](https://github.com/CELEBIT/sluv-springboot-elasticsearch/assets/81170119/2e0a2c03-39d5-4981-a51e-01aef99ac2d9)

## ROLE
💻 검색 엔진 단독 개발 및 데이터 크롤링

![image](https://github.com/CELEBIT/sluv-springboot-elasticsearch/assets/81170119/0df8ed04-5e98-4d80-8810-5c5fd444d1f7)
![image](https://github.com/CELEBIT/sluv-springboot-elasticsearch/assets/81170119/63f834f0-f00a-47b5-842c-4a81ba99e0ac)

⛳️ 

검색 엔진 goal) 전문 검색 가능, 동의어 검색 가능, 속도 개선, 우선순위 검색 가능

## ARCHITECTURE
![image](https://github.com/CELEBIT/sluv-springboot-elasticsearch/assets/81170119/fdb7d3b0-a57d-480e-8f0e-8b2b85d30ba8)

AWS 배포
- 인스턴스 유형 : t2.medium(CPU : 2core, RAM : 4GB, Storage : 40GB)
- 비용 : 시간당 0.0576 USD
- AMI : Ubuntu Server 20.04

## VERSION
### DEV 
- Java : OpenJDK 17
- Springboot : 2.7.5
### ELK 
- elastic search : 7.0.0
- kibana : 7.0.0
- logstash : 7.0.0

## Structure
    > build
    > gradle
    > src.main.java.com.tree.elasticsearch
        > configuration
            | Config
        > controller 
            | ExampleController
            | SearchController
        > document
            | search1.java
            | search2.java
            | search3.java 
        > helper
            | Util 
        > repository
            | Search1Repository 
            | Search2Repository 
            | Search3Repository 
        > search
            > util
                | SearchUtil 
            | SearchRequestDTO 
        > service 
            | IndexService 
            | SearchService 
        | ElasticsearchApplication 
    > resources
        > static
            > logstashqueries
                | queriesForLogstash.xml 
            > mappings 
                | search1.json 
                | search2.json 
                | search3.json 
            | searh1_settings.json 
            | searh2_settings.json 
            | searh3_settings.json 
        > templates
            | example.html
        | application.properties 
    > src.test.java.com.tree.elasticsearch
        | ElasticsearchAppicationTests 

## API 
[Item 검색]
`/search/searchItem`?searchTem= (검색어)

[Question 검색]
`/search/searchQuestion`?searchTem= (검색어)

[User 검색]
`/search/searchUser`?searchTerm= (검색어)

[인덱스 초기화]
/search/resetAllIndexes

## 검색 엔진 사용 영상
https://github.com/CELEBIT/sluv-springboot-elasticsearch/assets/81170119/99d7a12e-dc8d-4455-8f53-51ac722b2649


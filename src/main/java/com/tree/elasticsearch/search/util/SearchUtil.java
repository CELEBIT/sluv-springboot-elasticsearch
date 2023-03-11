package com.tree.elasticsearch.search.util;

import com.tree.elasticsearch.search.SearchRequestDTO;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class SearchUtil {

    private SearchUtil(){}

    public static SearchRequest testSearch1(final SearchRequestDTO dto){
        if (dto == null){
            return null;
        }
        try {
            final String searchTerm = dto.getSearchTerm();
            final QueryBuilder query1 = QueryBuilders.matchQuery("name", searchTerm);
            final QueryBuilder query2 = QueryBuilders.matchQuery("korname", searchTerm);
            final QueryBuilder query3 = QueryBuilders.matchQuery("kor_nm", searchTerm);



            BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
                    .should(query1).should(query2).should(query3)
                    .minimumShouldMatch(1);

            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().postFilter(boolQuery).trackTotalHits(true).size(1000);
            SearchRequest request = new SearchRequest("test"); //
            request.source(searchSourceBuilder);
            return request;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static SearchRequest testSearch2(final SearchRequestDTO dto){
        if (dto == null){
            return null;
        }
        try {
            final String searchTerm = dto.getSearchTerm();
            final QueryBuilder query1 = QueryBuilders.matchQuery("name", searchTerm);
            final QueryBuilder query2 = QueryBuilders.matchQuery("korname", searchTerm);
            final QueryBuilder query3 = QueryBuilders.matchQuery("kor_nm", searchTerm);
            final QueryBuilder query4 = QueryBuilders.matchPhraseQuery("korname_ngram", searchTerm);
            final QueryBuilder query5 = QueryBuilders.matchPhraseQuery("name_ngram", searchTerm);
            final QueryBuilder query6 = QueryBuilders.matchPhraseQuery("korname_eng2kor", searchTerm);
            final QueryBuilder query7 = QueryBuilders.matchPhraseQuery("korname_chosung", searchTerm);
            final QueryBuilder query8 = QueryBuilders.termQuery("korname_jamo", searchTerm);
            final QueryBuilder query9 = QueryBuilders.matchQuery("garden_nm", searchTerm);
            BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
                    .mustNot(query1).mustNot(query2).mustNot(query3)
                    .should(query4).should(query5).should(query6).should(query7).should(query8).should(query9);
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().postFilter(boolQuery).trackTotalHits(true).size(1000);
            SearchRequest request = new SearchRequest("test");
            request.source(searchSourceBuilder);
            return request;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    // 검색어와 name이 완전히 일치해야 나오는 함수
    public static SearchRequest firstSearch1(final SearchRequestDTO dto){
        if (dto == null){
            return null;
        }
        try {
            final String searchTerm = dto.getSearchTerm();
            final QueryBuilder query1 = QueryBuilders.matchQuery("name", searchTerm);


            BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
                    .should(query1)
                    .minimumShouldMatch(1);
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(boolQuery).trackTotalHits(true).size(1000);
            SearchRequest request = new SearchRequest("test");
            request.source(searchSourceBuilder);
            return request;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    // 이름이 같지 않을 때 다른 요소들 ex. korname_gram 등이 일치하면 결과값이 나오는 코드
    public static SearchRequest firstSearch2(final SearchRequestDTO dto){
        if (dto == null) return null;
        try {
            final String searchTerm = dto.getSearchTerm();
            final QueryBuilder query1 = QueryBuilders.matchQuery("name", searchTerm);
            final QueryBuilder query2 = QueryBuilders.matchQuery("address", searchTerm);
            final QueryBuilder query4 = QueryBuilders.matchPhraseQuery("korname_ngram", searchTerm).boost(3);
            final QueryBuilder query5 = QueryBuilders.matchPhraseQuery("name_ngram", searchTerm);
            final QueryBuilder query6 = QueryBuilders.matchPhraseQuery("korname_eng2kor", searchTerm);
            final QueryBuilder query7 = QueryBuilders.matchPhraseQuery("korname_chosung", searchTerm);
            final QueryBuilder query8 = QueryBuilders.termQuery("korname_jamo", searchTerm);


            BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
                    .mustNot(query1)
                    .should(query2).should(query4).should(query5).should(query6).should(query7).should(query8).minimumShouldMatch(1);
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(boolQuery).trackTotalHits(true).size(1000);
            SearchRequest request = new SearchRequest("test"); //
            request.source(searchSourceBuilder);
            return request;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



}

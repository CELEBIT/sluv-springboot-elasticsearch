package com.tree.elasticsearch.search.util;

import com.tree.elasticsearch.search.SearchRequestDTO;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class ListSearchUtil {

    private ListSearchUtil(){}

    public static SearchRequest listSearch1(final SearchRequestDTO dto){
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
            SearchRequest request = new SearchRequest("list1", "list2", "list3", "list4", "list5", "list6", "list7", "list8", "list9", "list10", "list11"); //
            request.source(searchSourceBuilder);
            return request;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static SearchRequest listSearch2(final SearchRequestDTO dto){
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
            SearchRequest request = new SearchRequest("list1", "list2", "list3", "list4", "list5", "list6", "list7", "list8", "list9", "list10", "list11"); //
            request.source(searchSourceBuilder);
            return request;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }






    // LIST1, 2는 GIGWAN과 상관없이 공통으로 사용되는 자료로 보임.
    public static SearchRequest firstSearch1(final SearchRequestDTO dto){
        if (dto == null){
            return null;
        }
        try {
            final String searchTerm = dto.getSearchTerm();
            final QueryBuilder query1 = QueryBuilders.matchQuery("name", searchTerm);
            final QueryBuilder query2 = QueryBuilders.matchQuery("korname", searchTerm);
            BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
                    .should(query1).should(query2)
                    .minimumShouldMatch(1);
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(boolQuery).trackTotalHits(true).size(1000);
            SearchRequest request = new SearchRequest("list1", "list2"); //
            request.source(searchSourceBuilder);
            return request;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static SearchRequest firstSearch2(final SearchRequestDTO dto){
        if (dto == null) return null;
        try {
            final String searchTerm = dto.getSearchTerm();
            final QueryBuilder query1 = QueryBuilders.matchQuery("name", searchTerm);
            final QueryBuilder query2 = QueryBuilders.matchQuery("korname", searchTerm);
            final QueryBuilder query4 = QueryBuilders.matchPhraseQuery("korname_ngram", searchTerm).boost(3);
            final QueryBuilder query5 = QueryBuilders.matchPhraseQuery("name_ngram", searchTerm);
            final QueryBuilder query6 = QueryBuilders.matchPhraseQuery("korname_eng2kor", searchTerm);
            final QueryBuilder query7 = QueryBuilders.matchPhraseQuery("korname_chosung", searchTerm);
            final QueryBuilder query8 = QueryBuilders.termQuery("korname_jamo", searchTerm);
            BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
                    .mustNot(query1).mustNot(query2)
                    .should(query4).should(query5).should(query6).should(query7).should(query8).minimumShouldMatch(1);
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(boolQuery).trackTotalHits(true).size(1000);
            SearchRequest request = new SearchRequest("list1", "list2"); //
            request.source(searchSourceBuilder);
            return request;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // LIST 3~11은 GIGWAN_CD FIELD 가 따로 있음. 해당 GIGWAN 의 정보만 보여주는게 맞는듯?
    public static SearchRequest gigwanSearch1(final SearchRequestDTO dto){
        if (dto == null) return null;
        try {
            final String searchTerm = dto.getSearchTerm();
            final String gigwanCd = dto.getGigwanCd();
            final QueryBuilder query1 = QueryBuilders.matchQuery("gigwan_cd", gigwanCd);
            final QueryBuilder query2 = QueryBuilders.matchQuery("name", searchTerm);
            final QueryBuilder query3 = QueryBuilders.matchQuery("korname", searchTerm);
            BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
                    .must(query1).should(query2).should(query3).minimumShouldMatch(1);
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(boolQuery).trackTotalHits(true).size(1000);
            SearchRequest request = new SearchRequest("list3", "list4", "list5", "list6", "list7", "list8", "list9", "list10", "list11"); //
            request.source(searchSourceBuilder);
            return request;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static SearchRequest gigwanSearch2(final SearchRequestDTO dto){
        if (dto == null) return null;
        try {
            final String searchTerm = dto.getSearchTerm();
            final String gigwanCd = dto.getGigwanCd();
            final QueryBuilder query1 = QueryBuilders.matchQuery("gigwan_cd", gigwanCd);
            final QueryBuilder query2 = QueryBuilders.matchQuery("name", searchTerm);
            final QueryBuilder query3 = QueryBuilders.matchQuery("korname", searchTerm);

            final QueryBuilder query4 = QueryBuilders.matchPhraseQuery("korname_ngram", searchTerm).boost(3);
            final QueryBuilder query5 = QueryBuilders.matchPhraseQuery("name_ngram", searchTerm);
            final QueryBuilder query6 = QueryBuilders.matchPhraseQuery("korname_eng2kor", searchTerm);
            final QueryBuilder query7 = QueryBuilders.matchPhraseQuery("korname_chosung", searchTerm);
            final QueryBuilder query8 = QueryBuilders.termQuery("korname_jamo", searchTerm);
            BoolQueryBuilder boolQeury = QueryBuilders.boolQuery()
                    .must(query1).mustNot(query2).mustNot(query3)
                    .should(query4).should(query5)
                    .should(query6).should(query7).should(query8)
                    .minimumShouldMatch(1);
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(boolQeury).trackTotalHits(true).size(1000);
            SearchRequest request = new SearchRequest("list3", "list4", "list5", "list6", "list7", "list8", "list9", "list10", "list11"); //
            request.source(searchSourceBuilder);
            return request;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

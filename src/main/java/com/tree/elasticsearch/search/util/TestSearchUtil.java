package com.tree.elasticsearch.search.util;

import com.tree.elasticsearch.search.SearchRequestDTO;
import org.elasticsearch.action.search.SearchRequest;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class TestSearchUtil {

    private TestSearchUtil(){}

    public static SearchRequest testSearch(final SearchRequestDTO dto){
        if (dto == null){
            return null;
        }
        try {
            final String searchTerm = dto.getSearchTerm();

            final QueryBuilder query1 = QueryBuilders.matchQuery("name", searchTerm);
            final QueryBuilder query2 = QueryBuilders.matchQuery("address", searchTerm);
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
            SearchRequest request = new SearchRequest("test"); //
            request.source(searchSourceBuilder);
            return request;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




}

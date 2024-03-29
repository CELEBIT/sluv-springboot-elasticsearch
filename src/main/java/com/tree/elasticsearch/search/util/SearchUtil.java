package com.tree.elasticsearch.search.util;

import com.tree.elasticsearch.search.SearchRequestDTO;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class SearchUtil {
    private SearchUtil(){}

    //item 검색
    public static SearchRequest firstSearch1(final SearchRequestDTO dto){
        if (dto == null){
            return null;
        }
        try {
            final String searchTerm = dto.getSearchTerm();
            final QueryBuilder query1 = QueryBuilders.matchQuery("where_discovery", searchTerm);
            final QueryBuilder query2 = QueryBuilders.matchQuery("where_discovery_ngram", searchTerm);
            final QueryBuilder query3 = QueryBuilders.matchQuery("where_discovery_kr_eng2kor", searchTerm);
            final QueryBuilder query4 = QueryBuilders.matchQuery("where_discovery_kr_chosung", searchTerm);
            final QueryBuilder query5 = QueryBuilders.termQuery("where_discovery_kr_jamo", searchTerm);
            final QueryBuilder query6 = QueryBuilders.matchQuery("item_name", searchTerm).boost(1);
            final QueryBuilder query7 = QueryBuilders.matchQuery("item_name_ngram", searchTerm).boost(1);
            final QueryBuilder query8 = QueryBuilders.matchQuery("item_name_kr_eng2kor", searchTerm).boost(1);
            final QueryBuilder query9 = QueryBuilders.matchQuery("item_name_kr_chosung", searchTerm).boost(1);
            final QueryBuilder query10 = QueryBuilders.termQuery("item_name_kr_jamo", searchTerm).boost(1);
            final QueryBuilder query11 = QueryBuilders.matchQuery("item_name_ngram", searchTerm).boost(1);
            final QueryBuilder query12 = QueryBuilders.matchQuery("brand_kr,", searchTerm).boost(3);
            final QueryBuilder query13 = QueryBuilders.matchQuery("brand_kr_ngram", searchTerm).boost(3);
            final QueryBuilder query14 = QueryBuilders.matchQuery("brand_kr_eng2kor", searchTerm).boost(3);
            final QueryBuilder query15 = QueryBuilders.matchQuery("brand_kr_chosung", searchTerm).boost(3);
            final QueryBuilder query16 = QueryBuilders.termQuery("brand_kr_jamo,", searchTerm).boost(3);
            final QueryBuilder query17 = QueryBuilders.matchQuery("brand_en", searchTerm).boost(3);
            final QueryBuilder query18 = QueryBuilders.matchQuery("brand_en_ngram", searchTerm).boost(3);
            final QueryBuilder query19 = QueryBuilders.matchQuery("celeb_name_kr_ngram,", searchTerm).boost(5);
            final QueryBuilder query20 = QueryBuilders.matchQuery("celeb_name_kr", searchTerm).boost(5);
            final QueryBuilder query21 = QueryBuilders.matchQuery("celeb_name_kr_eng2kor", searchTerm).boost(5);
            final QueryBuilder query22 = QueryBuilders.matchQuery("celeb_name_kr_chosung", searchTerm).boost(5);
            final QueryBuilder query23 = QueryBuilders.termQuery("celeb_name_kr_jamo,", searchTerm).boost(5);
            final QueryBuilder query24 = QueryBuilders.matchQuery("celeb_name_en", searchTerm).boost(5);
            final QueryBuilder query25 = QueryBuilders.matchQuery("celeb_name_en_ngram", searchTerm).boost(5);
            final QueryBuilder query26 = QueryBuilders.matchQuery("group_celeb_name_kr_ngram,", searchTerm).boost(3);
            final QueryBuilder query27 = QueryBuilders.matchQuery("group_celeb_name_kr", searchTerm).boost(3);
            final QueryBuilder query28 = QueryBuilders.matchQuery("group_celeb_name_kr_eng2kor", searchTerm).boost(3);
            final QueryBuilder query29 = QueryBuilders.matchQuery("group_celeb_name_kr_chosung", searchTerm).boost(3);
            final QueryBuilder query30 = QueryBuilders.termQuery("group_celeb_name_kr_jamo,", searchTerm).boost(3);
            final QueryBuilder query31 = QueryBuilders.matchQuery("group_celeb_name_en", searchTerm).boost(3);
            final QueryBuilder query32 = QueryBuilders.matchQuery("group_celeb_name_en_ngram", searchTerm).boost(3);
            final QueryBuilder query33 = QueryBuilders.matchQuery("category_name", searchTerm);
            final QueryBuilder query34 = QueryBuilders.matchQuery("category_name_ngram", searchTerm);
            final QueryBuilder query35 = QueryBuilders.matchQuery("category_name_kr_ngram", searchTerm);
            final QueryBuilder query36 = QueryBuilders.matchQuery("category_name_kr_eng2kor", searchTerm);
            final QueryBuilder query37 = QueryBuilders.matchQuery("category_name_kr_chosung", searchTerm);
            final QueryBuilder query38 = QueryBuilders.termQuery("category_name_kr_jamo,", searchTerm);
            final QueryBuilder query39 = QueryBuilders.matchQuery("sub_category_name", searchTerm);
            final QueryBuilder query40 = QueryBuilders.matchQuery("sub_category_name_ngram", searchTerm);
            final QueryBuilder query41 = QueryBuilders.matchQuery("sub_category_name_kr_ngram", searchTerm);
            final QueryBuilder query42 = QueryBuilders.matchQuery("sub_category_name_kr_eng2kor", searchTerm);
            final QueryBuilder query43 = QueryBuilders.matchQuery("sub_category_name_kr_chosung", searchTerm);
            final QueryBuilder query44 = QueryBuilders.termQuery("sub_category_name_kr_jamo,", searchTerm);
            final QueryBuilder query45 = QueryBuilders.matchQuery("celeb_name_kr_synom", searchTerm).boost(5);
            final QueryBuilder query46 = QueryBuilders.matchQuery("group_celeb_name_kr_synom", searchTerm).boost(3);
            final QueryBuilder query47 = QueryBuilders.matchQuery("category_name_kr_synom", searchTerm);
            final QueryBuilder query48 = QueryBuilders.matchQuery("sub_category_name_kr_synom", searchTerm);



            BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
                    .should(query1).should(query2).should(query3).should(query4).should(query5).should(query6)
                    .should(query7).should(query8).should(query9).should(query10).should(query11).should(query12)
                    .should(query13).should(query14).should(query15).should(query16).should(query17).should(query18)
                    .should(query19).should(query20).should(query21).should(query22).should(query23).should(query24)
                    .should(query25).should(query26).should(query27).should(query28).should(query29).should(query30)
                    .should(query31).should(query32).should(query33).should(query34).should(query35).should(query36)
                    .should(query37).should(query38).should(query39).should(query40).should(query41).should(query42)
                    .should(query43).should(query44).should(query45).should(query46).should(query47).should(query48)
                    .minimumShouldMatch(1);
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(boolQuery).trackTotalHits(true).size(1000);
            SearchRequest request = new SearchRequest("search1"); //
            request.source(searchSourceBuilder);
            return request;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    // 질문 검색
    public static SearchRequest firstSearch2(final SearchRequestDTO dto){
        if (dto == null) return null;
        try {
            final String searchTerm = dto.getSearchTerm();
            final QueryBuilder query1 = QueryBuilders.matchQuery("title", searchTerm);
            final QueryBuilder query2 = QueryBuilders.matchQuery("title_ngram", searchTerm);
            final QueryBuilder query3 = QueryBuilders.matchQuery("title_kr_eng2kor", searchTerm);
            final QueryBuilder query4 = QueryBuilders.matchQuery("title_kr_chosung", searchTerm);
            final QueryBuilder query5 = QueryBuilders.termQuery("title_kr_jamo", searchTerm);
            final QueryBuilder query6 = QueryBuilders.matchQuery("celeb_name_kr", searchTerm);
            final QueryBuilder query7 = QueryBuilders.matchQuery("celeb_name_kr_ngram", searchTerm);
            final QueryBuilder query8 = QueryBuilders.matchQuery("celeb_name_kr_eng2kor", searchTerm);
            final QueryBuilder query9 = QueryBuilders.matchQuery("celeb_name_kr_chosung", searchTerm);
            final QueryBuilder query10 = QueryBuilders.termQuery("celeb_name_kr_jamo", searchTerm);
            final QueryBuilder query11 = QueryBuilders.matchQuery("celeb_name_en", searchTerm);
            final QueryBuilder query12 = QueryBuilders.matchQuery("celeb_name_en_ngram", searchTerm);
            final QueryBuilder query13 = QueryBuilders.matchQuery("group_celeb_name_kr_ngram,", searchTerm);
            final QueryBuilder query14 = QueryBuilders.matchQuery("group_celeb_name_kr", searchTerm);
            final QueryBuilder query15 = QueryBuilders.matchQuery("group_celeb_name_kr_eng2kor", searchTerm);
            final QueryBuilder query16 = QueryBuilders.matchQuery("group_celeb_name_kr_chosung", searchTerm);
            final QueryBuilder query17 = QueryBuilders.termQuery("group_celeb_name_kr_jamo,", searchTerm);
            final QueryBuilder query18 = QueryBuilders.matchQuery("group_celeb_name_en", searchTerm);
            final QueryBuilder query19 = QueryBuilders.matchQuery("group_celeb_name_en_ngram", searchTerm);
            final QueryBuilder query20 = QueryBuilders.matchQuery("celeb_name_kr_synom", searchTerm);
            final QueryBuilder query21 = QueryBuilders.matchQuery("group_celeb_name_kr_synom", searchTerm);



            BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
                    .should(query1).should(query2).should(query3).should(query4).should(query5)
                    .should(query6).should(query7).should(query8).should(query9).should(query10).should(query11).should(query12)
                    .should(query13).should(query14).should(query15).should(query16).should(query17).should(query18).should(query19)
                    .should(query20).should(query21).minimumShouldMatch(1);
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(boolQuery).trackTotalHits(true).size(1000);
            SearchRequest request = new SearchRequest("search2"); //
            request.source(searchSourceBuilder);
            return request;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 유저 검색
    public static SearchRequest firstSearch3(final SearchRequestDTO dto){
        if (dto == null) return null;
        try {
            final String searchTerm = dto.getSearchTerm();
            final QueryBuilder query1 = QueryBuilders.matchQuery("nickname", searchTerm).boost(3);
            final QueryBuilder query2 = QueryBuilders.matchQuery("nickname_ngram", searchTerm);
            final QueryBuilder query3 = QueryBuilders.matchQuery("nickname_kr_eng2kor", searchTerm);
            final QueryBuilder query4 = QueryBuilders.matchQuery("nickname_kr_chosung", searchTerm);
            final QueryBuilder query5 = QueryBuilders.termQuery("nickname_kr_jamo", searchTerm);

            BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
                    .should(query1).should(query2).should(query3).should(query4).should(query5).minimumShouldMatch(1);
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(boolQuery).trackTotalHits(true).size(1000);
            SearchRequest request = new SearchRequest("search3");
            request.source(searchSourceBuilder);
            return request;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

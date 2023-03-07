package com.tree.elasticsearch.service;


import lombok.RequiredArgsConstructor;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;

import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.springframework.stereotype.Service;


@Service(value = "testService")
@RequiredArgsConstructor
public class TestService {
    private final RestHighLevelClient client;

    public SearchHit[] searchInternal(SearchRequest request){
        if (request == null){
            System.out.println("Request null error");
            return null;
        }
        try {
            final SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            final SearchHit[] searchHits = response.getHits().getHits();
            return searchHits;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

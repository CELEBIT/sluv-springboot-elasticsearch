package com.tree.elasticsearch.controller;

import com.tree.elasticsearch.search.SearchRequestDTO;
import com.tree.elasticsearch.search.util.TestSearchUtil;
import com.tree.elasticsearch.service.IndexService;
import com.tree.elasticsearch.service.TestService;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.search.SearchHit;
import org.json.JSONArray;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;
    private final IndexService indexService;

    @GetMapping("/search/elasticsearch")
    public JSONArray searchGet(@RequestParam String searchTerm, Model model) throws Exception {

        SearchRequestDTO dto = new SearchRequestDTO();
        dto.setSearchTerm(searchTerm);

        // 먼저 똑같은 것만 검색
        SearchRequest request1 = TestSearchUtil.firstSearch1(dto);
        // 다른 경우 검색
        SearchRequest request2 = TestSearchUtil.firstSearch2(dto);

        SearchHit[] searchHits1 = testService.searchInternal(request1);
        SearchHit[] searchHits2 = testService.searchInternal(request2);

        JSONArray result = new JSONArray();
        JSONArray test = new JSONArray();

        //11개의 인덱스
        if (searchHits1.length > 0) {
            for (SearchHit hit : searchHits1){
                switch (hit.getIndex()){
                    case "test":
                        test.put(hit);
                        break;

                    default:
                        System.out.println(hit.getIndex());
                        break;
                }
            }
        }
        if (searchHits2.length > 0){
            for (SearchHit hit : searchHits2){
                switch (hit.getIndex()){
                    case "test":
                        test.put(hit);
                        break;

                    default:
                        System.out.println(hit.getIndex());
                        break;
                }
            }
        }

        result.put(test);

        return result;
    }

}

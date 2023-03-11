package com.tree.elasticsearch.controller;

import com.tree.elasticsearch.search.SearchRequestDTO;
import com.tree.elasticsearch.search.util.SearchUtil;
import com.tree.elasticsearch.service.IndexService;
import com.tree.elasticsearch.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.search.SearchHit;
import org.json.JSONArray;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;
    private final IndexService indexService;

    @GetMapping("/search/elasticsearch")
    public JSONArray searchGet(@RequestParam String searchTerm, Model model) throws Exception {

        SearchRequestDTO dto = new SearchRequestDTO();
        dto.setSearchTerm(searchTerm);

        // 먼저 똑같은 것만 검색
        SearchRequest request1 = SearchUtil.firstSearch1(dto);
        // 다른 경우 검색
        SearchRequest request2 = SearchUtil.firstSearch2(dto);

        SearchHit[] searchHits1 = searchService.searchInternal(request1);
        SearchHit[] searchHits2 = searchService.searchInternal(request2);

        JSONArray result = new JSONArray();
        JSONArray test = new JSONArray();

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


    @GetMapping("/api/resetAllIndexes")
    public String reset() throws Exception {
        indexService.createIndexes(true);
        return "Index Reset Done";
    }

}

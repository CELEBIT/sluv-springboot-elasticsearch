package com.tree.elasticsearch.controller;

import com.tree.elasticsearch.search.SearchRequestDTO;
import com.tree.elasticsearch.search.util.TestSearchUtil;
import com.tree.elasticsearch.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.search.SearchHit;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.tree.elasticsearch.service.TestService;


@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;
    private final IndexService indexService;

    @GetMapping("/search/elasticsearch")
    public JSONArray searchGet( @RequestParam String searchTerm, Model model) throws Exception {

        SearchRequestDTO dto = new SearchRequestDTO();
        dto.setSearchTerm(searchTerm);

        SearchRequest request1 = TestSearchUtil.testSearch(dto);
        SearchHit[] searchHits1 = testService.searchInternal(request1);

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

        result.put(test);
        return result;
    }

    //post 방식도 존재
    @PostMapping("/elasticsearch/search")
    public JSONArray getSearch(@RequestBody SearchRequestDTO dto, ModelMap model) throws JSONException {

        SearchRequest request1 = TestSearchUtil.testSearch(dto);
        SearchHit[] searchHits1 = testService.searchInternal(request1);


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

        result.put(test);
        return result;
    }

    @GetMapping("/api/{searchTerm}")
    public JSONArray searchList(@PathVariable("searchTerm") String searchTerm, ModelMap model) throws Exception {
        SearchRequestDTO dto = new SearchRequestDTO();
        dto.setSearchTerm(searchTerm);
        SearchRequest request = TestSearchUtil.testSearch(dto);
        SearchHit[] searchHits = testService.searchInternal(request);
        // test
        System.out.println(searchHits.length);
        JSONArray result = new JSONArray();
        JSONArray test = new JSONArray();

        for (SearchHit hit : searchHits) {
            if ("test".equals(hit.getIndex())) {
                test.put(hit);
            }
        }

        result.put(test);
        return result;
    }

    @GetMapping("/api/api/resetAllIndexes")
    public String reset() throws Exception {
        indexService.createIndexes(true);
        return "Index Reset Done";
    }
}

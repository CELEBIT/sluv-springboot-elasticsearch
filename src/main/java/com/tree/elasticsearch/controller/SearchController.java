package com.tree.elasticsearch.controller;

import com.tree.elasticsearch.search.SearchRequestDTO;
import com.tree.elasticsearch.search.util.SearchUtil;
import com.tree.elasticsearch.service.IndexService;
import com.tree.elasticsearch.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.search.SearchHit;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;
    private final IndexService indexService;

    @GetMapping("/search/searchItem")
    public JSONArray searchGet(@RequestParam String searchTerm, Model model) throws Exception {

        SearchRequestDTO dto = new SearchRequestDTO();
        dto.setSearchTerm(searchTerm);

        SearchRequest request1 = SearchUtil.firstSearch1(dto);
        SearchHit[] searchHits1 = searchService.searchInternal(request1);
        JSONArray result = new JSONArray();
        JSONArray search1 = new JSONArray();


        if (searchHits1.length > 0) {
            for (SearchHit hit : searchHits1){
                switch (hit.getIndex()){
                    case "search1":
                        //search1.put(hit);
                        search1.put(hit.getId());
                        break;

                    default:
                        System.out.println(hit.getIndex());
                        break;
                }
            }
        }

        result.put(search1);
        return result;
    }



    @GetMapping("/search/searchQuestion")
    public JSONArray searchQuestion(@RequestParam String searchTerm, Model model) throws Exception {

        SearchRequestDTO dto = new SearchRequestDTO();
        dto.setSearchTerm(searchTerm);
        SearchRequest request2 = SearchUtil.firstSearch2(dto);
        SearchHit[] searchHits2 = searchService.searchInternal(request2);
        JSONArray result = new JSONArray();
        JSONArray search2 = new JSONArray();

        if (searchHits2.length > 0) {
            for (SearchHit hit : searchHits2){
                switch (hit.getIndex()){
                    case "search2":
                        //search2.put(hit);
                        search2.put(hit.getId());
                        break;

                    default:
                        System.out.println(hit.getIndex());
                        break;
                }
            }
        }

        result.put(search2);
        return result;
    }

    @GetMapping("/search/searchUser")
    public JSONArray searchUser(@RequestParam String searchTerm, Model model) throws Exception {

        SearchRequestDTO dto = new SearchRequestDTO();
        dto.setSearchTerm(searchTerm);
        SearchRequest request3 = SearchUtil.firstSearch3(dto);
        SearchHit[] searchHits3 = searchService.searchInternal(request3);
        JSONArray result = new JSONArray();
        JSONArray search3 = new JSONArray();

        if (searchHits3.length > 0) {
            for (SearchHit hit : searchHits3){
                switch (hit.getIndex()){
                    case "search3":
                        //search3.put(hit);
                        search3.put(hit.getId());
                        break;

                    default:
                        System.out.println(hit.getIndex());
                        break;
                }
            }
        }

        result.put(search3);

        return result;
    }


    @GetMapping("/api/resetAllIndexes")
    public String reset() throws Exception {
        indexService.createIndexes(true);
        return "Index Reset Done";
    }

}

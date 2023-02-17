package com.tree.elasticsearch.controller;

import com.tree.elasticsearch.search.SearchRequestDTO;
import com.tree.elasticsearch.search.util.ListSearchUtil;
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


//searchHit이 뭐지?
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

        SearchRequest request1 = ListSearchUtil.firstSearch1(dto);
        SearchRequest request2 = ListSearchUtil.firstSearch2(dto);
        SearchRequest request3 = ListSearchUtil.gigwanSearch1(dto);
        SearchRequest request4 = ListSearchUtil.gigwanSearch2(dto);
        SearchHit[] searchHits1 = testService.searchInternal(request1);
        SearchHit[] searchHits2 = testService.searchInternal(request2);
        SearchHit[] searchHits3 = testService.searchInternal(request3);
        SearchHit[] searchHits4 = testService.searchInternal(request4);

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
        if (searchHits3.length > 0){
            for (SearchHit hit : searchHits3){
                switch (hit.getIndex()){
                    case "list3":
                        list3.put(hit);
                        break;
                    case "list4":
                        list4.put(hit);
                        break;
                    case "list5":
                        list5.put(hit);
                        break;
                    case "list6":
                        list6.put(hit);
                        break;
                    case "list7":
                        list7.put(hit);
                        break;
                    case "list8":
                        list8.put(hit);
                        break;
                    case "list9":
                        list9.put(hit);
                        break;
                    case "list10":
                        list10.put(hit);
                        break;
                    case "list11":
                        list11.put(hit);
                        break;
                    default:
                        System.out.println(hit.getIndex());
                        break;
                }
            }
        }
        if (searchHits4.length > 0){
            for (SearchHit hit : searchHits4){
                switch (hit.getIndex()){
                    case "list3":
                        list3.put(hit);
                        break;
                    case "list4":
                        list4.put(hit);
                        break;
                    case "list5":
                        list5.put(hit);
                        break;
                    case "list6":
                        list6.put(hit);
                        break;
                    case "list7":
                        list7.put(hit);
                        break;
                    case "list8":
                        list8.put(hit);
                        break;
                    case "list9":
                        list9.put(hit);
                        break;
                    case "list10":
                        list10.put(hit);
                        break;
                    case "list11":
                        list11.put(hit);
                        break;
                    default:
                        System.out.println(hit.getIndex());
                        break;
                }
            }
        }
        result.put(list1);
        result.put(list2);
        result.put(list3);
        result.put(list4);
        result.put(list5);
        result.put(list6);
        result.put(list7);
        result.put(list8);
        result.put(list9);
        result.put(list10);
        result.put(list11);
        return result;
    }

    @PostMapping("/elasticsearch/search")
    public JSONArray getSearch(@RequestBody SearchRequestDTO dto, ModelMap model) throws JSONException {

        SearchRequest request1 = ListSearchUtil.firstSearch1(dto);
        SearchRequest request2 = ListSearchUtil.firstSearch2(dto);
        SearchRequest request3 = ListSearchUtil.gigwanSearch1(dto);
        SearchRequest request4 = ListSearchUtil.gigwanSearch2(dto);
        SearchHit[] searchHits1 = testService.searchInternal(request1);
        SearchHit[] searchHits2 = testService.searchInternal(request2);
        SearchHit[] searchHits3 = testService.searchInternal(request3);
        SearchHit[] searchHits4 = testService.searchInternal(request4);

        JSONArray result = new JSONArray();
        JSONArray list1 = new JSONArray();
        JSONArray list2 = new JSONArray();
        JSONArray list3 = new JSONArray();
        JSONArray list4 = new JSONArray();
        JSONArray list5 = new JSONArray();
        JSONArray list6 = new JSONArray();
        JSONArray list7 = new JSONArray();
        JSONArray list8 = new JSONArray();
        JSONArray list9 = new JSONArray();
        JSONArray list10 = new JSONArray();
        JSONArray list11 = new JSONArray();
        if (searchHits1.length > 0) {
            for (SearchHit hit : searchHits1){
                switch (hit.getIndex()){
                    case "list1":
                        list1.put(hit);
                        break;
                    case "list2":
                        list2.put(hit);
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
                    case "list1":
                        list1.put(hit);
                        break;
                    case "list2":
                        list2.put(hit);
                        break;
                    default:
                        System.out.println(hit.getIndex());
                        break;
                }
            }
        }
        if (searchHits3.length > 0){
            for (SearchHit hit : searchHits3){
                switch (hit.getIndex()){
                    case "list3":
                        list3.put(hit);
                        break;
                    case "list4":
                        list4.put(hit);
                        break;
                    case "list5":
                        list5.put(hit);
                        break;
                    case "list6":
                        list6.put(hit);
                        break;
                    case "list7":
                        list7.put(hit);
                        break;
                    case "list8":
                        list8.put(hit);
                        break;
                    case "list9":
                        list9.put(hit);
                        break;
                    case "list10":
                        list10.put(hit);
                        break;
                    case "list11":
                        list11.put(hit);
                        break;
                    default:
                        System.out.println(hit.getIndex());
                        break;
                }
            }
        }
        if (searchHits4.length > 0){
            for (SearchHit hit : searchHits4){
                switch (hit.getIndex()){
                    case "list3":
                        list3.put(hit);
                        break;
                    case "list4":
                        list4.put(hit);
                        break;
                    case "list5":
                        list5.put(hit);
                        break;
                    case "list6":
                        list6.put(hit);
                        break;
                    case "list7":
                        list7.put(hit);
                        break;
                    case "list8":
                        list8.put(hit);
                        break;
                    case "list9":
                        list9.put(hit);
                        break;
                    case "list10":
                        list10.put(hit);
                        break;
                    case "list11":
                        list11.put(hit);
                        break;
                    default:
                        System.out.println(hit.getIndex());
                        break;
                }
            }
        }
        result.put(list1);
        result.put(list2);
        result.put(list3);
        result.put(list4);
        result.put(list5);
        result.put(list6);
        result.put(list7);
        result.put(list8);
        result.put(list9);
        result.put(list10);
        result.put(list11);
        return result;
    }

    @GetMapping("/api/{searchTerm}")
    public JSONArray searchList(@PathVariable("searchTerm") String searchTerm, ModelMap model) throws Exception {
        SearchRequestDTO dto = new SearchRequestDTO();
        dto.setSearchTerm(searchTerm);
        SearchRequest request = ListSearchUtil.listSearch1(dto);
        SearchRequest request2 = ListSearchUtil.listSearch2(dto);
        SearchHit[] searchHits = testService.searchInternal(request);
        SearchHit[] searchHits2 = testService.searchInternal(request2);
        // test
        System.out.println(searchHits.length);
        JSONArray result = new JSONArray();
        JSONArray list1 = new JSONArray();
        JSONArray list2 = new JSONArray();
        JSONArray list3 = new JSONArray();
        JSONArray list4 = new JSONArray();
        JSONArray list5 = new JSONArray();
        JSONArray list6 = new JSONArray();
        JSONArray list7 = new JSONArray();
        JSONArray list8 = new JSONArray();
        JSONArray list9 = new JSONArray();
        JSONArray list10 = new JSONArray();
        JSONArray list11 = new JSONArray();
        for (SearchHit hit : searchHits) {
            if ("list1".equals(hit.getIndex())) {
                list1.put(hit);
            } else if ("list2".equals(hit.getIndex())) {
                list2.put(hit);
            } else if ("list3".equals(hit.getIndex())) {
                list3.put(hit);
            } else if ("list4".equals(hit.getIndex())) {
                list4.put(hit);
            } else if ("list5".equals(hit.getIndex())) {
                list5.put(hit);
            } else if ("list6".equals(hit.getIndex())) {
                list6.put(hit);
            } else if ("list7".equals(hit.getIndex())) {
                list7.put(hit);
            } else if ("list8".equals(hit.getIndex())) {
                list8.put(hit);
            } else if ("list9".equals(hit.getIndex())) {
                list9.put(hit);
            } else if ("list10".equals(hit.getIndex())) {
                list10.put(hit);
            } else if ("list11".equals(hit.getIndex())) {
                list11.put(hit);
            }
        }
        for (SearchHit hit : searchHits2){
            if ("list1".equals(hit.getIndex())){
                list1.put(hit);
            } else if ("list2".equals(hit.getIndex())) {
                list2.put(hit);
            } else if ("list3".equals(hit.getIndex())) {
                list3.put(hit);
            } else if ("list4".equals(hit.getIndex())) {
                list4.put(hit);
            } else if ("list5".equals(hit.getIndex())) {
                list5.put(hit);
            } else if ("list6".equals(hit.getIndex())) {
                list6.put(hit);
            } else if ("list7".equals(hit.getIndex())) {
                list7.put(hit);
            } else if ("list8".equals(hit.getIndex())) {
                list8.put(hit);
            } else if ("list9".equals(hit.getIndex())) {
                list9.put(hit);
            } else if ("list10".equals(hit.getIndex())) {
                list10.put(hit);
            } else if ("list11".equals(hit.getIndex())) {
                list11.put(hit);
            }
        }
        result.put(list1);
        result.put(list2);
        result.put(list3);
        result.put(list4);
        result.put(list5);
        result.put(list6);
        result.put(list7);
        result.put(list8);
        result.put(list9);
        result.put(list10);
        result.put(list11);
        return result;
    }

    @GetMapping("/api/api/resetAllIndexes")
    public String reset() throws Exception {
        indexService.createIndexes(true);
        return "Index Reset Done";
    }
}

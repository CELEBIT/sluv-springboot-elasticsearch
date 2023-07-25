package com.tree.elasticsearch.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tree.elasticsearch.document.*;
import com.tree.elasticsearch.search.SearchRequestDTO;
import com.tree.elasticsearch.search.util.SearchUtil;
import com.tree.elasticsearch.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.search.SearchHit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ExampleController {

    private final SearchService searchService;
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @GetMapping("/example/{searchTerm}")
    public String searchList(@PathVariable("searchTerm") String searchTerm, ModelMap model) throws Exception {
        SearchRequestDTO dto = new SearchRequestDTO();
        dto.setSearchTerm(searchTerm);
        SearchRequest request = SearchUtil.firstSearch1(dto);
        SearchHit[] searchHits = searchService.searchInternal(request);
        System.out.println(searchHits.length);
        List<search1> test = new ArrayList<>();

        for (SearchHit hit : searchHits){
            if ("test".equals(hit.getIndex())){
                test.add(MAPPER.readValue(hit.getSourceAsString(), search1.class));
            }
        }

        model.addAttribute("test", test);
        return "example";
    }


    @GetMapping("/testing")
    public String testing( ModelMap model) throws Exception {
        model.addAttribute("test", "test");
        return "example";
    }

}

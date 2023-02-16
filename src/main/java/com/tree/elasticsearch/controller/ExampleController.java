package com.tree.elasticsearch.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tree.elasticsearch.document.*;
import com.tree.elasticsearch.search.SearchRequestDTO;
import com.tree.elasticsearch.search.util.ListSearchUtil;
import com.tree.elasticsearch.service.TestService;
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

    private final TestService testService;
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @GetMapping("/example/{searchTerm}")
    public String searchList(@PathVariable("searchTerm") String searchTerm, ModelMap model) throws Exception {
        SearchRequestDTO dto = new SearchRequestDTO();
        dto.setSearchTerm(searchTerm);
        SearchRequest request = ListSearchUtil.listSearch1(dto);
        SearchRequest request2 = ListSearchUtil.listSearch2(dto);
        SearchHit[] searchHits = testService.searchInternal(request);
        SearchHit[] searchHits2 = testService.searchInternal(request2);

        System.out.println(searchHits.length);
        System.out.println(searchHits2.length);


        List<Test> test = new ArrayList<>();


        for (SearchHit hit : searchHits){
            if ("test".equals(hit.getIndex())){
                test.add(MAPPER.readValue(hit.getSourceAsString(), Test.class));
            }
        }

        for (SearchHit hit : searchHits2){
            if ("test".equals(hit.getIndex())){
                test.add(MAPPER.readValue(hit.getSourceAsString(), Test.class));
            }
        }

        model.addAttribute("test", test);

        return "example";
    }

}

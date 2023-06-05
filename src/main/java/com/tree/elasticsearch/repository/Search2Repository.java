package com.tree.elasticsearch.repository;


import com.tree.elasticsearch.document.search2;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Search2Repository extends ElasticsearchRepository<search2, Integer> {
}

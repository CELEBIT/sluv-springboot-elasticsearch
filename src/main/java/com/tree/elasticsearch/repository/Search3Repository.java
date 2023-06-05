package com.tree.elasticsearch.repository;


import com.tree.elasticsearch.document.search3;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Search3Repository extends ElasticsearchRepository<search3, Integer> {
}

package com.tree.elasticsearch.repository;


import com.tree.elasticsearch.document.Search3;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Search3Repository extends ElasticsearchRepository<Search3, Integer> {
}

package com.tree.elasticsearch.repository;


import com.tree.elasticsearch.document.Search2;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Search2Repository extends ElasticsearchRepository<Search2, Integer> {
}

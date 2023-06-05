package com.tree.elasticsearch.repository;

import com.tree.elasticsearch.document.search1;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Search1Repository extends ElasticsearchRepository<search1, Integer> {
}

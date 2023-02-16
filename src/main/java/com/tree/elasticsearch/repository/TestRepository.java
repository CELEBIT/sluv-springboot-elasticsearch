package com.tree.elasticsearch.repository;

import com.tree.elasticsearch.document.Test;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends ElasticsearchRepository<Test, Integer> {
}

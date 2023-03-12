package com.tree.elasticsearch.repository;

import com.tree.elasticsearch.document.Search1;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchUserRepository extends ElasticsearchRepository<Search1, Integer> {
}

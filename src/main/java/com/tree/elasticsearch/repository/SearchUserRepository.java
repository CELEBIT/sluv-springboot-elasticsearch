package com.tree.elasticsearch.repository;

import com.tree.elasticsearch.document.SearchItem;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchUserRepository extends ElasticsearchRepository<SearchItem, Integer> {
}

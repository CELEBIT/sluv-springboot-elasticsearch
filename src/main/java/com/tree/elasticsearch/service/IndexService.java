package com.tree.elasticsearch.service;

import com.tree.elasticsearch.helper.Util;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IndexService {
    private RestHighLevelClient client;
    @Autowired
    public IndexService(RestHighLevelClient client) { this.client = client; }
    private static final Logger LOG = LoggerFactory.getLogger(Util.class);

//    @PostConstruct
//    public void createIndices() { createIndexes(false); }

    private String loadMappings(String indexName) {
        final String mappings = Util.loadAsString("static/mappings/"+indexName+".json");
        if (mappings == null) {
            LOG.error("Failed to load mappings...");
            return null;
        }
        return mappings;
    }

    //인덱스 생성
    public void createIndexes(final boolean deleteExisting) {
        for (int i = 1; i < 4; i++) {
            String settings = Util.loadAsString("static/search" + Integer.toString(i) + "_settings.json");
            if (settings == null) {
                LOG.error("Failed to load settings for search" + Integer.toString(i));
            }
            String indexName = "search" + Integer.toString(i);
            try {
                boolean indexExists = client.indices().exists(new GetIndexRequest(indexName), RequestOptions.DEFAULT);
                if (indexExists) {
                    if (!deleteExisting) {
                        throw new Exception();
                    }
                    client.indices().delete(new DeleteIndexRequest(indexName), RequestOptions.DEFAULT);
                }
                CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
                createIndexRequest.settings(settings, XContentType.JSON);
                String mappings = loadMappings(indexName);
                if (mappings != null) {

                    createIndexRequest.mapping(mappings, XContentType.JSON);
                }
                client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }
}

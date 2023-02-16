package com.tree.elasticsearch.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;


@Data
@Document(indexName = "test")
@JsonIgnoreProperties(ignoreUnknown = true)
@Setting(settingPath = "static/test_settings.json")
public class Test {

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String address;

    @Id
    @Field(type = FieldType.Keyword)
    private int row_num;


}

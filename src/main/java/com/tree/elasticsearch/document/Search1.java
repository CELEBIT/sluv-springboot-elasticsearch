package com.tree.elasticsearch.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;


@Data
@Document(indexName = "search1")
@JsonIgnoreProperties(ignoreUnknown = true)
@Setting(settingPath = "static/search1_settings.json")
public class Search1 {


    @Field(type = FieldType.Keyword)
    private String item_status;


    @Field(type = FieldType.Text)
    private String where_discovery;



    @Field(type = FieldType.Text)
    private String korname_eng2kor;


    @Field(type = FieldType.Text)
    private String korname_chosung;


    @Field(type = FieldType.Text)
    private String korname_jamo;



    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String address;

    @Id
    @Field(type = FieldType.Keyword)
    private int mountainidx;


}

package com.tree.elasticsearch.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;


@Data
@Document(indexName = "searchItem")
@JsonIgnoreProperties(ignoreUnknown = true)
@Setting(settingPath = "static/searchItem_settings.json")
public class SearchItem {


    @Field(type = FieldType.Text)
    private String korname_ngram;


    @Field(type = FieldType.Text)
    private String name_nram;


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

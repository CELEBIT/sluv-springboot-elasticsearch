package com.tree.elasticsearch.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;


@Data
//Document에 name들도 다 들어가야함 ex. korName ..
@Document(indexName = "search3")
@JsonIgnoreProperties(ignoreUnknown = true)
@Setting(settingPath = "static/search3_settings.json")
public class Search3 {

    @Id
    @Field(type = FieldType.Integer)
    private String user_id;


    @Field(type = FieldType.Text)
    private String nickname;


    @Field(type = FieldType.Text)
    private String nickname_ngram;


    @Field(type = FieldType.Text)
    private String nickname_kr_chosung;


    @Field(type = FieldType.Text)
    private String nickname_kr_jamo;



    @Field(type = FieldType.Date)
    private String created_at;

    @Field(type = FieldType.Keyword)
    private String user_status;




}
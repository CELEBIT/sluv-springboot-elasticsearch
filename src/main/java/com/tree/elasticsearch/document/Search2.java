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
@Document(indexName = "search2")
@JsonIgnoreProperties(ignoreUnknown = true)
@Setting(settingPath = "static/search2_settings.json")
public class Search2 {

    @Id
    @Field(type = FieldType.Integer)
    private int question_id;

    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Text)
    private String title_ngram;


    @Field(type = FieldType.Text)
    private String title_kr_eng2kor;


    @Field(type = FieldType.Text)
    private String title_kr_chosung;


    @Field(type = FieldType.Text)
    private String title_kr_jamo;

    @Field(type = FieldType.Text)
    private String celeb_name_kr;

    @Field(type = FieldType.Text)
    private String celeb_name_kr_ngram;

    @Field(type = FieldType.Text)
    private String celeb_name_kr_eng2kor;

    @Field(type = FieldType.Text)
    private String celeb_name_kr_chosung;

    @Field(type = FieldType.Text)
    private String celeb_name_kr_jamo;

    @Field(type = FieldType.Text)
    private String celeb_name_en;

    @Field(type = FieldType.Text)
    private String celeb_name_en_ngram;


    @Field(type = FieldType.Keyword)
    private String question_status;


    @Field(type = FieldType.Date)
    private String created_at;



}

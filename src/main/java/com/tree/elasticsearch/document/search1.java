package com.tree.elasticsearch.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;
import java.util.Date;


@Data
@Document(indexName = "search1")
@JsonIgnoreProperties(ignoreUnknown = true)
@Setting(settingPath = "static/search1_settings.json")
public class search1 {

    @Id
    @Field(type = FieldType.Integer)
    private int item_id;

    @Field(type = FieldType.Keyword)
    private String item_status;

    @Field(type = FieldType.Text)
    private String where_discovery;

    @Field(type = FieldType.Text)
    private String where_discovery_ngram;

    @Field(type = FieldType.Text)
    private String where_discovery_kr_eng2kor;

    @Field(type = FieldType.Text)
    private String where_discovery_kr_chosung;

    @Field(type = FieldType.Text)
    private String where_discovery_kr_jamo;

    @Field(type = FieldType.Text)
    private String item_name;

    @Field(type = FieldType.Text)
    private String item_name_kr_eng2kor;

    @Field(type = FieldType.Text)
    private String item_name_kr_chosung;

    @Field(type = FieldType.Text)
    private String item_name_kr_jamo;

    @Field(type = FieldType.Text)
    private String item_name_ngram;

    @Field(type = FieldType.Text)
    private String brand_kr;

    @Field(type = FieldType.Text)
    private String brand_kr_ngram;

    @Field(type = FieldType.Text)
    private String brand_kr_eng2kor;

    @Field(type = FieldType.Text)
    private String brand_kr_chosung;

    @Field(type = FieldType.Text)
    private String brand_kr_jamo;

    @Field(type = FieldType.Text)
    private String brand_en;

    @Field(type = FieldType.Text)
    private String brand_en_ngram;

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
    private String celeb_name_kr_sysnom;

    @Field(type = FieldType.Text)
    private String celeb_name_en;

    @Field(type = FieldType.Text)
    private String celeb_name_en_engram;

    @Field(type = FieldType.Text)
    private String group_celeb_name_kr;

    @Field(type = FieldType.Text)
    private String group_celeb_name_kr_ngram;

    @Field(type = FieldType.Text)
    private String group_celeb_name_kr_eng2kor;

    @Field(type = FieldType.Text)
    private String group_celeb_name_kr_chosung;

    @Field(type = FieldType.Text)
    private String group_celeb_name_kr_jamo;

    @Field(type = FieldType.Text)
    private String group_celeb_name_kr_sysnom;

    @Field(type = FieldType.Text)
    private String group_celeb_name_en;

    @Field(type = FieldType.Text)
    private String group_celeb_name_en_ngram;

    @Field(type = FieldType.Text)
    private String category_name;

    @Field(type = FieldType.Text)
    private String category_name_ngram;

    @Field(type = FieldType.Text)
    private String category_name_kr_eng2kor;

    @Field(type = FieldType.Text)
    private String category_name_kr_chosung;

    @Field(type = FieldType.Text)
    private String category_name_kr_jamo;

    @Field(type = FieldType.Text)
    private String category_name_kr_synom;

    @Field(type = FieldType.Text)
    private String sub_category_name;

    @Field(type = FieldType.Text)
    private String sub_category_name_ngram;

    @Field(type = FieldType.Text)
    private String sub_category_name_kr_eng2kor;

    @Field(type = FieldType.Text)
    private String sub_category_name_kr_chosung;

    @Field(type = FieldType.Text)
    private String sub_category_name_kr_jamo;

    @Field(type = FieldType.Text)
    private String sub_category_name_kr_synom;

    @Field(type = FieldType.Date)
    private Date created_at;





}

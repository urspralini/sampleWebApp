package com.prabhu.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by prabhu on 1/10/16.
 */
@Document(collection = "agency")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Agency extends BaseModel{
    private String tag;
    private String title;
    private String regionTitle;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegionTitle() {
        return regionTitle;
    }

    public void setRegionTitle(String regionTitle) {
        this.regionTitle = regionTitle;
    }
}

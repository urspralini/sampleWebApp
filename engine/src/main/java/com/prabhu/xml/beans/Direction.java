package com.prabhu.xml.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.prabhu.models.BaseObject;

import java.util.List;

/**
 * Created by prabhu on 1/10/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Direction extends BaseObject {
    @JacksonXmlProperty(isAttribute = true)
    private String tag;
    @JacksonXmlProperty(isAttribute = true)
    private String title;
    @JacksonXmlProperty(isAttribute = true)
    private String name;
    @JacksonXmlProperty(isAttribute = true)
    private boolean useForUI;
    @JacksonXmlProperty(localName = "stop")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Stop> stops;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isUseForUI() {
        return useForUI;
    }

    public void setUseForUI(boolean useForUI) {
        this.useForUI = useForUI;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }
}

package com.prabhu.xml.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.prabhu.models.BaseObject;

/**
 * Created by prabhu on 1/10/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stop extends BaseObject {
    @JacksonXmlProperty(isAttribute = true)
    private String tag;
    @JacksonXmlProperty(isAttribute = true)
    private String title;
    @JacksonXmlProperty(isAttribute = true)
    private String shortTitle;
    @JacksonXmlProperty(isAttribute = true)
    private double lat;
    @JacksonXmlProperty(isAttribute = true)
    private double lon;
    @JacksonXmlProperty(isAttribute = true)
    private long stopId;

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

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public long getStopId() {
        return stopId;
    }

    public void setStopId(long stopId) {
        this.stopId = stopId;
    }
}

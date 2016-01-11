package com.prabhu.xml.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.prabhu.models.BaseObject;

/**
 * Created by prabhu on 1/10/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Route extends BaseObject {
    @JacksonXmlProperty(isAttribute = true)
    private String tag;
    @JacksonXmlProperty(isAttribute = true)
    private String title;
    @JacksonXmlProperty(isAttribute = true)
    private String shortTitle;
    @JacksonXmlProperty(isAttribute = true)
    private int color;
    @JacksonXmlProperty(isAttribute = true)
    private int oppositeColor;
    @JacksonXmlProperty(isAttribute = true)
    private double latMin;
    @JacksonXmlProperty(isAttribute = true)
    private double latMax;
    @JacksonXmlProperty(isAttribute = true)
    private double lonMin;
    @JacksonXmlProperty(isAttribute = true)
    private double lonMax;

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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getOppositeColor() {
        return oppositeColor;
    }

    public void setOppositeColor(int oppositeColor) {
        this.oppositeColor = oppositeColor;
    }

    public double getLatMin() {
        return latMin;
    }

    public void setLatMin(double latMin) {
        this.latMin = latMin;
    }

    public double getLatMax() {
        return latMax;
    }

    public void setLatMax(double latMax) {
        this.latMax = latMax;
    }

    public double getLonMin() {
        return lonMin;
    }

    public void setLonMin(double lonMin) {
        this.lonMin = lonMin;
    }

    public double getLonMax() {
        return lonMax;
    }

    public void setLonMax(double lonMax) {
        this.lonMax = lonMax;
    }
}

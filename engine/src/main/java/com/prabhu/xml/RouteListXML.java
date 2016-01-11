package com.prabhu.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.prabhu.xml.beans.Route;
import com.sun.tools.javac.util.List;

/**
 * Created by prabhu on 1/10/16.
 */
@JacksonXmlRootElement(localName = "body")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteListXML {

    @JacksonXmlProperty(localName = "route")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Route> routes;

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}

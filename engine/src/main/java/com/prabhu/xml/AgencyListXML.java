package com.prabhu.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.prabhu.xml.beans.Agency;

import java.util.List;


/**
 * Created by prabhu on 1/10/16.
 */
@JacksonXmlRootElement(localName = "body")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgencyListXML {

    @JacksonXmlProperty(localName = "agency")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<Agency> agencies;

    public List<Agency> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<Agency> agencies) {
        this.agencies = agencies;
    }
}

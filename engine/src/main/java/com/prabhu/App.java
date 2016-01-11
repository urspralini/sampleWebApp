package com.prabhu;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.prabhu.client.NextBusClient;
import com.prabhu.xml.AgencyListXML;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

/**
 * Hello world!
 */

public class App {
    public static void main(String[] args) throws IOException, XMLStreamException {
        NextBusClient client = NextBusClient.newClient();
        XmlMapper mapper = new XmlMapper();
        AgencyListXML agencyListXML = mapper.readValue(client.getAgencies(), AgencyListXML.class);
        agencyListXML.getAgencies().forEach(agency -> System.out.println(agency));

    }


    private static XmlMapper getMapper(){
        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        XmlMapper mapper = new XmlMapper(module);
        return mapper;
    }
}

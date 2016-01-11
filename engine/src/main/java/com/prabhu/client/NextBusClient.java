package com.prabhu.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Created by prabhu on 1/10/16.
 */
public class NextBusClient {
    private static final String BASE_URL = "http://webservices.nextbus.com/service/publicXMLFeed";
    private static final String COMMAND = "command";
    private static NextBusClient INSTANCE;
    private final Client client;
    private NextBusClient() {
        this.client = ClientBuilder.newClient();
    }

    public static NextBusClient newClient() {
        if(INSTANCE == null){
            synchronized (NextBusClient.class){
                if(INSTANCE == null){
                    INSTANCE = new NextBusClient();
                }
            }
        }
        return INSTANCE;
    }

    public String getAgencies() {
        WebTarget target =  client.target(BASE_URL)
                .queryParam(COMMAND, "agencyList");
        return getResults(target);
    }

    public String getRouteList(String agency) {
        WebTarget target =  client.target(BASE_URL)
                .queryParam(COMMAND, "routeList")
                .queryParam("a", agency);
        return getResults(target);
    }

    public String getRouteConfig(String agency, String routeTag) {
        WebTarget target =  client.target(BASE_URL)
                .queryParam(COMMAND, "routeConfig")
                .queryParam("r", routeTag)
                .queryParam("a", agency);
        return getResults(target);
    }

    public String getPredictions(String agency, String stopId){
        WebTarget target =  client.target(BASE_URL)
                .queryParam(COMMAND, "predictions")
                .queryParam("stopId", stopId)
                .queryParam("a", agency);
        return getResults(target);
    }

    public String getPredictions(String agency, String routeTag, String stopTag){
        WebTarget target =  client.target(BASE_URL)
                .queryParam(COMMAND, "predictions")
                .queryParam("r", routeTag)
                .queryParam("s", stopTag)
                .queryParam("a", agency);
        return getResults(target);
    }

    private String getResults(WebTarget target){
        return target.request(MediaType.TEXT_XML_TYPE).get(String.class);
    }
}

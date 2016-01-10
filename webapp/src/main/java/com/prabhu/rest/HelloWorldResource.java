package com.prabhu.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * Created by prabhu on 1/2/16.
 */
@Path("/hello")
public class HelloWorldResource {

    @GET
    public String greeting(@QueryParam("name") String name){
        if(name == null) return "Hello World";
        else return "Hello " + name;
    }
}

package com.dataart.microapp;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.time.LocalDateTime;

@Controller("/service")
public class HelloController {

    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() {
        return "hello @ " + LocalDateTime.now();
    }

    @GET
    @Path("{name}")
    @Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
    public String customizedHello(@PathParam("name") String name) {
        if (name == null) {
            return "not hello >_>";
        }
        return "hello " + name + " @ " + LocalDateTime.now();
    }

}
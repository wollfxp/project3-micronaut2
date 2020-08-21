package com.dataart.microapp;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import java.time.LocalDateTime;

@Controller("/service")
public class HelloController {

    @Get(uri = "/", produces = MediaType.TEXT_PLAIN)
    public String index() {
        return "hello @ " + LocalDateTime.now();
    }

    @Get("{name}")
    public String customizedHello(@PathVariable String name) {
        return "hello " + name + " @ " + LocalDateTime.now();
    }

}
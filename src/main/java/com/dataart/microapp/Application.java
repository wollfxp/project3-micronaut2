package com.dataart.microapp;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;

import javax.inject.Singleton;

@OpenAPIDefinition(
        info = @Info(
                title = "micronaut2",
                version = "0.0"
        )
)
@Singleton
public class Application extends javax.ws.rs.core.Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}

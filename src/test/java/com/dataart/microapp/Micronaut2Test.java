package com.dataart.microapp;

import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
public class Micronaut2Test {

    @Inject
    EmbeddedApplication application;

    @Inject
    @Client("/service")
    RxHttpClient client;

    @Test
    void testItWorks() {
        assertTrue(application.isRunning());
    }

    @Test
    void testControllerWorks(){
        String response = client.retrieve("/").blockingFirst();
        assertTrue(response.contains("hello @"));
    }

    @Test
    void testControllerWorksWithName(){
        String response = client.retrieve("/vasya").blockingFirst();
        assertTrue(response.contains("hello vasya @"));
    }

}

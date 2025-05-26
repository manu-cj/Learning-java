package com.example.hello;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class HelloServiceTest {

    @Test
    public void testHelloMessageForConfiguredLang() throws IOException {
        HelloService service = new HelloService();
        String message = service.getHelloMessage();
        assertNotNull(message);
        assertTrue(message.contains("Hallo wereld") || message.contains("Bonjour") || message.contains("Hallo Welt"));
    }
}

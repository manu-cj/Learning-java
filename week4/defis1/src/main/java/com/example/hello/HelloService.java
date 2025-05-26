package com.example.hello;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HelloService {

    private final Properties properties;
    private final String nativeLang;
    private final String configuredLang;

    public HelloService() throws IOException {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("messages.properties")) {
            properties.load(input);
        }
        nativeLang = properties.getProperty("native_language", "FR");
        configuredLang = properties.getProperty("configured_language", nativeLang);
    }

    public String getHelloMessage() {
        return properties.getProperty(configuredLang + "_hello_world",
                properties.getProperty("native_hello_world", "Hello world!"));
    }
}

package org.manu;

import org.manu.services.CommandLine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application-secret.properties")
public class Application {
  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(Application.class, args);

    CommandLine app = context.getBean(CommandLine.class);

    app.start();

  }
}

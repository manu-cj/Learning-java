package org.manu;

import org.manu.models.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application-secret.properties")
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
    Person person = new Person("Manu", 29);
    System.out.println(person.getName());
    System.out.println(person.getAge());
  }
}

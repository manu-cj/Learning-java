package org.manu;

import org.manu.services.FidelityCardServices;
import org.manu.services.ProductServices;
import org.manu.utils.CommandUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.manu")) {

      ProductServices productServices = context.getBean(ProductServices.class);
      FidelityCardServices fidelityCardServices = context.getBean(FidelityCardServices.class);
      CommandUtils commandUtils = context.getBean(CommandUtils.class);

      Scanner scanner = new Scanner(System.in);

      String command;
      List<String> categoryList = Arrays.asList("aliment");
      String category;

      System.out.println("--- MARKET MANAGER ---");
      System.out.println("Commandes disponible : 'add-product', 'get-products', 'get-products-by-category', 'create-fidelity-card'");

      while (true) {
        System.out.println("Enter a command !");
        System.out.print("> ");
        command = scanner.nextLine().trim().toLowerCase();

        switch (command) {
          case "add-product":
            System.out.println("Choice a category : ");
            System.out.println("-- Category list --");
            for (String c : categoryList) {
              System.out.println(c);
            }
            System.out.print("> ");
            category = scanner.nextLine().trim().toLowerCase();
            commandUtils.addProductCommand(category, scanner, productServices);
            break;
          case "get-products-by-category":
            System.out.println("Choice a category : ");
            System.out.println("-- Category list --");
            for (String c : categoryList) {
              System.out.println(c);
            }
            System.out.print("> ");
            category = scanner.nextLine().trim().toLowerCase();
            productServices.getProductsByCategory(category);
            break;
          case "get-products":
            productServices.getAllProducts();
            break;
          case "create-fidelity-card":
            System.out.println("What is your firstname :");
            System.out.print("> ");
            String firstname = scanner.nextLine();
            System.out.println("What is your lastname :");
            System.out.print("> ");
            String lastname = scanner.nextLine();
            System.out.println("What is your birthday :");
            System.out.print("> ");
            String birthday = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate birthdayParsed = LocalDate.parse(birthday, formatter);
            System.out.println("What is your email :");
            System.out.print("> ");
            String email = scanner.nextLine();

            fidelityCardServices.addFidelityCard(firstname, lastname, birthdayParsed, email);

            System.out.println("new card add :" +
                    " | firstname :" + firstname +
                    " | lastname : " + lastname +
                    " | birthday : " + birthdayParsed +
                    " | email : " + email);
            break;
        }

      }
    }
  }
}

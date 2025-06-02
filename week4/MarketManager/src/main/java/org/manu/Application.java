package org.manu;

import org.manu.services.ProductServices;
import org.manu.utils.CommandUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.manu")) {
      ProductServices productServices = context.getBean(ProductServices.class);
      CommandUtils commandUtils = context.getBean(CommandUtils.class);
      Scanner scanner = new Scanner(System.in);

      String command;
      List<String> categoryList = Arrays.asList("aliment");
      String category;

      System.out.println("--- MARKET MANAGER ---");
      System.out.println("Commandes disponible : add-product");

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
          case "get-product-by-category":
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
        }

      }
    }
  }
}

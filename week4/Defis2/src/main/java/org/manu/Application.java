package org.manu;

import org.manu.services.WordCounterService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan("org.manu.services")
public class Application {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("\nVeuillez entrer une phrase (ou 'exit' pour quitter) : ");
      String line = scanner.nextLine();

      if ("exit".equalsIgnoreCase(line.trim())) {
        break;
      }

      WordCounterService counter = context.getBean(WordCounterService.class);

      counter.countWords(line);

      System.out.println("\nRésultats du compteur (Singleton) :");
      System.out.println("| Word | Occurrences |");
      System.out.println("|------|-------------|");

      for (Map.Entry<String, Integer> entry : counter.getWordCounts().entrySet()) {
        System.out.printf("| %-10s | %-11d |\n", entry.getKey(), entry.getValue());
      }
    }

    scanner.close();
    System.out.println("Goodbye");
    ((AnnotationConfigApplicationContext) context).close();


  }
}

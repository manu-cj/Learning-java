package org.manu;

import org.manu.services.DoctorService;
import org.manu.services.VisitService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Application {
  public static void main(String[] args) {
    try (AnnotationConfigApplicationContext context =
                 new AnnotationConfigApplicationContext("org.manu")) {

      VisitService hospitalService = context.getBean(VisitService.class);
      DoctorService doctorService = context.getBean(DoctorService.class);

      Scanner scanner = new Scanner(System.in);
      String command;

      System.out.println("Bienvenue dans l'enregistrement des visiteurs de l'hôpital !");
      System.out.println("Commandes disponibles : 'register', 'report', 'add-doctor', 'get-doctors', 'exit'");

      while (true) {
        System.out.print("Entrez une commande : ");
        command = scanner.nextLine().trim().toLowerCase();

        switch (command) {
          case "register":
            System.out.print("Entrez le prénom du visiteur : ");
            String firstName = scanner.nextLine();
            System.out.print("Entrez le nom de famille du visiteur : ");
            String lastName = scanner.nextLine();
            String doctorList = doctorService.doctorList();
            System.out.print("Choisissez un médecin " + doctorList + " ou laissez vide pour visiter un patient : ");
            String doctorChoice = scanner.nextLine();
            hospitalService.registerVisitor(firstName, lastName, doctorChoice);
            break;
          case "report":
            hospitalService.generateReport();
            break;
          case "add-doctor" :
            System.out.printf("Entrez le nom du docteur : ");
            String doctorName = scanner.nextLine();
            System.out.println("Entrez la spècialité du docteur : ");
            String role = scanner.nextLine();
            doctorService.registerDoctor(doctorName, role);
            break;
          case "get-doctors":
            doctorService.generateReport();
            break;
          case "exit":
            System.out.println("Fermeture de l'application. Au revoir !");
            return;
          default:
            System.out.println("Commande inconnue. Veuillez utiliser 'register', 'report' ou 'exit'.");
            break;
        }
      }
    }
  }
}

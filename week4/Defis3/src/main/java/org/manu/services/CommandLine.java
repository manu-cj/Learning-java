package org.manu.services;

import org.manu.commands.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Scanner;

@Service
public class CommandLine {
    private final Map<String, Command> commands;

    @Autowired
    public CommandLine(Map<String, Command> commands) {
        this.commands = commands;

    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez une commande (hello, time) ou tapez 'exit' pour sortir :");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Goodbye");
                break;
            }

            Command command = commands.get(input);

            if (command != null) {
                command.execute();
            } else {
                System.out.println("Cette commande n'existe pas, veuillez entrer une commande existante !");
            }

        }
        scanner.close();
    }
}
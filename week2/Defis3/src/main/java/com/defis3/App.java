package com.defis3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Path path = Paths.get("./resource/covid_and_trade.csv");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez l'année");
        String year = scanner.nextLine();

        int yearParsed = Integer.parseInt(year);
        if (year.isEmpty() || yearParsed < 2015 || yearParsed > 2021) {
            year = "2016";
            System.out.println(
                    "Veuillez donner une date valide compris entre 2015 et 2021. Valeurs initialiser par default à 2016");

        }

        Pattern pattern = Pattern.compile("\\b" + year + "\\b");
        try {
            List<String> allLines = Files.readAllLines(path);
            allLines.stream()
                    .skip(1)
                    .filter(line -> (line.contains("Imports") || line.contains("Exports"))
                            && pattern.matcher(line).find())
                    .forEach(System.out::println);
            scanner.close();
        } catch (IOException e) {
            System.out.println("an error occured : " + e);
        }
    }
}

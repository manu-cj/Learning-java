package com.manu.defis2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        Path path = Paths.get("./resource/covid_and_trade.csv");
        try {

            List<String> allLines = Files.readAllLines(path);
            String[] columns = allLines.get(0).split(",");
            int columnsNumber = columns.length;

            List<Set<String>> uniqueValue = new ArrayList<>();
            for (int i = 0; i < columnsNumber; i++) {
                uniqueValue.add(new HashSet<>());
            }

            try {
                Stream<String> lines = Files.lines(path);
                lines
                    .skip(1)
                    .map( line -> line.split(","))
                    .forEach(colonnes -> {
                        for (int i = 0; i < colonnes.length; i++) {
                            uniqueValue.get(i).add(colonnes[i]);
                        }
                    });

    
            } catch (Exception e) {
                System.out.println("an error is occured : " + e);
            }

            for (int i = 0; i < uniqueValue.size(); i++) {
                System.out.println("Colonne " + (i + 1) + " : " + uniqueValue.get(i));
            }
            
        } catch (Exception e) {
            System.out.println("an error is occured : " + e);

        }
        
    }
}

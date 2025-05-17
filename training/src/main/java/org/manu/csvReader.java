package org.manu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class csvReader {
    public static void main(String[] args) {
        File file = new File("data.csv");
        List<String[]> datas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] headers = br.readLine().split(",");
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] parts = ligne.split(",");
                datas.add(parts);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String[] ligne : datas) {
            for (String data : ligne) {
                System.out.println(data);
            }
            System.out.println("---------------");

        }

    }

}

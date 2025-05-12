package com.manu.surface;

import java.util.Scanner;

public class App 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // demander la longueur et la largeur à l'utilisateur
        System.out.println("Longueur :");
        String longueurInput = scanner.nextLine();
        System.out.println(longueurInput);

        System.out.println("Largeur :");
        String largeurInput = scanner.nextLine();
        System.out.println(largeurInput);

        scanner.close();

        // convertir les valeurs en mettre
        double length = parseToMeter(longueurInput);
        double width = parseToMeter(largeurInput);

        // calculer et afficher la surface
        double surface = length * width;
        System.out.println("Surface : "+ surface + " m2");

        
        

    }

    public static double parseToMeter(String input) {
        Unit unit = Unit.from(input);
        
        // transformer le type en double et enlever le suffix
        String valuePart = input.replace(unit.getSuffix(), "");
        double value = Double.parseDouble(valuePart);

        return unit.toMeters(value);
    }
}

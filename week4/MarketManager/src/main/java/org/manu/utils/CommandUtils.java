package org.manu.utils;

import org.manu.services.ProductServices;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Service
public class CommandUtils {
    /**
     * ask data parameters for add product in good category
     * @param category
     */
    public void addProductCommand(String category, Scanner scanner, ProductServices productServices) {
        switch (category) {
            case "aliment":
                System.out.println("Write a product name : ");
                System.out.print("> ");
                String name = scanner.nextLine();
                System.out.println("Write a product price : ");
                System.out.print("> ");
                String price = scanner.nextLine();
                System.out.println("Write a product description : ");
                System.out.print("> ");
                String description = scanner.nextLine();
                System.out.println("Write a product stock : ");
                System.out.print("> ");
                String stock = scanner.nextLine();
                System.out.println("Write a product type : ");
                System.out.print("> ");
                String type = scanner.nextLine();
                System.out.println("Write a product duration date : ");
                System.out.print("> ");
                String date = scanner.nextLine();

                Double priceParsed = Double.parseDouble(price);
                int stockParsed = Integer.parseInt(stock);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                LocalDate dateParsed = LocalDate.parse(date, formatter);

                productServices.addProduct( name,
                                            priceParsed,
                                            description,
                                            category,
                                            stockParsed,
                                            type,
                                            dateParsed);

                System.out.println("Nouvel aliment ajouté : " + name +
                        " | Prix : " + priceParsed +
                        " | Description : " + description +
                        " | Stock : " + stockParsed +
                        " | Type : " + type +
                        " | Duration date : " + dateParsed);
                break;
        }

    }
}

package org.manu;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadWithScanner {
    public static void main(String[] args) {
        try {
            File file = new File("test.txt");
            Scanner scanner = new Scanner(file);
            int count = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                count++;
                System.out.println(">> " + line);
                ;
            }

            System.out.println(count);
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

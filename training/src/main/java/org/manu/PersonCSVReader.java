package org.manu;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonCSVReader {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get("data.csv"))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String email = parts[2];
                int age = Integer.parseInt(parts[3]);
                String city = parts[4];

                people.add(new Person(id, name, age, email, city));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        people.sort(Comparator.comparingInt(Person::getAge));

        people.stream().filter(data -> data.getId() == 1)
                .forEach(System.out::println);

        people.stream().filter(data -> data.getEmail().equals("lucie.petit@email.com"))
                .forEach(data -> System.out
                        .println("\n |------------------------------------------------|\n" + data.getName()
                                + "\n |------------------------------------------------|"));

        for (Person p : people) {
            if (p.getuserById(3) != null) {
                System.out.println("|------------------------------------------------|");
                System.out.println(p);
            }
            if (p.getId() == 8) {
                System.out.println("|------------------------------------------------|");
                System.out.println(p);
            }
        }
    }

}

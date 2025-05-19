package org.manu;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PersonCSVReader {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        HashMap<Integer, Person> people2 = new HashMap<>();

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
                people2.put(id, new Person(id, name, age, email, city));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Person person1 = people2.get(5);

        if (person1 != null) {
            System.out.println(person1.getName());
        }
        people.sort(Comparator.comparingInt(Person::getAge));

        people.stream().filter(data -> data.getId() == 1)
                .forEach(System.out::println);

        HashMap<String, Object> userdata = new HashMap<>();

        people.stream()
                .filter(data -> data.getEmail().equals("lucie.petit@email.com"))
                .forEach(data -> {
                    userdata.put("name", data.getName());
                    userdata.put("city", data.getCity());
                    userdata.put("age", data.getAge());
                    userdata.put("email", data.getEmail());
                });

        System.out.println(userdata.get("age"));

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

        Map<Integer, List<Person>> byAge = people.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println("Trié par age");
        for (Map.Entry<Integer, List<Person>> entry : byAge.entrySet()) {
            if (entry.getKey() == 28) {
                System.out.println(entry.getValue());
            }
        }
    }

}

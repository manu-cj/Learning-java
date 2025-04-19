package training.contactManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
    public static void main(String[] args) {
        List<Contact> contacts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            int choix = readChoice(scanner);

            switch (choix) {
                case 1:
                    addContact(scanner, contacts);
                    break;
                case 2:
                    showContacts(contacts);
                    return;
                case 3:
                    deleteContact(scanner, contacts);
                    return;
                case 4:
                    exit();
                default:
                    break;
            }
            
        }
    }

    // 👇 These methods go here, outside of main, but still within the ContactManager class
    public static void showMenu() {
        System.out.println("---- Menu ----");
        System.out.println("1. Add a contact");
        System.out.println("2. Display all contacts");
        System.out.println("3. Delete a contact");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public static int readChoice(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; 
        }
    }

    public static void addContact(Scanner scanner, List<Contact> contacts) {

        // Ask user data
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        contacts.add(new Contact(name, phoneNumber, email));
        

        try {
            // Create directory if not exist
            File directory = new File("training/contactManager");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            
            // Create file csv
            File file = new File(directory, "contacts.csv");
            FileWriter writer = new FileWriter(file, true); // 'true' enables appending to the file
            for (Contact contact : contacts) {
                writer.write(contact.getName() + "," + contact.getPhoneNumber() + "," + contact.getEmail() + "\n");
            }
            writer.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file: " + e.getMessage());
        }
    }

    public static void showContacts(List<Contact> contacts) {
        try (Scanner fileScanner = new Scanner(new File("training/contactManager/contacts.csv"))) {
            while (fileScanner.hasNextLine()) {
            String[] data = fileScanner.nextLine().split(",");
            if (data.length == 3) {
                contacts.add(new Contact(data[0], data[1], data[2]));
            }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        for (Contact contact : contacts) {
            System.out.println("Name | phone number | email");
            System.out.println(contact);            
            exit();
        }
    }

    public static void deleteContact(Scanner scanner, List<Contact> contacts) {
        System.out.println("Enter email do you want delete :");
        String email = scanner.nextLine();

        // Load contacts from the file
        try (Scanner fileScanner = new Scanner(new File("training/contactManager/contacts.csv"))) {
            while (fileScanner.hasNextLine()) {
            String[] data = fileScanner.nextLine().split(",");
            if (data.length == 3) {
                contacts.add(new Contact(data[0], data[1], data[2]));
            }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        // get contact data
        Contact contactToDelete = contacts.stream()
                  .filter(contact -> contact.getEmail().equals(email))
                  .findFirst()
                  .orElse(null);

        // delete in file
        if (contactToDelete != null) {
            String name = contactToDelete.getName();
            String phoneNumber = contactToDelete.getPhoneNumber();
            String deleteLigne = name + "," + phoneNumber + "," + email;
            deleteLine("training/contactManager/contacts.csv", deleteLigne);
            System.out.println("Deleted contact: " + name);
        } else {
            System.out.println("No contact found with the given email.");
        }
        
    }
    
    public static void exit() {
        System.out.println("Goodbye!");
        System.exit(0);
    }


    public static void deleteLine(String fileName, String deleteLigne) {
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();

        // Read lines
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (!line.equals(deleteLigne)) {
                    lines.add(line); // keep only the ones we want
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lecture : " + e.getMessage());
            return;
        }

        // Write in file
        try (FileWriter writer = new FileWriter(fileName, false)) { // false = overwrite
            for (String line : lines) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erreur écriture : " + e.getMessage());
        }
    }
}

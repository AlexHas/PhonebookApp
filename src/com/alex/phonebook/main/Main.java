package com.alex.phonebook.main;

import com.alex.phonebook.Phonebook;
import com.alex.phonebook.Entities.PhonebookEntry;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    runApp();
    }

    public static void runApp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Phonebook owner's name:");

        Phonebook phonebook = Phonebook.getInstance();
        phonebook.setOwner(scanner.nextLine());

        System.out.println("What do you want to achieve?(type 'help' for instructions)");
        String command = scanner.nextLine();
        while(!command.equals("exit")) {
            switch (command) {
                case "add":
                    PhonebookEntry contact = new PhonebookEntry();
                    System.out.println("Please provide details. The ones marked with '*' are mandatory.");
                    contact.serialiseData(scanner);
                    phonebook.addContact(contact);
                    break;
                case "print":
                    Phonebook.printContacts();
                    break;
                case "find":

                    break;
                case "help":
                default:
                    System.out.println(helpText);
                    break;
            }

            command = scanner.nextLine();
        }
    }

    private static final String helpText = """
            Usage of the app:
            java ${pathToMain}/Main -arg1 -arg2 ..
            Arguments possible values:
            "help": provide this info
            "add": add a new contact; it has to be followed by a name and a phone number
            "print": print all saved contacts
            """;
}

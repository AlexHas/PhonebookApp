package com.alex.phonebook.main;

import com.alex.phonebook.PhonebookEntry;

public class Main {
    private static final int MAX_CONTACTS = 100;
    private static int s_currentContactsNumber = 0;
    private static PhonebookEntry[] s_contacts = new PhonebookEntry[MAX_CONTACTS];

    public static void main(String[] args) {
	    Main.parseArguments(args);
	    Main.printContacts();
    }

    public static void parseArguments(String[] args) {
        boolean isValid = true;
        for(int i = 0; i < args.length; ++i) {
            if(!isValid) {
                return;
            }
            switch (args[i]) {
                case "-add":
                    if (args.length < i + 3) { // app has to have at least 2 more arguments after '-add"
                        System.out.println("For '-add' command, name and phone number has to be provided");
                        isValid = false;
                        break;
                    }

                    String name = args[i+1];
                    String phoneNumber = args[i+2];
                    i += 2;

                    PhonebookEntry phonebookEntry = new PhonebookEntry(name, phoneNumber);
                    s_contacts[s_currentContactsNumber] = phonebookEntry;
                    ++s_currentContactsNumber;

                    break;
                case "-help":
                    System.out.println(helpText);
                    break;
                default:
                    isValid = false;
                    System.out.println(Main.helpText);
            }
        }
    }

    public static void printContacts() {
        for(PhonebookEntry contact : s_contacts) {
            if(contact != null) {
                System.out.println(contact.toString());
            }
        }
    }

    private static final String helpText = """
            Usage of the app:
            java ${pathToMain}/Main -arg1 -arg2 ..
            Arguments possible values:
            "-help": provide this info
            "-add": add a new contact; it has to be followed by a name and a phone number
            """;
}

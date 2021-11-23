package com.alex.phonebook;

import com.alex.phonebook.Entities.PhonebookEntry;

import java.util.ArrayList;
import java.util.Optional;

public class Phonebook {
    private static Phonebook s_instance = null;

    private Phonebook() {
        this.contacts = new ArrayList<>();
    }

    public static synchronized Phonebook getInstance() {
        if(s_instance == null) {
            s_instance = new Phonebook();
        }

        return s_instance;
    }

    public static void printContacts() {
        var contacts = s_instance.getContacts();
        if(!contacts.isEmpty()) {
            for (PhonebookEntry contact : contacts) {
                System.out.println(contact);
            }
        } else {
            System.out.println("There are no saved contacts yet.");
        }
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ArrayList<PhonebookEntry> getContacts() {
        return contacts;
    }

    public void addContact(PhonebookEntry contact) {
        Optional<PhonebookEntry> alreadySavedContact = contacts.stream().filter(presentContact -> contact.getPhoneNumber().equals(presentContact.getPhoneNumber())).findFirst();
        if(alreadySavedContact.isPresent()) {
            PhonebookEntry entry = alreadySavedContact.get();
            System.out.print("Phone number " + entry.getPhoneNumber().getPhone() + " is already assigned to contact named '" + entry.getName() + "'.");
            System.out.println("It won't be overriden.");
            return;
        }

        contacts.add(contact);
        System.out.println("Contact " + contact.getName() + " saved.");
    }

    private String owner;
    private ArrayList<PhonebookEntry> contacts;
}

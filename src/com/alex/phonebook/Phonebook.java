package com.alex.phonebook;

import com.alex.phonebook.Entities.PhonebookEntry;

import java.util.ArrayList;

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
        for(PhonebookEntry contact : contacts) {
            System.out.println(contact);
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
        contacts.add(contact);
    }

    private String owner;
    private ArrayList<PhonebookEntry> contacts;
}

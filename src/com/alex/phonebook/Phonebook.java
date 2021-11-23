package com.alex.phonebook;

import com.alex.phonebook.Entities.PhonebookEntry;

public class Phonebook {
    private static Phonebook s_instance = null;
    private static int s_totalContacts = 0;
    private static final int MAX_CONTACTS = 100;

    private Phonebook() {
        this.contacts = new PhonebookEntry[MAX_CONTACTS];
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
            if(contact != null) {
                System.out.println(contact);
            }
        }
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public PhonebookEntry[] getContacts() {
        return contacts;
    }

    public void addContact(PhonebookEntry contact) {
        if(s_totalContacts == MAX_CONTACTS) {
            System.out.println("Max contacts number reached");
            return;
        }
        contacts[s_totalContacts] = contact;
        ++s_totalContacts;
    }

    private String owner;
    private PhonebookEntry[] contacts;
}

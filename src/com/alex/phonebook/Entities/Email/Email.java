package com.alex.phonebook.Entities.Email;

import com.alex.phonebook.Entities.CompositeEntityInfo;

import java.util.Scanner;

public class Email implements CompositeEntityInfo {
    private String email;

    public Email() {
    }

    public Email(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void printInfo() {
        System.out.println("Email is: " + email);
    }

    @Override
    public void serialiseData(Scanner scanner) {
        System.out.println("Email:");
        email = scanner.nextLine();
    }

    @Override
    public String toString() {
        return "Email{" +
                "email='" + email + '\'' +
                '}';
    }
}

package com.alex.phonebook.Entities;

import java.util.Scanner;

public class PhoneNumber implements CompositeEntityInfo {
    private String phone;

    public PhoneNumber() {
    }

    public PhoneNumber(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void printInfo() {
        System.out.println("Phone details: " + phone);
    }

    @Override
    public void serialiseData(Scanner scanner) {
        System.out.println("Phone number*:");
        phone = scanner.nextLine();
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "phone='" + phone + '\'' +
                '}';
    }
}

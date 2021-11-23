package com.alex.phonebook.Entities;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return phone.equals(that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone);
    }
}

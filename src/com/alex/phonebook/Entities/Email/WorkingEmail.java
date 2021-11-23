package com.alex.phonebook.Entities.Email;

import java.util.Scanner;

public class WorkingEmail extends Email {
    private String company;

    public WorkingEmail() {
    }

    public WorkingEmail(String email, String company) {
        super(email);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("and is from " + company + " company.");
    }

    @Override
    public void serialiseData(Scanner scanner) {
        System.out.println("Working ");
        super.serialiseData(scanner);
        System.out.println("Company:");
        company = scanner.nextLine();
    }

    @Override
    public String toString() {
        return "WorkingEmail{" +
                "email='" + super.getEmail() +
                "company='" + company + '\'' +
                '}';
    }
}

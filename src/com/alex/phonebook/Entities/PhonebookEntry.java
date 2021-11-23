package com.alex.phonebook.Entities;

import com.alex.phonebook.Entities.Email.Email;
import com.alex.phonebook.Entities.Email.WorkingEmail;

import java.util.Scanner;

public class PhonebookEntry implements CompositeEntityInfo {
    private String name;
    private String description;
    private PhoneNumber phoneNumber;
    private Email personalEmail;
    private Email workingEmail;

    public PhonebookEntry() {
        this.phoneNumber = new PhoneNumber();
        this.personalEmail = new Email();
        this.workingEmail = new WorkingEmail();
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Email getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = new Email(personalEmail);
    }

    public Email getWorkingEmail() {
        return workingEmail;
    }

    public void setWorkingEmail(String workingEmail, String company) {
        this.workingEmail = new WorkingEmail(workingEmail, company);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void printInfo() {
        System.out.println(name + " info: ");
        phoneNumber.printInfo();
        personalEmail.printInfo();
        workingEmail.printInfo();
    }

    // TODO: validations on empty mandatory fields, phone and mail correct formats, etc
    @Override
    public void serialiseData(Scanner scanner) {
        System.out.println("Name*:");
        name = scanner.nextLine();
        System.out.println("Description:");
        description = scanner.nextLine();

        phoneNumber.serialiseData(scanner);
        personalEmail.serialiseData(scanner);
        workingEmail.serialiseData(scanner);

        System.out.println("Contact " + name + " saved.");
    }

    @Override
    public String toString() {
        return "PhonebookEntry{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", personalEmail=" + personalEmail +
                ", workingEmail=" + workingEmail +
                '}';
    }
}

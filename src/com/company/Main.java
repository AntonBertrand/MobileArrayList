package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("079 456 394");

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }

    }

    private static void updateContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);

        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number:");
        String newNumber = scanner.nextLine();

        Contacts newContact = Contacts.createContact(newName, newNumber);
        if (mobilePhone.modifyContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record!");
        }

    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);

        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        if (mobilePhone.removeContact(existingContactRecord)) {
            System.out.println("Successfully deleted record!");
        } else {
            System.out.println("Error deleting contact!");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);

        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Name: " + existingContactRecord.getName() + " phone number is " + existingContactRecord.getNumber());
    }



    private static void addNewContact(){
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        Contacts newContact = Contacts.createContact(name, phone);
        if (mobilePhone.storeContact(newContact)) {
            System.out.println("New contact added: " + name + ", phone number = " + phone);
        } else {
            System.out.println("Cannot add, " + name + " already on file");
        }
    }


    private static void startPhone(){
        System.out.println("Starting phone...");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("\t 0 - Shutdown");
        System.out.println("\t 1 - Print Contacts");
        System.out.println("\t 2 - Add new contact");
        System.out.println("\t 3 - Update existing contact");
        System.out.println("\t 4 - Remove existing contact");
        System.out.println("\t 5 - Query is existing contact exists");
        System.out.println("\t 6 - Print list of available actions");
        System.out.println("\t Choose your Action: ");

    }

}

package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
    }

    public boolean storeContact(Contacts contacts) {

        if (findContact(contacts) >= 0) {
            return false;
        } else {
            myContacts.add(contacts);
            return true;
        }
    }

    private int findContact(Contacts contacts) {
        return this.myContacts.indexOf(contacts);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contacts contacts = this.myContacts.get(i);
            if (contacts.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public boolean modifyContact(Contacts oldContact, Contacts newContact){
        int foundPosition = findContact(oldContact);
        if (foundPosition >= 0) {

            if (findContact(newContact.getName()) != -1) {
                System.out.println("Contact already exists with that name!");
                return false;
            }

            this.myContacts.set(foundPosition, newContact);
            System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
            return true;
        } else {
            System.out.println("Old contact does not exist - try again with a valid contact!");
            return false;
        }
    }

    public boolean removeContact(Contacts contacts){
        int foundPosition = findContact(contacts);
        if(foundPosition >= 0) {
            this.myContacts.remove(foundPosition);
            System.out.println(contacts.getName() + " was successfully deleted!");
            return true;
        }
        System.out.println("Contact does not exist!");
        return false;
    }

    public String queryContact(Contacts contacts) {
        if(findContact(contacts) >= 0) {
            return contacts.getName();
        }
        return null;
    }

    public Contacts queryContact(String name){
        int position = findContact(name);
        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }


    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println(i+1 + ". " + this.myContacts.get(i).getName() + " -> "
            + this.myContacts.get(i).getNumber());
        }
    }

}

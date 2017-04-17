/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appname.menu;

import com.appname.manager.PersonManager;
import com.appname.model.Person;
import com.appname.util.Printer;
import com.appname.util.Reader;

/**
 *
 * @author interactive
 */
public class PersonMenu {

    private final PersonManager manager;

    public PersonMenu() throws Exception {
        manager = new PersonManager();
    }

    public void menu() throws Exception {
        Person[] persons;
        Person person;
        int id;
        String name, address, email;
        OUTER:
        while (true) {
            System.out.println("--------------------------");
            System.out.println("(1) To List All Persons.");
            System.out.println("(2) To Insert New Person.");
            System.out.println("(3) To Update Person.");
            System.out.println("(4) To Delete Person.");
            System.out.println("(0) To Back.");
            int code = Reader.readInt("Enter Operation Code");
            System.out.println("--------------------------");
            switch (code) {
                case 1:
                    persons = manager.loadPersons();
                    Printer.print(persons);
                    break;
                case 2:
                    person = Reader.readPerson();
                    if (!manager.exists(person)) {
                        manager.save(person);
                    } else {
                        System.err.println("This Id: " + person.getId() + " alraedy exists");
                    }
                    break;
                case 3:
                    id = Reader.readInt("Enter Id");
                    person = manager.getPerson(id);
                    if (person != null) {
                        name = Reader.readString("Enter New Name");
                        email = Reader.readString("Enter New E-mail");
                        address = Reader.readString("Enter New Address");
                        person.setName(name);
                        person.setAddress(address);
                        person.setEmail(email);
                        manager.update(person);
                    } else {
                        System.err.println("There are no Person of id: " + id);
                    }
                    break;
                case 4:
                    id = Reader.readInt("Enter Id");
                    person = manager.getPerson(id);
                    if (person != null) {
                        manager.delete(id);
                    } else {
                        System.err.println("There are no Person of id: " + id);
                    }
                    break;
                case 0:
                    break OUTER;
                default:
                    break;
            }
        }
    }
}

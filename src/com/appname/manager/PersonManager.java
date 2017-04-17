/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appname.manager;

import com.appname.model.Person;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 *
 * @author interactive
 */
public class PersonManager {

    private String fileName;
    private File file;
    private BufferedReader reader;
    private PrintWriter writer;
    private FileOutputStream stream;
    private Person[] persons;

    public PersonManager() throws Exception {
        this("persons.cvs");
    }

    public PersonManager(String fileName) throws Exception {
        this.fileName = fileName;
        this.file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        stream = new FileOutputStream(file, true);
        writer = new PrintWriter(stream);
        loadPersons();
    }

    public String getFileName() {
        return fileName;
    }

    public boolean save(Person person) {
        persons[person.getId()] = person;
        writer.println(person);
        writer.flush();
        return true;
    }

    public boolean save() throws Exception {
        stream = new FileOutputStream(file, true);
        writer = new PrintWriter(stream);
        for (Person person : persons) {
            if (person != null) {
                writer.println(person);
            }
        }
        writer.flush();
        return true;
    }

    public boolean update(Person person) throws Exception {
        persons[person.getId()].setName(person.getName());
        persons[person.getId()].setAddress(person.getAddress());
        persons[person.getId()].setEmail(person.getEmail());
        save();
        return true;
    }

    public boolean delete(int id) throws Exception {
        persons[id] = null;
        save();
        return true;
    }

    public void generate(int n) {
        Person person;
        for (int i = 0; i < 100; i++) {
            person = new Person(i, "Name " + (i + 1), "E-mail " + (i + 1), "Address " + (i + 1));
            if (exists(person)) {
                person.setId(getId());
            }
            persons[person.getId()] = person;
            save(person);
        }
    }

    public boolean exists(Person person) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] != null && persons[i].equals(person)) {
                return true;
            }
        }
        return false;
    }

    public Person getPerson(int id) {
        for (Person person : persons) {
            if (person != null && person.getId() == id) {
                return person;
            }
        }

        return null;
    }

    public int getId() {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public final Person[] loadPersons() throws Exception {
        if (persons == null) {
            reader = new BufferedReader(new FileReader(file));
            persons = new Person[1000];
            int index = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                persons[index++] = parse(line);
            }
            reader.close();
        }
        return persons;
    }

    public Person parse(String line) {
        String[] values = line.split(",");
        int id = Integer.parseInt(values[0]);
        String name = values[1];
        String email = values[2];
        String address = values[3];
        return new Person(id, name, email, address);
    }
}

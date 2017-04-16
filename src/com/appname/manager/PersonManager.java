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

    public PersonManager() throws Exception {
        this("persons.cvs");
    }

    public PersonManager(String fileName) throws Exception {
        this.fileName = fileName;
        this.file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        reader = new BufferedReader(new FileReader(file));
        writer = new PrintWriter(new FileOutputStream(file, true));
    }

    public String getFileName() {
        return fileName;
    }

    public boolean save(Person person) {
        writer.println(person);
        writer.flush();
        return true;
    }
    
    public void generate(int n) {
        for (int i = 0; i < 100; i++) {
            save(new Person(i + 1, "Name " + (i + 1), "E-mail " + (i + 1), "Address "  + (i + 1)));
        }
    }

    public Person[] getPersons() throws Exception {
        Person[] persons = new Person[1000];
        int index = 0;
        String line;
        reader.ready();
        while ((line = reader.readLine()) != null) {
            persons[index++] = parse(line);
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

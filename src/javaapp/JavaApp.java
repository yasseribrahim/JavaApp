/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp;

import com.appname.manager.PersonManager;
import com.appname.model.Person;

/**
 *
 * @author interactive
 */
public class JavaApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        PersonManager manager = new PersonManager();
        Person[] persons;
        
        manager.generate(100);
        persons = manager.getPersons();
        for (Person person : persons) {
            System.out.println(person);
        }
        System.out.println("---------------");
        persons = manager.getPersons();
        for (Person person : persons) {
            System.out.println(person);
        }
    }
    
}

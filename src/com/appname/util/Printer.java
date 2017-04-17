/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appname.util;

import com.appname.model.Person;

/**
 *
 * @author interactive
 */
public class Printer {

    public static void print(Person person) {
        System.out.println(person);
    }

    public static void print(Person[] persons) {
        for (Person person : persons) {
            if (person != null) {
                System.out.println(person);
            }
        }
    }
}

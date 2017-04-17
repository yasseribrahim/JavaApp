/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appname.util;

import com.appname.model.Person;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author interactive
 */
public class Reader {

    public static String readString(String title) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(title + ": ");
        return reader.readLine();
    }

    public static int readInt(String title) throws Exception {
        return Integer.parseInt(readString(title));
    }

    public static Person readPerson() throws Exception {
        int id = readInt("Enter Id");
        String name = readString("Enter Name");
        String email = readString("Enter E-mail");
        String address = readString("Enter Address");
        return new Person(id, name, email, address);
    }
}

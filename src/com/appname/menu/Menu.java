/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appname.menu;

import com.appname.util.Reader;

/**
 *
 * @author interactive
 */
public class Menu {
    
    private final PersonMenu personMenu;

    public Menu() throws Exception {
        personMenu = new PersonMenu();
    }

    public void menu() throws Exception {
        while (true) {
            System.out.println("--------------------------");
            System.out.println("(1) To Manage Persons.");
            System.out.println("(2) To Manage Object 2.");
            System.out.println("(3) To Manage Object 3.");
            System.out.println("(4) To Manage Object 4.");
            System.out.println("(0) To Exit.");
            int code = Reader.readInt("Enter Operation Code");
            System.out.println("--------------------------");
            switch (code) {
                case 1:
                    personMenu.menu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

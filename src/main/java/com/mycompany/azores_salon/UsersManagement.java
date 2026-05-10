/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.azores_salon;

import java.util.*;

/**
 *
 * @author ragha
 */
public class UsersManagement {
    
    static Scanner input = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();
    static int clientCounter = 4;

    static class User {
        String id, name, mobile, password, type, role;

        // for clients , manager 
        User(String id, String name, String mobile, String password, String type) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.password = password;
        this.type = type;
        this.role = "";
    }
        
        // for employees 
        User(String id, String name, String mobile, String password, String type, String role) {
            this.id = id;
            this.name = name;
            this.mobile = mobile;
            this.password = password;
            this.type = type;
            this.role = role;
        }
    }

    static void addDefaultUsers() {
        users.add(new User("C001", "Raghad", "0550084646", "123456", "Client"));
        users.add(new User("C002", "Aya", "0532168242", "111111", "Client"));
        users.add(new User("C003", "Saja", "0533997414", "101010", "Client"));

        users.add(new User("E001", "Mona", "0551111111", "222222", "Employee", "Hair"));
        users.add(new User("E002", "Ahlam", "0552222222", "333333", "Employee", "Hair"));
        users.add(new User("E003", "Lama", "0553333333", "444444", "Employee", "Skin"));
        users.add(new User("E004", "Noura", "0554444444", "555555", "Employee", "Nails"));

        users.add(new User("Manager001", "Admin", "0500000000", "admin123", "Manager"));
    }

    static boolean isValidMobile(String mobile) {
        return mobile.matches("\\d{10}");
    }

    static boolean isValidPassword(String password) {
        return password.length() >= 6;
    }

    static void registerClientMenu() {
        input.nextLine();

        System.out.println("\n===== Create Client Account =====");

        System.out.print("Enter client name: ");
        String name = input.nextLine();

        System.out.print("Enter mobile number (10 digits): ");
        String mobile = input.nextLine();

        if (!isValidMobile(mobile)) {
            System.out.println("Invalid mobile number. It must be exactly 10 digits.");
            return;
        }

        System.out.print("Enter password (at least 6 characters): ");
        String password = input.nextLine();

        if (!isValidPassword(password)) {
            System.out.println("Invalid password. It must be at least 6 characters.");
            return;
        }

        String id = String.format("C%03d", clientCounter++);

        users.add(new User(id, name, mobile, password, "Client"));
        
        System.out.println("");
        System.out.println("============================================");
        System.out.println("Account created successfully.");
        System.out.println("Your client ID is: " + id);
        System.out.println("============================================");
    }

    static void clientLoginMenu() {
        input.nextLine();

        System.out.println("\n===== Client Login =====");

        System.out.print("Enter mobile number: ");
        String mobile = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        for (User u : users) {
            if (u.mobile.equals(mobile) && u.password.equals(password) && u.type.equals("Client")) {
                System.out.println("");
                System.out.println("Client login successful.");
                Booking.clientMenu(u);
                return;
            }
        }
        System.out.println("");
        System.out.println("Login failed. Please check your mobile number or password.");
    }

    static void managerLoginMenu() {
        input.nextLine();

        System.out.println("\n===== Manager Login =====");

        System.out.print("Enter manager mobile number: ");
        String mobile = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        for (User u : users) {
            if (u.mobile.equals(mobile) && u.password.equals(password) && u.type.equals("Manager")) {
                System.out.println("");
                System.out.println("Manager login successful.");
                ServiceManagement.managerMenu();
                return;
            }
        }
        System.out.println("");
        System.out.println("Manager login failed. Please check your mobile number or password.");
    }
}

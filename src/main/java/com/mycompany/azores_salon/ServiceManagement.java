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
public class ServiceManagement {
    
    static ArrayList<Service> services = new ArrayList<>();
    static int serviceCounter = 5;

    public static class Service {
        String id, name, type;
        double price;

    public Service(String id, String name, double price, String type) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.type = type;
        }
    }

    public static void addDefaultServices() {
        services.add(new Service("S001", "Haircut", 80, "Hair"));
        services.add(new Service("S002", "Hair Dye", 200, "Hair"));
        services.add(new Service("S003", "Facial Cleaning", 150, "Skin"));
        services.add(new Service("S004", "Manicure and Pedicure", 120, "Nails"));
    }

    static void addServiceMenu() {
        
        Scanner input = new Scanner(System.in);

        System.out.println("\n===== Add New Service =====");
        System.out.print("Enter service name: ");
        String name = input.nextLine();

        System.out.print("Enter service price: ");
        double price = input.nextDouble();

        String type = chooseType();

        String id = String.format("S%03d", serviceCounter++);

        services.add(new Service(id, name, price, type));
        System.out.println("");
        System.out.println("============================================");
        System.out.println("Service added successfully.");
        System.out.println("Service ID: " + id);
        System.out.println("Service Type: " + type);
        System.out.println("============================================");
    }
    
    public static String chooseType() {

        Scanner input = new Scanner(System.in);

        System.out.println("\nChoose service type:");
        System.out.println("1. Hair Services");
        System.out.println("2. Skin Services");
        System.out.println("3. Nails Services");
        System.out.println("");
        System.out.print("Enter your choice: ");

        int choice = input.nextInt();

        if (choice == 1) {
            return "Hair";
        }
        else if (choice == 2) {
            return "Skin";
        }
        else {
            return "Nails";
        }
    } 
}

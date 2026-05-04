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

    
    static class Service {
        String id, name, type;
        double price;

        Service(String id, String name, double price, String type) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.type = type;
        }
    }

    static void addDefaultServices() {
        services.add(new Service("S001", "Haircut", 80, "Hair"));
        services.add(new Service("S002", "Hair Dye", 200, "Hair"));
        services.add(new Service("S003", "Facial Cleaning", 150, "Skin"));
        services.add(new Service("S004", "Manicure and Pedicure", 120, "Nails"));
    }

    static void managerMenu() {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Manager Menu =====");
            System.out.println("1. Add New Salon Service");
            System.out.println("2. Logout from Manager Account");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            if (choice == 1) {
                addServiceMenu();
            } else if (choice == 2) {
                System.out.println("");
                System.out.println("Manager logged out successfully.");
            } else {
                System.out.println("");
                System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 2);
    }

    static void addServiceMenu() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n===== Add New Service =====");

        System.out.print("Enter service name: ");
        String name = input.nextLine();

        System.out.print("Enter service price: ");
        double price = input.nextDouble();

        String type = Booking.chooseType();

        String id = String.format("S%03d", serviceCounter++);

        services.add(new Service(id, name, price, type));
        System.out.println("");
        System.out.println("============================================");
        System.out.println("Service added successfully.");
        System.out.println("Service ID: " + id);
        System.out.println("Service Type: " + type);
        System.out.println("============================================");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.azores_salon;

/**
 *
 * @author ragha
 */

import java.util.Scanner;

public class Azores_Salon {

    public static void main(String[] args) {
      
        Scanner input = new Scanner(System.in); 
        ServiceManagement service = new ServiceManagement();
        UsersManagement users = new UsersManagement();
        users.addDefaultUsers();
        service.addDefaultServices();

        int choice;

        do {
            System.out.println("\n===== Azores Salon System =====");
            System.out.println("1. Create Client Account");
            System.out.println("2. Login");
            System.out.println("3. Exit System");
            System.out.println("");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    users.registerClientMenu();
                    break;
                case 2:
                    UsersManagement.User user = users.Login();

                    if (user != null){
                        if (user.type.equals("Client")) {
                            clientMenu(user);
                        }
                        else if (user.type.equals("Manager")) {
                            managerMenu();
                        } }
                    break;
                case 3:
                    System.out.println("Thank you for using Azores Salon System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

 //---------------------------------------------------------------------------
   public static void clientMenu(UsersManagement.User client) {

        Scanner input = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n===== Client Menu =====");
            System.out.println("1. Book Appointment");
            System.out.println("2. Pay for Appointment");
            System.out.println("3. Logout");
            System.out.println("");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            if (choice == 1) {
                Booking.book(client);
            }
            else if (choice == 2) {
                Payment.payMenu(client);
            }
            else if (choice == 3) {
                System.out.println("Client logged out successfully.");
            }
            else {
                System.out.println("Invalid choice.");
            }

        } while (choice != 3);
    }

    public static void managerMenu() {

        Scanner input = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n===== Manager Menu =====");
            System.out.println("1. Add Service");
            System.out.println("2. Logout");
            System.out.println("");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            if (choice == 1) {
                ServiceManagement.addServiceMenu();
            }
            else if (choice == 2) {
                System.out.println("Manager logged out successfully.");
            }
            else {
                System.out.println("Invalid choice.");
            }

        } while (choice != 2);
    }
}

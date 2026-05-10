/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.azores_salon;

/**
 *
 * @author ragha
 */
public class Azores_Salon {

    public static void main(String[] args) {
      
        ServiceManagement service = new ServiceManagement();
        UsersManagement users = new UsersManagement();

        users.addDefaultUsers();
        service.addDefaultServices();

        int choice;

        do {
            System.out.println("\n===== Azores Salon System =====");
            System.out.println("1. Create Client Account");
            System.out.println("2. Login as Client");
            System.out.println("3. Login as Manager");
            System.out.println("4. Exit System");
            System.out.println("");
            System.out.print("Enter your choice: ");

            choice = users.input.nextInt();

            switch (choice) {
                case 1:
                    users.registerClientMenu();
                    break;
                case 2:
                    users.clientLoginMenu();
                    break;
                case 3:
                    users.managerLoginMenu();
                    break;
                case 4:
                    System.out.println("Thank you for using Azores Salon System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }
}

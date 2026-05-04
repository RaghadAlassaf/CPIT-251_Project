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
public class Booking {
    

  
static ArrayList <Appointment> appointments = new ArrayList<>();
static int appointmentCounter = 1;

static class Appointment {
    String id, date, time;
    String status = "Booked";
    String paymentStatus = "Pending";

    UsersManagment.User client;
    UsersManagment.User employee;
    ServiceManagement.Service service;

    Appointment(String id, UsersManagment.User client, ServiceManagement.Service service,
                UsersManagment.User employee, String date, String time) {
        this.id = id;
        this.client = client;
        this.service = service;
        this.employee = employee;
        this.date = date;
        this.time = time;
    }
}

static void clientMenu(UsersManagment.User client) {
    Scanner input = new Scanner(System.in);
    int choice;

    do {
        System.out.println("\n===== Client Menu =====");
        System.out.println("1. Book Appointment ");
        System.out.println("2. Pay for Appointment");
        System.out.println("3. Logout from Client Account");
        System.out.println("");
        System.out.print("Enter your choice: ");

        choice = input.nextInt();

        if (choice == 1) {
            book(client);
        } else if (choice == 2) {
            Payment.payMenu(client);
        } else if (choice == 3) {
            System.out.println("");
            System.out.println("Client logged out successfully.");
        } else {
            System.out.println("");
            System.out.println("Invalid choice. Please try again.");
        }

    } while (choice != 3);
}

static void book(UsersManagment.User client) {
    Scanner input = new Scanner(System.in);

    System.out.println("\n===== Book Appointment =====");

    String type = chooseType();

    ArrayList<ServiceManagement.Service> serviceList = new ArrayList<>();

    for (ServiceManagement.Service service : ServiceManagement.services) {
        if (service.type.equals(type)) {
            serviceList.add(service);
        }
    }

    if (serviceList.isEmpty()) {
        System.out.println("No services available for this type.");
        return;
    }

    System.out.println("\nChoose service:");
    for (int i = 0; i < serviceList.size(); i++) {
        ServiceManagement.Service service = serviceList.get(i);
        System.out.println((i + 1) + ". " + service.name + " - " + service.price + " SAR");
    }
    System.out.println("");
    System.out.print("Enter service number: ");
    int serviceChoice = input.nextInt();

    if (serviceChoice < 1 || serviceChoice > serviceList.size()) {
        System.out.println("");
        System.out.println("Invalid service choice.");
        return;
    }

    ServiceManagement.Service selectedService = serviceList.get(serviceChoice - 1);

    ArrayList<UsersManagment.User> employeeList = new ArrayList<>();

    for (UsersManagment.User user : UsersManagment.users) {
        if (user.type.equals("Employee") && user.role.equals(type)) {
            employeeList.add(user);
        }
    }

    if (employeeList.isEmpty()) {
        System.out.println("No employees available for this service type.");
        return;
    }

    System.out.println("\nChoose employee:");
    for (int i = 0; i < employeeList.size(); i++) {
        UsersManagment.User employee = employeeList.get(i);
        System.out.println((i + 1) + ". " + employee.name + " - " + employee.role);
    }
    System.out.println("");
    System.out.print("Enter employee number: ");
    int employeeChoice = input.nextInt();

    if (employeeChoice < 1 || employeeChoice > employeeList.size()) {
        System.out.println("Invalid employee choice.");
        return;
    }

    UsersManagment.User selectedEmployee = employeeList.get(employeeChoice - 1);

    String date = chooseDate();
    String time = chooseTime();

    String id = String.format("A%03d", appointmentCounter++);

    Appointment appointment = new Appointment(
            id,
            client,
            selectedService,
            selectedEmployee,
            date,
            time
    );

    appointments.add(appointment);
    
    System.out.println("");
    System.out.println("============================================");
    System.out.println("Appointment booked successfully.");
    displayAppointment(appointment);

    System.out.println("\nDo you want to pay now?");
    System.out.println("1. Yes");
    System.out.println("2. Pay later");
    System.out.print("Enter your choice: ");

    int payChoice = input.nextInt();

    if (payChoice == 1) {
        Payment.pay(appointment);
    } else {
        System.out.println("");
        System.out.println("Payment saved as pending.");
    }
}

static String chooseType() {
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
    } else if (choice == 2) {
        return "Skin";
    } else if (choice == 3) {
        return "Nails";
    } else {
        System.out.println("Invalid choice. Hair Services selected by default.");
        return "Hair";
    }
}

static String chooseDate() {
    Scanner input = new Scanner(System.in);

    String[] dates = {"2026-05-14", "2026-05-15", "2026-05-16"};
    System.out.println("");
    System.out.println("Choose appointment date:");
    for (int i = 0; i < dates.length; i++) {
        System.out.println((i + 1) + ". " + dates[i]);
    }
    System.out.println("");
    System.out.print("Enter your choice: ");
    int choice = input.nextInt();

    if (choice < 1 || choice > dates.length) {
        System.out.println("Invalid choice. First date selected.");
        return dates[0];
    }

    return dates[choice - 1];
}

static String chooseTime() {
    Scanner input = new Scanner(System.in);

    String[] times = {"10:00 AM", "12:00 PM", "4:00 PM", "6:00 PM"};

    System.out.println("");
    System.out.println("Choose appointment time:");
    for (int i = 0; i < times.length; i++) {
        System.out.println((i + 1) + ". " + times[i]);
    }

    System.out.println("");
    System.out.print("Enter your choice: ");
    int choice = input.nextInt();

    if (choice < 1 || choice > times.length) {
        System.out.println("Invalid choice. First time selected.");
        return times[0];
    }

    return times[choice - 1];
}

static void displayAppointment(Appointment appointment) {
    System.out.println("\n===== Appointment Details =====");
    System.out.println("Appointment ID: " + appointment.id);
    System.out.println("Client: " + appointment.client.name);
    System.out.println("Service: " + appointment.service.name);
    System.out.println("Employee: " + appointment.employee.name);
    System.out.println("Date: " + appointment.date);
    System.out.println("Time: " + appointment.time);
    System.out.println("Appointment Status: " + appointment.status);
    System.out.println("Payment Status: " + appointment.paymentStatus);
    System.out.println("Total Amount: " + appointment.service.price + " SAR");
    System.out.println("============================================");
}

}

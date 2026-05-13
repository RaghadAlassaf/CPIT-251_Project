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

public static class Appointment {
    String id, date, time;
    String status = "Booked";
    String paymentStatus = "Pending";

    UsersManagement.User client;
    UsersManagement.User employee;
    ServiceManagement.Service service;

public Appointment(String id, UsersManagement.User client, ServiceManagement.Service service, UsersManagement.User employee, String date, String time) {
        this.id = id;
        this.client = client;
        this.service = service;
        this.employee = employee;
        this.date = date;
        this.time = time;
    }
}

public static void book(UsersManagement.User client) {
    Scanner input = new Scanner(System.in);

    System.out.println("\n===== Book Appointment =====");
    String type = ServiceManagement.chooseType();

    //Display Service
    ArrayList<ServiceManagement.Service> serviceList = new ArrayList<>();
    for (ServiceManagement.Service s : ServiceManagement.services) {
        if (s.type.equals(type)) {
            serviceList.add(s);
        }
    }
    System.out.println("--------------------------------------");
    System.out.println("Choose service:");
    for (int i = 0; i < serviceList.size(); i++) {
        System.out.println((i + 1) + ". " + serviceList.get(i).name + " - " + serviceList.get(i).price + " SAR");
    }
    System.out.println("--------------------------------------");
    System.out.print("Enter service number: ");
    int serviceChoice = input.nextInt();

    //Display Employee
    ArrayList<UsersManagement.User> employeeList = new ArrayList<>();

    for (UsersManagement.User u : UsersManagement.users) {
        if (u.type.equals("Employee") && u.role.equals(type)) {
            employeeList.add(u);
        }
    }
    System.out.println("\nChoose employee:");
    for (int i = 0; i < employeeList.size(); i++) {
        System.out.println((i + 1) + ". " + employeeList.get(i).name);
    }
    System.out.println("--------------------------------------");
    System.out.print("Enter employee number: ");
    int employeeChoice = input.nextInt();

    //Display Date
    System.out.println("--------------------------------------");
    System.out.println("Choose appointment date:");
    String[] dates = {"14-05-2026", "15-05-2026", "16-05-2026"};
    for (int i = 0; i < dates.length; i++) {
    System.out.println((i + 1) + ". " + dates[i]);
    }
    System.out.println("Enter your choice:");
    int Datechoice = input.nextInt();

    //Display Time
    System.out.println("--------------------------------------");
    System.out.println("Choose appointment time:");
    String[] time =  {"1:00 PM", "2:00 PM", "6:00 PM", "8:00 PM"};
    for (int i = 0; i < time.length; i++) {
        System.out.println((i + 1) + ". " + time[i]);
    }
    System.out.println("--------------------------------------");
    System.out.print("Enter your choice: ");
    int Timechoice = input.nextInt();

    String id = String.format("A%03d", appointmentCounter++);
    Appointment appointment = new Appointment( id, client, serviceList.get(serviceChoice-1), employeeList.get(employeeChoice-1), dates[Datechoice-1], time[Timechoice-1] );
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

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
public class Payment {
    
    static int paymentCounter = 1;

    static void payMenu(UsersManagement.User client) {
        ArrayList<Booking.Appointment> pendingAppointments = new ArrayList<>();

        for (Booking.Appointment appointment : Booking.appointments) {
            if (appointment.client.id.equals(client.id) && appointment.paymentStatus.equals("Pending")) {
                pendingAppointments.add(appointment);
            }
        }

        if (pendingAppointments.isEmpty()) {
            System.out.println("No pending appointments found.");
            return;
        }

        System.out.println("\n===== Pending Appointments =====");

        for (int i = 0; i < pendingAppointments.size(); i++) {
            Booking.Appointment appointment = pendingAppointments.get(i);
            System.out.println((i + 1) + ". Appointment ID: " + appointment.id
                    + " | Service: " + appointment.service.name
                    + " | Amount: " + appointment.service.price + " SAR");
        }

        Scanner input = new Scanner(System.in);

        System.out.println("");
        System.out.print("Choose appointment to pay: ");
        int choice = input.nextInt();

        if (choice < 1 || choice > pendingAppointments.size()) {
            System.out.println("Invalid appointment choice.");
            return;
        }

        pay(pendingAppointments.get(choice - 1));
    }

    static void pay(Booking.Appointment appointment) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n===== Payment =====");
        System.out.println("Appointment ID: " + appointment.id);
        System.out.println("Amount: " + appointment.service.price + " SAR");
        System.out.println("Choose payment method:");
        System.out.println("1. Cash");
        System.out.println("2. Card (Credit/Debit)");
        System.out.println("");
        System.out.print("Enter your choice: ");

        int choice = input.nextInt();

        if (choice == 2) {
            input.nextLine();

            System.out.print("Enter card number (16 digits): ");
            String cardNumber = input.nextLine();

            if (!cardNumber.matches("\\d{16}")) {
                System.out.println("Invalid card number. It must be 16 digits.");
                return;
            }

            System.out.print("Enter CVV (3 digits): ");
            String cvv = input.nextLine();

            if (!cvv.matches("\\d{3}")) {
                System.out.println("Invalid CVV. It must be 3 digits.");
                return;
            }
        } else if (choice != 1) {
            System.out.println("Invalid payment method.");
            return;
        }

        String paymentId = String.format("P%03d", paymentCounter++);

        appointment.paymentStatus = "Paid";
        appointment.status = "Paid";

        System.out.println("============================================");
        System.out.println("Payment completed successfully.");
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Payment Status: " + appointment.paymentStatus);
        System.out.println("============================================");
    }
    
}

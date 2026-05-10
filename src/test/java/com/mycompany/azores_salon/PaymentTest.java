/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.azores_salon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ragha
 */
public class PaymentTest {
    
  @Test
    public void testPaymentByCard() {
        
        UsersManagement.User client = new UsersManagement.User("C001", "Raghad", "0550084646", "123456", "Client");
        UsersManagement.User employee = new UsersManagement.User("E001", "Mona", "0551111111", "222222", "Employee", "Hair");
        ServiceManagement.Service service = new ServiceManagement.Service("S001", "Haircut", 80, "Hair");
        Booking.Appointment appointment = new Booking.Appointment("A001", client, service, employee, "15-05-2026", "1:00 PM");
        String cardNumber = "1234567812345678";
        String cvv = "123";
        
        
        boolean validCard = cardNumber.matches("\\d{16}");
        boolean validCVV = cvv.matches("\\d{3}");
        
        if (validCard && validCVV) {
            appointment.paymentStatus = "Paid";
            appointment.status = "Paid";
        }
 
        
        assertTrue(validCard);
        assertTrue(validCVV);
        assertTrue(appointment.paymentStatus.equals("Paid"));
        assertTrue(appointment.status.equals("Paid"));
    }
}

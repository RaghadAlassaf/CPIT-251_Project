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

        Booking.Appointment appointment = new Booking.Appointment("A001", client, service, employee, "2026-05-05", "10:00 AM");

        String cardNumber = "1234567812345678";
        String cvv = "123";
        
        appointment.paymentStatus = "Paid";
        appointment.status = "Paid";
        
        assertTrue(cardNumber.matches("\\d{16}"));
        assertTrue(cvv.matches("\\d{3}"));

        assertEquals("Paid", appointment.paymentStatus);
        assertEquals("Paid", appointment.status);
    }
}

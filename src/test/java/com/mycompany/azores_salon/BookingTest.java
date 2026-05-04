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
public class BookingTest {

     @Test
    public void testBookAppointment() {
        
        UsersManagment.User client = new UsersManagment.User("C001", "Raghad", "0550084646", "123456", "Client");

        UsersManagment.User employee = new UsersManagment.User("E001", "Mona", "0551111111", "222222", "Employee", "Hair");

        ServiceManagement.Service service = new ServiceManagement.Service("S001", "Haircut", 80, "Hair");

        Booking.Appointment appointment = new Booking.Appointment("A001", client, service, employee, "2026-05-05", "10:00 AM");

        assertEquals("A001", appointment.id);
        assertEquals("Raghad", appointment.client.name);
        assertEquals("Haircut", appointment.service.name);
        assertEquals("Mona", appointment.employee.name);
        assertEquals("2026-05-05", appointment.date);
        assertEquals("10:00 AM", appointment.time);
        assertEquals("Booked", appointment.status);
        assertEquals("Pending", appointment.paymentStatus);
    }
}





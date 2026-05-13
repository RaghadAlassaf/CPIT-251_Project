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
public class ServiceManagementTest {

     @Test
    public void testAddService() {

        ServiceManagement.Service service = new ServiceManagement.Service("S005", "Keratin", 300, "Hair");

        ServiceManagement.services.add(service);

        assertEquals("S005", service.id);
        assertEquals("Keratin", service.name);
        assertEquals(300.0, service.price);
        assertEquals("Hair", service.type);
    }
    
}

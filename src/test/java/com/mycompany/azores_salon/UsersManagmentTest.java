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
public class UsersManagmentTest {
 
     @Test
    public void testCreateClientAccount() {

        UsersManagment.User client = new UsersManagment.User("C004", "Seren", "0501502543", "123456", "Client");

        UsersManagment.users.add(client);

        assertEquals("C004", client.id);
        assertEquals("Seren", client.name);
        assertEquals("0501502543", client.mobile);
        assertEquals("Client", client.type);
    }
    
}

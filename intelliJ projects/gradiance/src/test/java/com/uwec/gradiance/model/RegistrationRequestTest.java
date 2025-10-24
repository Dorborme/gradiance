package com.uwec.gradiance.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class RegistrationRequestTest {

    @Test
    public void testSetAndGetStudentId() {
        RegistrationRequest request = new RegistrationRequest();
        request.setStudentId("12345");
        assertEquals("12345", request.getStudentId());
    }

    @Test
    public void testSetAndGetFirstName() {
        RegistrationRequest request = new RegistrationRequest();
        request.setFirstName("John");
        assertEquals("John", request.getFirstName());
    }

    @Test
    public void testSetAndGetMiddleInitial() {
        RegistrationRequest request = new RegistrationRequest();
        request.setMiddleInitial("A");
        assertEquals("A", request.getMiddleInitial());
    }

    @Test
    public void testSetAndGetLastName() {
        RegistrationRequest request = new RegistrationRequest();
        request.setLastName("Doe");
        assertEquals("Doe", request.getLastName());
    }

    @Test
    public void testSetAndGetEmail() {
        RegistrationRequest request = new RegistrationRequest();
        request.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", request.getEmail());
    }

    @Test
    public void testSetAndGetPassword() {
        RegistrationRequest request = new RegistrationRequest();
        request.setPassword("password123");
        assertEquals("password123", request.getPassword());
    }

    @Test
    public void testSetAndGetConfirmPassword() {
        RegistrationRequest request = new RegistrationRequest();
        request.setConfirmPassword("password123");
        assertEquals("password123", request.getConfirmPassword());
    }
}

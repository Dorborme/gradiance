package com.uwec.gradiance.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class RoleTest {

    @Test
    void testNoArgsConstructor() {
        Role role = new Role();
        assertNull(role.getId());
        assertNull(role.getName());
    }

    @Test
    void testAllArgsConstructor() {
        Role role = new Role("ROLE_USER");
        assertNull(role.getId());
        assertEquals("ROLE_USER", role.getName());
    }

    @Test
    void testSettersAndGetters() {
        Role role = new Role();
        role.setId(10L);
        role.setName("ROLE_ADMIN");
        assertEquals(10L, role.getId());
        assertEquals("ROLE_ADMIN", role.getName());
    }

    @Test
    void testEqualsSameObject() {
        Role role = new Role("ROLE_USER");
        assertEquals(role, role);
    }

    @Test
    void testEqualsEqualObjects() {
        Role role1 = new Role("ROLE_USER");
        Role role2 = new Role("ROLE_USER");
        assertEquals(role1, role2);
    }

    @Test
    void testEqualsDifferentObjects() {
        Role role1 = new Role("ROLE_USER");
        Role role2 = new Role("ROLE_ADMIN");
        assertNotEquals(role1, role2);
    }

    @Test
    void testEqualsNull() {
        Role role = new Role("ROLE_USER");
        assertNotEquals(role, null);
    }

    @Test
    void testEqualsDifferentClass() {
        Role role = new Role("ROLE_USER");
        String other = "ROLE_USER";
        assertNotEquals(role, other);
    }

    @Test
    void testHashCodeEqualObjects() {
        Role role1 = new Role("ROLE_USER");
        Role role2 = new Role("ROLE_USER");
        assertEquals(role1.hashCode(), role2.hashCode());
    }

    @Test
    void testHashCodeDifferentObjects() {
        Role role1 = new Role("ROLE_USER");
        Role role2 = new Role("ROLE_ADMIN");
        assertNotEquals(role1.hashCode(), role2.hashCode());
    }
}

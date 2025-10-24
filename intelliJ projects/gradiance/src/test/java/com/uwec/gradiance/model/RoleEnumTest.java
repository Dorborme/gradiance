package com.uwec.gradiance.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;



public class RoleEnumTest {

    @Test
    public void testEnumValues() {
        RoleEnum[] roles = RoleEnum.values();
        assertEquals(4, roles.length);
        assertEquals(RoleEnum.STUDENT, roles[0]);
        assertEquals(RoleEnum.TA, roles[1]); 
        assertEquals(RoleEnum.INSTRUCTOR, roles[2]);
        assertEquals(RoleEnum.ADMIN, roles[3]);
    }

    @Test 
    public void testEnumValueOf() {
        assertEquals(RoleEnum.STUDENT, RoleEnum.valueOf("STUDENT"));
        assertEquals(RoleEnum.TA, RoleEnum.valueOf("TA"));
        assertEquals(RoleEnum.INSTRUCTOR, RoleEnum.valueOf("INSTRUCTOR")); 
        assertEquals(RoleEnum.ADMIN, RoleEnum.valueOf("ADMIN"));
    }

}

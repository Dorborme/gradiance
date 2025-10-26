package com.uwec.gradiance.database;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class coursesTest {

    // create user for all tests to utilize
    Users user = new Users();

    @BeforeAll
    public static void setUp() {
        System.out.println("Starting courses tests...");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("courses testing complete...");
    }

    // constructor tests
    @Test
    void testCompetencyWithNameAndUser() {
        courses course = new courses("Algorithms", user);
        assertEquals("Algorithms", course.getCourse_name());
        assertEquals(user, course.getCreated_by());
        assertNull(course.getPre_reqs());
    }

    @Test
    void testCompetencyWithAllFields() {
        courses course = new courses("Algorithms", user, "Advanced Data Structures");
        assertEquals("Algorithms", course.getCourse_name());
        assertEquals(user, course.getCreated_by());
        assertEquals("Advanced Data Structures", course.getPre_reqs());
    }

    // setter tests
    @Test
    void testSetCourse_name() {

    }

    @Test
    void testSetCreated_by() {

    }

    @Test
    void testSetPre_reqs() {

    }
}
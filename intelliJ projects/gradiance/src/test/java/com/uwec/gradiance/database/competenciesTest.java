package com.uwec.gradiance.database;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class competenciesTest {

    @BeforeAll
    public static void setUp() {
        System.out.println("Starting competencies tests...");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("competencies tests completed...");
    }

    // constructor tests
    @Test
    void testConstructorWithName() {
        competencies comp = new competencies("Stack");
        assertEquals("Stack", comp.getCompetency_name());
        assertNull(comp.getDescription());
        assertNull(comp.getSemester());
    }

    @Test
    void testConstructorWithNameAndDescription() {
        competencies comp = new competencies("Stack", "Describe the stack data structure");
        assertEquals("Stack", comp.getCompetency_name());
        assertEquals("Describe the stack data structure", comp.getDescription());
        assertNull(comp.getSemester());
    }

    @Test
    void testConstructorWithAllFields() {
        competencies comp = new competencies("Stack", "Describe the stack data structure", "Fall 2025");
        assertEquals("Stack", comp.getCompetency_name());
        assertEquals("Describe the stack data structure", comp.getDescription());
        assertEquals("Fall 2025", comp.getSemester());
    }

    // setter tests
    @Test
    void testSetCompetency_name() {
        // do later after writing code
    }

    @Test
    void testSetCourse_id() {
        // do later after writing code
    }

    @Test
    void testSetDescription() {
        // do later after writing code
    }

    @Test
    void testSetSemester() {
        // do later after writing code
    }
}

package com.uwec.gradiance.database;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class InterviewsTest {

    // create user and course for all tests to utilize
    Users user = new Users();
    courses course = new courses("Algorithms", user);

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
    void testConstructorWithAllFields() {
        interviews interview = new interviews(user, course);
        assertEquals(user, interview.getStudent_id());
        assertEquals(course, interview.getCourse_id());
        assertNotNull(interview.getConducted_at());
    }

    // setter tests
    @Test
    void testSetConducted_at() {

    }

    @Test
    void testSetCourse_id() {

    }

    @Test
    void testSetStudent_id() {

    }
}

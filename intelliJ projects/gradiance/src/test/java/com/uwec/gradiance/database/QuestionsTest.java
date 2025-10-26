package com.uwec.gradiance.database;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class QuestionsTest {

    // create user necessary for tests
    Users user = new Users();
    questions testQuestion = new questions("What is an int?", user);

    @BeforeAll
    public static void setUp() {
        System.out.println("Starting questions tests...");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("questions testing complete...");
    }

    // constructor tests in order of constructors in questions
    @Test
    void testConstructor1() {
        questions question = new questions("What is a stack?", user);
        assertEquals("What is a stack?", question.getQuestion_text());
        assertEquals(user, question.getCreated_by());
        assertNotNull(question.getLast_modified_at());
        assertNotNull(question.getCreated_at());
    }

    @Test
    void testConstructor2() {
        questions question = new questions("What is a stack?", "www.image.com", user);
        assertEquals("What is a stack?", question.getQuestion_text());
        assertEquals("www.image.com", question.getQuestion_image_url());
        assertEquals(user, question.getCreated_by());
        assertNotNull(question.getLast_modified_at());
        assertNotNull(question.getCreated_at());
    }

    @Test
    void testConstructor3() {
        questions question = new questions("What is a stack?", testQuestion, user);
        assertEquals("What is a stack?", question.getQuestion_text());
        assertEquals(testQuestion, question.getParent_question_id());
        assertEquals(user, question.getCreated_by());
        assertNotNull(question.getCreated_at());
        assertNotNull(question.getLast_modified_at());
    }

    @Test
    void testConstructor4() {
        questions question = new questions("What is a stack?", "www.image.com", testQuestion, user);
        assertEquals("What is a stack?", question.getQuestion_text());
        assertEquals("www.image.com", question.getQuestion_image_url());
        assertEquals(testQuestion, question.getParent_question_id());
        assertEquals(user, question.getCreated_by());
        assertNotNull(question.getCreated_at());
        assertNotNull(question.getLast_modified_at());
    }

    // setter tests
    @Test
    void testSetCreated_at() {

    }

    @Test
    void testSetCreated_by() {

    }

    @Test
    void testSetLast_modified_at() {

    }

    @Test
    void testSetParent_question_id() {

    }

    @Test
    void testSetQuestion_image_url() {

    }

    @Test
    void testSetQuestion_text() {

    }

    @Test
    void testUpdateTimestamp() {

    }
}

package com.uwec.gradiance.database;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class QuestionUsagesTest {

    // create question and competency for tests
    Users user = new Users();
    questions question = new questions("What is a stack?", user);
    competencies competency = new competencies("Stack");

    @BeforeAll
    public static void setUp() {
        System.out.println("Starting questionsusages tests...");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("questionsusages testing complete...");
    }

    // constructor tests
    @Test
    void testConstructorWithAllFields() {
        questionusages questionusage = new questionusages(question, competency);
        assertEquals(question, questionusage.getQuestion_id());
        assertEquals(competency, questionusage.getCompetency_id());
    }

    // setter tests
    @Test
    void testSetCompetency_id() {

    }

    @Test
    void testSetQuestion_id() {

    }
}

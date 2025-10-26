package com.uwec.gradiance.database;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class QuestionsDuringInterviewTest {

    // create necessary entities for tests to utilize
    Users user = new Users();
    questions question = new questions("What is an algorithm?", user);
    competencies competency = new competencies("Algorithm Intro");
    courses course = new courses("Algorithms", user);
    interviews interview = new interviews(user, course);
    questionusages testQuestionUsage = new questionusages(question, competency);

    @BeforeAll
    public static void setUp() {
        System.out.println("Starting questionsduringinterview tests...");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("questionsduringinterview testing complete...");
    }

    // constructor tests
    
    @Test
    void testConstructorWithAllFields() {
        questionsduringinterview interviewQuestion = new questionsduringinterview(interview, testQuestionUsage);
        assertEquals(interview, interviewQuestion.getInterview_id());
        assertEquals(testQuestionUsage, interviewQuestion.getUsage_id());
    }

    // setter tests

    @Test
    void testSetInterview_id() {

    }

    @Test
    void testSetUsage_id() {

    }
}

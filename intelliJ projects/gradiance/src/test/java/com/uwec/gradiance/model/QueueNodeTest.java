package com.uwec.gradiance.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class QueueNodeTest {
    
    @BeforeAll
    public static void setUp() {
    System.out.println("Starting QueueNode tests...");

    }

    @Test
    @DisplayName("Test QueueNode Creation")
    void testQueueNodeCreation() {
        QueueNode node = new QueueNode("student1@email.com", "Operating Systems", "Knowledge Review");
        assertNotNull(node);
        assertEquals("student1@email.com", node.getEmail());
        assertEquals("Operating Systems", node.getCourse());
        assertEquals("Knowledge Review", node.getEvaluation());
        assertEquals(0, node.getPriority());
        assertNotNull(node.getJoinTime());
    }

    @Test
    @DisplayName("Test QueueNode Priority Change")
    void testQueueNodePriorityChange() {
        QueueNode node = new QueueNode("student1@email.com", "Operating Systems", "Knowledge Review");
        assertNotNull(node);
        assertEquals(0, node.getPriority());

        // increment priority
        node.setPriority(1);
        assertEquals(1, node.getPriority());

        // decrement priority
        node.setPriority(-2);
        assertEquals(-1, node.getPriority());

        //fractional priority change (should'nt be possible)


        //reset priority to 0
        
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("Finished QueueNode tests.");
    }

}

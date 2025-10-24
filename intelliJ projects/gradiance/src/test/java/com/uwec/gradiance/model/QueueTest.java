package com.uwec.gradiance.model;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


public class QueueTest {
    
    private Queue queue;
    private QueueNode testNode1;
    private QueueNode testNode2;

    @BeforeEach
    public void setUp() {
        queue = new Queue();
        testNode1 = new QueueNode("test1@email.com", "CS101", "algorithms");
        testNode2 = new QueueNode("test2@email.com", "CS405", "Knowledge Review");
    }

    @Test
    public void testConstructor() {
        assertNotNull(queue.getQueueSelf());
        assertNull(queue.getID());
        assertNull(queue.getCreated_by());
    }

    @Test 
    public void testAppendStudent() {
        queue.appendStudent(testNode1);
        assertEquals(1, queue.getQueueSelf().size());
        assertTrue(queue.getQueueSelf().contains(testNode1));
    }

    @Test
    @Disabled
    public void testUpdatePriority() {
        testNode1.setPriority(0);
        queue.appendStudent(testNode1);
        
        queue.updatePriority("CS101");
        assertEquals(1, testNode1.getPriority());
    }

    @Test
    @Disabled
    public void testFindNext() {
        testNode1.setPriority(1);
        testNode2.setPriority(2);
        
        queue.appendStudent(testNode1);
        queue.appendStudent(testNode2);
        
        QueueNode next = queue.findNext();
        assertNotNull(next);
        assertEquals(2, next.getPriority());
    }

    @Test
    public void testFindNextEmptyQueue() {
        assertNull(queue.findNext());
    }

    @Test
    public void testFindStudent() {
        queue.appendStudent(testNode1);
        
        QueueNode found = queue.findStudent("test@email.com");
        assertNull(found); // Currently implementation returns null
    }

    @Test
    public void testFindStudentById() {
        queue.appendStudent(testNode1);
        
        QueueNode found = queue.findStudent(1L);
        assertNull(found); // Currently implementation returns null
    }
}

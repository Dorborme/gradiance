package com.uwec.gradiance.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import jakarta.validation.constraints.NotBlank;

public class StompMessageDTOTest {
    
    @BeforeAll
    public static void setUp() {
        System.out.println("Starting StompMessageDTO tests...");
    }

    @Test
    public void testStompMessageDTOCreation() {
        StompMessageDTO message = new StompMessageDTO("Instructor", "Hello World");
        assertEquals("Hello World", message.getMessage());
        assertEquals("Instructor", message.getSender());
        assertEquals(String.class, message.getTimestamp().getClass());
    }

    @Test
    @DisplayName("timestamp is numeric and within creation time window")
    public void testTimestampWithinWindow() {
        long before = System.currentTimeMillis();
        StompMessageDTO message = new StompMessageDTO("A", "B");
        long after = System.currentTimeMillis();

        assertNotNull(message.getTimestamp(), "timestamp should not be null");

        long ts = Long.parseLong(message.getTimestamp());
        assertTrue(ts >= before && ts <= after, "timestamp should be between before and after creation times");
    }

    @Test
    @DisplayName("multiple instances have non-decreasing timestamps")
    public void testMultipleInstancesTimestampsOrder() throws InterruptedException {
        StompMessageDTO m1 = new StompMessageDTO("s1", "m1");
        // small sleep to ensure different millisecond if possible
        Thread.sleep(1);
        StompMessageDTO m2 = new StompMessageDTO("s2", "m2");

        long t1 = Long.parseLong(m1.getTimestamp());
        long t2 = Long.parseLong(m2.getTimestamp());
        assertTrue(t2 >= t1, "second message timestamp should be >= first message timestamp");
    }


    @Test
    @DisplayName("timestamp parses to a non-negative long")
    public void testTimestampParsesToNonNegativeLong() {
        StompMessageDTO dto = new StompMessageDTO("s", "m");
        String tsStr = dto.getTimestamp();
        assertNotNull(tsStr, "timestamp should not be null");
        long ts = Long.parseLong(tsStr);
        assertTrue(ts >= 0L, "timestamp should be non-negative");
    }

    @Test
    @DisplayName("fields have expected validation annotations and are private")
    public void testFieldAnnotationsAndVisibility() throws NoSuchFieldException {
        Class<StompMessageDTO> cls = StompMessageDTO.class;

        Field senderField = cls.getDeclaredField("sender");
        assertTrue(Modifier.isPrivate(senderField.getModifiers()), "sender field should be private");
        assertTrue(senderField.isAnnotationPresent(NotBlank.class), "sender should be annotated with @NotBlank");

        Field messageField = cls.getDeclaredField("message");
        assertTrue(Modifier.isPrivate(messageField.getModifiers()), "message field should be private");
        assertTrue(messageField.isAnnotationPresent(NotBlank.class), "message should be annotated with @NotBlank");

        Field timestampField = cls.getDeclaredField("timestamp");
        assertTrue(Modifier.isPrivate(timestampField.getModifiers()), "timestamp field should be private");
    }

    @Test
    @DisplayName("getter methods exist and return String")
    public void testGettersExistAndReturnString() throws NoSuchMethodException {
        Class<StompMessageDTO> cls = StompMessageDTO.class;

        Method getSender = cls.getMethod("getSender");
        assertEquals(String.class, getSender.getReturnType(), "getSender should return String");

        Method getMessage = cls.getMethod("getMessage");
        assertEquals(String.class, getMessage.getReturnType(), "getMessage should return String");

        Method getTimestamp = cls.getMethod("getTimestamp");
        assertEquals(String.class, getTimestamp.getReturnType(), "getTimestamp should return String");
    }

    @Test
    @DisplayName("constructor throws IllegalArgumentException for null sender")
    public void testConstructorThrowsForNullSender() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new StompMessageDTO(null, "msg");
        });
        assertEquals("sender cannot be null or blank", exception.getMessage());
    }

    @Test
    @DisplayName("constructor throws IllegalArgumentException for blank sender")
    public void testConstructorThrowsForBlankSender() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new StompMessageDTO("   ", "msg");
        });
        assertEquals("sender cannot be null or blank", exception.getMessage());
    }

    @Test
    @DisplayName("constructor throws IllegalArgumentException for null message")
    public void testConstructorThrowsForNullMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new StompMessageDTO("sender", null);
        });
        assertEquals("message cannot be null or blank", exception.getMessage());
    }

    @Test
    @DisplayName("constructor throws IllegalArgumentException for blank message")
    public void testConstructorThrowsForBlankMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new StompMessageDTO("sender", "   ");
        });
        assertEquals("message cannot be null or blank", exception.getMessage());
    }


    @AfterAll
    public static void tearDown() {
        System.out.println("StompMessageDTO tests complete.");
    }

}

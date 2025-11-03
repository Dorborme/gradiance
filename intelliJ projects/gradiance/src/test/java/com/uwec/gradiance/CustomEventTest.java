package com.uwec.gradiance;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CustomEventTest {

@Test
public void testCustomEventMessage(){
    Object source = new Object();
    String expectedMessage = "Test Event Message";

    CustomEvent event = new CustomEvent(source,expectedMessage);
    assertEquals(expectedMessage, event.getMessage());
    assertEquals(source, event.getSource());
}

    
}

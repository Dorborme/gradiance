package com.uwec.gradiance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CustomEventListenerTest {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Test
    public void testCustomEventIsReceived() {
        // This test checks that when a CustomEvent is published,
        // the CustomEventListener receives it and prints the correct message.

        // Capture system output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Publish the custom event
        CustomEvent event = new CustomEvent(this, "Gradiance event triggered!");
        publisher.publishEvent(event);

        // Give Spring some time to process the event
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Convert captured output to string
        String output = outputStream.toString().trim();

        // Restore System.out
        System.setOut(originalOut);

        // Assert that the listener printed the expected message
        assertTrue(
            output.contains("Received custom event from Spring: Gradiance event triggered!"),
            "Listener should print the correct event message."
        );
    }
}

package com.uwec.gradiance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CustomEventPublisherTest {

@Autowired
private CustomEventPublisher.CustomSpringEventPublisher customSpringEventPublisher;

@Test
public void testPublishCustomEvent(){
    // This test checks when custom event is published

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));



    //Publish custom event
    customSpringEventPublisher.publishCustomEvent(" Gradience event fired!");

try{
    Thread.sleep(200);
    } catch(InterruptedException  e){
        e.printStackTrace();
    }
String output = outputStream.toString().trim();

System.setOut(originalOut);

assertTrue(output.contains("Publishing custom event"),"Publisher should print a message when firing event.");

assertTrue(output.contains("Received custom event from spring: Gradiance event fired!"),
"Listner should print correct message.");

}

    

}

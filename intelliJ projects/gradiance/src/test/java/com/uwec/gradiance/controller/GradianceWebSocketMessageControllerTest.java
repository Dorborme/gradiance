package com.uwec.gradiance.controller;

import com.uwec.gradiance.dto.StompMessageDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import static org.mockito.Mockito.*;


public class GradianceWebSocketMessageControllerTest {

    private GradianceWebSocketMessageController controller;
    private SimpMessagingTemplate messagingTemplate;

    @BeforeAll 
    public static void setUpAll() {
        System.out.println("Starting GradianceWebSocketMessageController tests...");
    }


    @BeforeEach
    public void beforeEach() {
        messagingTemplate = mock(SimpMessagingTemplate.class);
        controller = new GradianceWebSocketMessageController(messagingTemplate);
        // Use reflection to inject the mock since field is package-private
        try {
            java.lang.reflect.Field field = GradianceWebSocketMessageController.class.getDeclaredField("messagingTemplate");
            field.setAccessible(true);
            field.set(controller, messagingTemplate);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testHandleCurrentInterviewMessage_sendsToCorrectTopic() {
        StompMessageDTO message = new StompMessageDTO("sender1", "Interview Test Message");
        controller.handleCurrentInterviewMessage(message);

        verify(messagingTemplate, times(1))
                .convertAndSend("/topic/CurrentInterview", message);
    }

    @Test
    public void testHandleQueueBroadcastMessage_sendsToCorrectTopic() {
        StompMessageDTO message = new StompMessageDTO("sender2", "Queue Test Message");
        controller.handleQueueBroadcastMessage(message);

        verify(messagingTemplate, times(1))
                .convertAndSend("/topic/QueueBroadcast", message);
    }

    // @AfterEach
    // public void afterEach() {
    //     reset(messagingTemplate);
    // }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("Completed GradianceWebSocketMessageController tests.");
    }
}
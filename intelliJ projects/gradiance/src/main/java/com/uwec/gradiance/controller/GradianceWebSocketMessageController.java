package com.uwec.gradiance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.uwec.gradiance.dto.StompMessageDTO;

@Controller
public class GradianceWebSocketMessageController {
    
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    
    /**
     * 
     * TODO: Determine best way to receive messages from client and server + route accordingly
     * - DTO has sender member field, so we can easily determine if source is client or server
     * - maybe include destination field in DTO as well? this would allow for easier routing logic in handleMessage, 
     *   but would also make each payload larger. maybe we could derive a destination based on the source. 
     * - 
     * 
     */
    
    /**
     * Constructor for dependency injection
     * @param messagingTemplate
     */
    public GradianceWebSocketMessageController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    /**
     * Handles incoming WebSocket messages, and routes them to the appropriate topic
     * @param message
     */
    @MessageMapping("/CurrentInterview.sendMessage")
    public void handleCurrentInterviewMessage(StompMessageDTO message) {
        // send stomp message to all clients subscribed to /topic/CurrentInterview
        // should only be student/universal listener and instructor.
        // both clients will be subscribers to messages in this channel, make sure sender ignores its own messages
        messagingTemplate.convertAndSend("/topic/CurrentInterview", message);
    }

    @MessageMapping("/QueueBroadcast.sendMessage")
    public void handleQueueBroadcastMessage(StompMessageDTO message) {
        // broadcast messages from instructor to all Queue message subscribers
        messagingTemplate.convertAndSend("/topic/QueueBroadcast", message);

    }

}

package com.uwec.gradiance.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer  {
    
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        //endpoint that clients will connect to in order to utilize WebSockets
        registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        //routes prefixed with /topic will be sent from server to clients via the message broker
        registry.enableSimpleBroker("/topic");

        //routes prefixed with /Gradiance-app will be routed from clients to server
        registry.setApplicationDestinationPrefixes("/Gradiance-app");

    }

}

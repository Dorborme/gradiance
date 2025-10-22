package com.uwec.gradiance.config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.StompWebSocketEndpointRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import static org.mockito.Mockito.*;


class WebSocketConfigTest {

    private WebSocketConfig config;

    @BeforeAll
    public static void setUpBeforeAll() {
        System.out.println("Starting WebSocketConfig tests...");
    }

    @BeforeEach
    void setUp() {
        config = new WebSocketConfig();
    }


    @Test
    void testRegisterStompEndpoints() {
        StompEndpointRegistry registry = mock(StompEndpointRegistry.class);
        StompWebSocketEndpointRegistration registration = mock(StompWebSocketEndpointRegistration.class);

        when(registry.addEndpoint("/ws")).thenReturn(registration);
        when(registration.setAllowedOrigins("*")).thenReturn(registration);
        when(registration.withSockJS()).thenReturn(null);

        config.registerStompEndpoints(registry);

        verify(registry).addEndpoint("/ws");
        verify(registration).setAllowedOrigins("*");
        verify(registration).withSockJS();
    }

    @Test
    void testConfigureMessageBroker() {
        WebSocketConfig config = new WebSocketConfig();
        MessageBrokerRegistry registry = mock(MessageBrokerRegistry.class);

        config.configureMessageBroker(registry);

        verify(registry).enableSimpleBroker("/topic");
        verify(registry).setApplicationDestinationPrefixes("/Gradiance-app");
    }

    @AfterEach
    void tearDown() {
        config = null;
    }

    @AfterAll
    public static void tearDownAfterAll() {
        System.out.println("Completed WebSocketConfig tests.");
    }
}
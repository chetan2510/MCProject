package com.networking.mc;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry)
    {

        registry.addEndpoint("/testchat").setAllowedOrigins("http://localhost:4200").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/start");
        registry.setApplicationDestinationPrefixes("/current");
        //registry.enableSimpleBroker("/topic"); //topic
       // registry.setApplicationDestinationPrefixes("/app");
    }
}
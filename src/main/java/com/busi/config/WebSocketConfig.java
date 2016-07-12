package com.busi.config;

import com.busi.controller.LogWebSocketHandle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import org.springframework.web.socket.server.standard.ServerEndpointRegistration;

/**
 * Created by wl on 16/7/12.
 */
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointRegistration endpointRegistration() {
        return new ServerEndpointRegistration("/log", LogWebSocketHandle.class);
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}

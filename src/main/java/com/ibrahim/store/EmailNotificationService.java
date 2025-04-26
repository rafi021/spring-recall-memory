package com.ibrahim.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("email")
@Primary
public class EmailNotificationService implements NotificationService{

    @Value("${mail.host}")
    private String host;

    @Value("${mail.port}")
    private String port;

    @Override
    public void send(String message, String email) {
        System.out.println("Sending Email: " + message + " to " + email);
        System.out.println("Host: " + host);
        System.out.println("Port: " + port);
    }
}

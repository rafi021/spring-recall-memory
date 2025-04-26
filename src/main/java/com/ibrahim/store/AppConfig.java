package com.ibrahim.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Value("${payment-gateway:stripe}")
    private String paymentGateway;

    @Bean
    @Lazy
    public PaymentService stripe() {
        return new StripePaymentService();
    }

    @Bean
    @Lazy
    public PaymentService paypal() {
        return new PaypalPaymentService();
    }

    @Bean
    @Lazy
    @Scope("prototype")
    public OrderService orderService() {
        if (paymentGateway.equals("stripe")) {
            return  new OrderService(stripe());
        }
        return new OrderService(paypal());
    }
}

package com.ibrahim.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stripe")
@Primary
public class StripePaymentService implements PaymentService {

    @Value("${stripe.apiUrl}")
    private String apiUrl;

    @Value("${stripe.enabled}")
    private Boolean enabled;

    @Value("${stripe.timeout: 3000}")  // with Default value
    private int timeout;

    @Value("${stripe.supported-currencies}")
    private List<String> supportedCurrencies;

    @Override
    public void processPayment(double amount){
        System.out.println("Stripe");
        System.out.println("API Url: " + apiUrl);
        System.out.println("Enabled: " + enabled);
        System.out.println("Amount: " + amount + " paid");
    }
}

package com.example.notification1;

public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String message
) {
}
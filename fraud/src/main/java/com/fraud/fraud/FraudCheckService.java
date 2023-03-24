package com.fraud.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudlentCustomer(Integer customerId) {

        FraudCheckHistory fraudCheckHistory = FraudCheckHistory.builder()
                .isFraudster(true)
                .customerId(customerId)
                .createdAt(LocalDateTime.now())
                .build();

        fraudCheckHistoryRepository.save(fraudCheckHistory);
        return false;
    }
}

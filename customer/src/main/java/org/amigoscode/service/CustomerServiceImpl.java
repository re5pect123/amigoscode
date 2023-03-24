package org.amigoscode.service;

import com.example.clients.FraudClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.amigoscode.domain.Customer;
import org.amigoscode.domain.CustomerRequest;
import org.amigoscode.domain.CustomerResponse;
import org.amigoscode.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final RestTemplate restTemplate;

    private final FraudClient fraudClient;

    @Override
    public String info(CustomerRequest customerRequest) {

        Customer customer = Customer.builder()
                .firstName(customerRequest.getName())
                .lastName(customerRequest.getSurname())
                .build();

        customerRepository.saveAndFlush(customer);

        log.info("TEST1");

        String fraudster = fraudClient.isFraudster(customer.getId());

        log.info("DOBIJEN ODGOVOR NAKON ZAHTEVA FRAUD-u {} ", fraudster);

        return "OK";
    }
}

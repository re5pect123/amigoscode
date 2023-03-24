package org.amigoscode.service;

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

    @Override
    public String info(CustomerRequest customerRequest) {

        Customer customer = Customer.builder()
                .firstName(customerRequest.getName())
                .lastName(customerRequest.getSurname())
                .build();

        customerRepository.saveAndFlush(customer);

log.info("TEST1");
        String forObject = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                String.class,
                customer.getId()
        );
log.info("TEST2");
        if (forObject.equals("OK")) {
            return "NIJE PREVARANT";
        }


        return "OK";
    }
}

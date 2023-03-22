package org.amigoscode.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.amigoscode.domain.Customer;
import org.amigoscode.domain.CustomerRequest;
import org.amigoscode.domain.CustomerResponse;
import org.amigoscode.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService  {

    private final CustomerRepository customerRepository;

    @Override
    public String info(CustomerRequest customerRequest) {

        Customer customer = Customer.builder()
                .firstName(customerRequest.getName())
                .lastName(customerRequest.getSurname())
                .build();


        customerRepository.save(customer);


        return "OK";
    }
}

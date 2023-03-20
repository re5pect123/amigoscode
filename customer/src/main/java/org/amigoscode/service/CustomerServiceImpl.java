package org.amigoscode.service;

import lombok.extern.slf4j.Slf4j;
import org.amigoscode.domain.CustomerRequest;
import org.amigoscode.domain.CustomerResponse;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService  {

    @Override
    public String info(CustomerRequest customerRequest) {

        return CustomerResponse.builder()
                .name(customerRequest.getName() + "ASD")
                .build().toString();
    }
}

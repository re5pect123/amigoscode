package org.amigoscode.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.amigoscode.domain.CustomerRequest;
import org.amigoscode.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl customerServiceImpl;

    @PostMapping("reqistration")
    public String registration(@RequestBody CustomerRequest customerRequest) {

        log.info("Stigao je zahtev customerRequest: {} ", customerRequest);

        String info = customerServiceImpl.info(customerRequest);

        log.info("Vracamo response nakon promene u servisnom sloju (biznis logika): {} ", info);
        return info;
    }
}

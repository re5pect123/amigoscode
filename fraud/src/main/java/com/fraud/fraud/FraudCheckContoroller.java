package com.fraud.fraud;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/fraud-check")
public class FraudCheckContoroller {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public String isFraudster(@PathVariable("customerId") Integer customerId){

        log.info("Stigao je zahtev od customer servisa na fraud sa customerId {}", customerId);

        boolean isFraudlentCustomer = fraudCheckService.isFraudlentCustomer(customerId);
            log.info("Da li je korisnik prevarant kao andja? {}", isFraudlentCustomer);
        return "OK";
    }

}

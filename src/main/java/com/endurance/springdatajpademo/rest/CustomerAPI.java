package com.endurance.springdatajpademo.rest;


import com.endurance.springdatajpademo.converter.CustomerDTO;
import com.endurance.springdatajpademo.service.CustomerService;
import com.endurance.springdatajpademo.util.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(Constants.BASE_URL)
public class CustomerAPI {


    private final CustomerService customerService;

    CustomerAPI(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(Constants.GET_LAST_NAME)
    ResponseEntity<CustomerDTO> get(@PathVariable String lastName) {
        return Optional.ofNullable(customerService.getCustomerByLastName(lastName))
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}

package com.endurance.springdatajpademo.service;

import com.endurance.springdatajpademo.converter.CustomerDTO;
import com.endurance.springdatajpademo.jpa.CustomerRepository;
import com.endurance.springdatajpademo.model.Customer;
import com.endurance.springdatajpademo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class CustomerService {
    // <1> field injection warning
    //@Autowired
    private final CustomerRepository customerRepository;

    CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    // <2> Hide implementation details.  Create a Converter Object and
    // hand out converter object not Customer.
    public CustomerDTO getCustomerByLastName(String lastName) {
        Assert.hasText(lastName, () -> "lastName " + Constants.MSG_INPUT_MISSING);
        Customer customer = customerRepository.findByLastName(lastName);
        if(customer == null) {
            return null;
        }
        CustomerDTO customerDTO = new CustomerDTO(customer);
        return customerDTO;
    }

}

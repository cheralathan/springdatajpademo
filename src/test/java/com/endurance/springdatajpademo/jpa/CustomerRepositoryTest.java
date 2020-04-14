package com.endurance.springdatajpademo.jpa;

import com.endurance.springdatajpademo.model.Address;
import com.endurance.springdatajpademo.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    private AddressRepository addressRepository;


    @Test
    public void findAll() {
        List<Customer> customerList =  customerRepository.findAll();
        assertNotNull(customerList);
        assertEquals(customerList.size(), 4);
    }

    @Test
    public void deleteAll() {
        customerRepository.deleteAll();
        List<Customer> customerList =  customerRepository.findAll();
        assertNotNull(customerList);
        assertEquals(customerList.size(), 0);
    }

    @Test
    public void AddressesAreDeletedWhenCustomerDeleted() {
        Optional<Customer> customer = customerRepository.findById(1);
        assertTrue(customer.isPresent());
        Integer customerId = customer.get().getId();
        // get address associated with this customer
        List<Address> addressList = customerRepository.findAddressesByCustomerId(customerId);
        assertNotNull(addressList);
        assertTrue(addressList.size() > 1);
        // Delete the customer and observe that addresses are deleted as well
        customerRepository.deleteById(customerId);
        List<Address> addressList2 = customerRepository.findAddressesByCustomerId(customerId);
        assertNotNull(addressList2);
        assertTrue(addressList2.size() == 0);
    }

    @Test
    public void LastNameLike() {
        Optional<List<Customer>> customerListOptional = customerRepository.findByLastNameContaining("C");
        assertTrue(customerListOptional.isPresent());
        assertNotNull(customerListOptional.get());
        List<Customer> customerList = customerListOptional.get();
        assertTrue(customerList.size() == 2);
    }
}
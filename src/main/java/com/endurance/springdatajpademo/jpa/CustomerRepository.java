package com.endurance.springdatajpademo.jpa;

import com.endurance.springdatajpademo.model.Address;
import com.endurance.springdatajpademo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //<1> Note:  Address table is not part of this interface!
    @Query("SELECT a FROM Address a " +
            "JOIN  Customer c " +
            "ON c.id = a.customerIdReference.id " +
            "WHERE c.id = :id")
    List<Address> findAddressesByCustomerId(Integer id);

    Customer findByLastName(String lastName);

    Optional<List<Customer>> findByLastNameContaining(String partialLasName);
}

package com.endurance.springdatajpademo.jpa;

import com.endurance.springdatajpademo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
//    @Query("select a from Address a where a.customer_id = ?1")
//    List<Address> findAddressesByCustomerId(Integer cusomterId);
}

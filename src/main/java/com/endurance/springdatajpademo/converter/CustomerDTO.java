package com.endurance.springdatajpademo.converter;

import com.endurance.springdatajpademo.model.Address;
import com.endurance.springdatajpademo.model.Customer;
import com.endurance.springdatajpademo.util.Constants;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;
// <1>
public class CustomerDTO {
    // private members
    private String first;
    private String last;
    private Set<AddressDTO> addressDTOSet = new HashSet<>();

    public CustomerDTO(Customer customer) {
        Assert.notNull(customer != null, () -> "cusomter invalid " + Constants.MSG_INPUT_MISSING);
        first = customer.getFirstName();
        last = customer.getLastName();
        for(Address a : customer.getAddresses()) {
            AddressDTO addressDTO = new AddressDTO(a);
            addressDTOSet.add(addressDTO);
        }
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
    // <1> without this name, it will appear as AddressDTO
    @JsonProperty("addresses")
    public Set<AddressDTO> getAddressDTOSet() {
        return addressDTOSet;
    }

}

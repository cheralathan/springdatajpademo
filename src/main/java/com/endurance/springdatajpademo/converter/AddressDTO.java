package com.endurance.springdatajpademo.converter;

import com.endurance.springdatajpademo.model.Address;
import com.endurance.springdatajpademo.util.Constants;
import org.springframework.util.Assert;

public class AddressDTO {
    // private members
    private String city;
    private String state;

    public AddressDTO(Address address) {
        Assert.notNull(address != null, () -> "address invalid " + Constants.MSG_INPUT_MISSING);
        city = address.getCity();
        state = address.getState();
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}


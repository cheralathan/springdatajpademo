package com.endurance.springdatajpademo.model;

import com.endurance.springdatajpademo.util.Constants;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = Constants.ADDRESS_TABLE)
public class Address extends BaseEntity {
    //<1> No @Column needed if name matches the SQL
    private String street;
    private String city;
    private String state;
    private String country;

    // <2> - JoinColumn: To avoid a separate table creation for Join.
    @ManyToOne
    @JoinColumn(name = Constants.COLMN_CUSTOMER_ID, referencedColumnName = Constants.COLMN_ID)
    private Customer customerIdReference;

    protected Address() {}

    public Address(String street, String city, String state, String country) {
        Assert.hasText(street, () -> "street " + Constants.MSG_INPUT_MISSING);
        Assert.hasText(city,() -> "city " + Constants.MSG_INPUT_MISSING);
        Assert.hasText(state,() -> "state " + Constants.MSG_INPUT_MISSING);
        Assert.hasText(country, () -> "country " + Constants.MSG_INPUT_MISSING);
        this.street = street;
        this.state = state;
        this.city = city;
        this.country = country;
    }

    public Address getCopy() {
        return new Address(this.street, this.city,this.state, this.country);
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

}

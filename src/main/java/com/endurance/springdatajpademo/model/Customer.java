package com.endurance.springdatajpademo.model;

import com.endurance.springdatajpademo.util.Constants;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = Constants.CUSTOMER_TABLE)
public class Customer extends BaseEntity {
    @Column(name = Constants.COLMN_FIRST_NAME, nullable = false)
    private String firstName;
    @Column(name = Constants.COLMN_LAST_NAME, nullable = false)
    private String lastName;
    // <1> - Email validation class
    @Column(name = Constants.COLMN_EMAIL, unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = Constants.ADDRESS_BY_CUST_ID, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Address> addressesById = new HashSet<>();


    protected Customer() {}     // <2> - protected for JPA usage.  We'll use public constructor


    public Customer(String firstName, String lastName, String email) {
        //<3> : this message can be verbose for the log
        Assert.hasText(firstName, () -> "first name " + Constants.MSG_INPUT_MISSING);
        Assert.hasText(lastName,() -> "last name " + Constants.MSG_INPUT_MISSING);
        Assert.hasText(email, () -> "email " + Constants.MSG_INPUT_MISSING);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void add(Address address) {
        Assert.notNull(address, () -> "address null " + Constants.MSG_INPUT_MISSING);
        this.addressesById.add(address);
    }

    public Set<Address> getAddresses() {
        return Collections.unmodifiableSet(addressesById);
    }
}

package com.example.E_Commerce.model;


import javax.persistence.*;

@Embeddable
public class Address {

    @Id
    public Long addressId;

    @Embedded
    private State state;

    @Embedded
    private City city;

    @Embedded
    private Country country;


    public Address() {

    }

    public Address(Long id, State state, City city, Country country) {
        this.addressId = id;
        this.state = state;
        this.city = city;
        this.country = country;
    }

    public Long getId() {
        return addressId;
    }

    public void setId(Long id) {
        this.addressId = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }



}

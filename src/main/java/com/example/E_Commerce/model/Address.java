package com.example.E_Commerce.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class Address {

    @Embedded
    private State state;

    @Embedded
    private City city;

    @Embedded
    private Country country;

    public Address() {   }

    public Address(State state, City city, Country country) {
        this.state = state;
        this.city = city;
        this.country = country;
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

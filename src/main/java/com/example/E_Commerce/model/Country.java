package com.example.E_Commerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class Country {

    @Id
    private long id;
    private String countryName;

    public Country() {}

    public Country(Long id, String name) {
        this.id = id;
        this.countryName = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return countryName;
    }

    public void setName(String name) {
        this.countryName = name;
    }
}

package com.example.E_Commerce.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class City {

    @Id
    private long id;
    private String cityName;


    public City() {}

    public City(Long id, String name) {
        this.id = id;
        this.cityName = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return cityName;
    }

    public void setName(String name) {
        this.cityName = name;
    }
}

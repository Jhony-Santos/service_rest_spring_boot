package com.example.E_Commerce.model;


import javax.persistence.*;

@Entity
@Table(name="city")
@Embeddable
public class City {

    @Id
    private Long id;
    private String cityName;


    public City() {
    }

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

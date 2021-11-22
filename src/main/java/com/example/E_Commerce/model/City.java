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


    public City(Long id, String nome) {
        this.id = id;
        this.cityName = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return cityName;
    }

    public void setNome(String nome) {
        this.cityName = nome;
    }
}

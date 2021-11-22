package com.example.E_Commerce.model;

import javax.persistence.*;

@Entity
@Table(name="country")
@Embeddable
public class Country {

    @Id
    private Long id;
    private String countryName;

    public Country() { }

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

    public String getNome() {
        return countryName;
    }

    public void setNome(String nome) {
        this.countryName = nome;
    }
}

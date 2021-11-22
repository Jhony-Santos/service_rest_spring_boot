package com.example.E_Commerce.model;


import javax.persistence.*;

@Entity
@Table(name="state")
@Embeddable
public class State {

    @Id
    private Long id;

    private String stateName;

    public State() {

    }

    public State(Long id, String name) {
        this.id = id;
        this.stateName = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return stateName;
    }

    public void setName(String name) {
        this.stateName = name;
    }
}

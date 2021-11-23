package com.example.E_Commerce.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "seller")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Seller {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String cnpj;
    private String name;
    private String telephone;
    private String email;

    @Embedded
    private Address address;

    public Long getId() {
        return id;
    }
    public Seller(){}

    public Seller(String cnpj, String name, String telephone, String email, Address address) {
        this.cnpj = cnpj;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller that = (Seller) o;
        return cnpj.equals(that.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj);
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "id=" + id +
                ", cnpj='" + cnpj + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}

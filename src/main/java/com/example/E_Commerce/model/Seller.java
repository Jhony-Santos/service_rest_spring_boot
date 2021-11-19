package com.example.E_Commerce.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "fornecedor")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Seller {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String cnpj;
    private String nome;
    private String telefone;
    private String email;

    @Embedded
    private Adress adress;

    public Long getId() {
        return id;
    }
    public Seller(){}

    public Seller(String cnpj, String nome, String telefone, String email, Adress adress) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.adress = adress;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adress getEndereco() {
        return adress;
    }

    public void setEndereco(Adress adress) {
        this.adress = adress;
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
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", endereco=" + adress +
                '}';
    }
}

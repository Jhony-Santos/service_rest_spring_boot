package com.example.E_Commerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cliente")
public class Client {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String cpf;
    private String nome;
    private String telefone;
    private String email;

    @Embedded
    private Adress adress;

    public Client(){}

    public Client(String cpf, String nome, String telefone, String email, Adress adress) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.adress = adress;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
    public void setId(){
        this.id=id;
    }
    public Long getId(){
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return cpf.equals(client.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}

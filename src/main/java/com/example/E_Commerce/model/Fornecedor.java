package com.example.E_Commerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="fornecedor")
public class Fornecedor {

    @Id
    private String cnpj;
    private String nome;
    private String telefone;
    private String email;

    @Embedded
    private Endereco endereco;

    public Fornecedor() {

    }

    public Fornecedor(String cnpj, String nome, String telefone, String email, Endereco endereco) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco=endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setString(String cnpj) {
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

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(cnpj, that.cnpj) && Objects.equals(nome, that.nome) && Objects.equals(telefone, that.telefone) && Objects.equals(email, that.email) && Objects.equals(endereco, that.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj, nome, telefone, email, endereco);
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "cnpj='" + cnpj + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                '}';
    }


}

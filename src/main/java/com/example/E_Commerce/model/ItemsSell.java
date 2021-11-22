package com.example.E_Commerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="items_venda")
public class ItemsSell {

    @Id
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="sale")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name="product")
    private Product product;


    private Integer quantidade;
    private Double valor;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduto() {
        return product;
    }

    public void setProduto(Product product) {
        this.product = product;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Sale getVenda() {
        return sale;
    }

    public void setVenda(Sale sale) {
        this.sale = sale;
    }
}

package com.example.E_Commerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="items_compra")
public class ItemsCompra {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="codigo_compra")
    private Buy buy;
    

    @ManyToOne
    @JoinColumn(name="codigo_produto")
    private Product product;

    private Integer quantidade;
    private Double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Buy getCompra() {
        return buy;
    }

    public void setCompra(Buy buy) {
        this.buy = buy;
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
}

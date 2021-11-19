package com.example.E_Commerce.dto;

public class ItemSaleDTO {

    Long id_product;
    Double price;
    Integer quantity;


    public Long getId_produto() {
        return id_product;
    }

    public void setId_product(Long id_produto) {
        this.id_product = id_produto;
    }

    public Double getPrice() {
        return price;
    }

    public void setValor(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

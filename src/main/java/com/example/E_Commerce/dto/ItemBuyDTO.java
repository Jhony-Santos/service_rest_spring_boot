package com.example.E_Commerce.dto;

public class ItemBuyDTO {

    Long id_product;
    Double price;
    Integer quantity;

    public Long getId_product() {
        return id_product;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantidade) {
        this.quantity = quantity;
    }
}

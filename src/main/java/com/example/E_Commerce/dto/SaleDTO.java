package com.example.E_Commerce.dto;

import java.util.List;

public class SaleDTO {

    Long id_cliente;
    List<ItemSaleDTO> items;


    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public List<ItemSaleDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemSaleDTO> items) {
        this.items = items;
    }
}

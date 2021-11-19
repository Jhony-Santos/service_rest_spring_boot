package com.example.E_Commerce.dto;

import java.util.List;

public class SaleDTO {

    Long id_client;
    List<ItemSaleDTO> items;


    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_cliente) {
        this.id_client = id_client;
    }

    public List<ItemSaleDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemSaleDTO> items) {
        this.items = items;
    }
}

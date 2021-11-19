package com.example.E_Commerce.dto;

import java.util.List;

public class BuyDTO {

    Long id_fornecedor;
    List<ItemBuyDTO> items;

    public Long getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(Long id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public List<ItemBuyDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemBuyDTO> items) {
        this.items = items;
    }
}


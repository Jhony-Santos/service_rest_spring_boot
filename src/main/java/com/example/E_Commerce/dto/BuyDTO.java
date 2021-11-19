package com.example.E_Commerce.dto;

import java.util.List;

public class BuyDTO {

    Long id_seller;
    List<ItemBuyDTO> items;

    public Long getId_seller() {
        return id_seller;
    }

    public void setId_seller(Long id_fornecedor) {
        this.id_seller = id_seller;
    }

    public List<ItemBuyDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemBuyDTO> items) {
        this.items = items;
    }
}


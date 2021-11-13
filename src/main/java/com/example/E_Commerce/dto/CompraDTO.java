package com.example.E_Commerce.dto;

import java.util.List;

public class CompraDTO {

    Long id_fornecedor;
    List<ItemCompraDTO> items;

    public Long getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(Long id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public List<ItemCompraDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemCompraDTO> items) {
        this.items = items;
    }
}


package com.example.E_Commerce.dto;

import java.util.List;

public class VendaDTO {

    Long id_cliente;
    List<ItemVendaDTO> items;


    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public List<ItemVendaDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemVendaDTO> items) {
        this.items = items;
    }
}

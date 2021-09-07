package com.example.E_Commerce.dto;

import java.util.List;

public class VendaDTO {

    String id_cliente;
    List<ItemVendaDTO> items;


    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public List<ItemVendaDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemVendaDTO> items) {
        this.items = items;
    }
}

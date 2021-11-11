package com.example.E_Commerce.dto;

import com.example.E_Commerce.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class PostClienteDTO {

    List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}

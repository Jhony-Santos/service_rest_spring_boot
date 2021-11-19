package com.example.E_Commerce.dto;

import com.example.E_Commerce.model.Client;

import java.util.ArrayList;
import java.util.List;

public class PostClientDTO {

    List<Client> clients = new ArrayList<>();

    public List<Client> getClientes() {
        return clients;
    }

    public void setClientes(List<Client> clients) {
        this.clients = clients;
    }
}

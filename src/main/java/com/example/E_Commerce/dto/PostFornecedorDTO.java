package com.example.E_Commerce.dto;


import com.example.E_Commerce.model.Fornecedor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PostFornecedorDTO {

    List<Fornecedor> fornecedor = new ArrayList<>();

    public List<Fornecedor> getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(List<Fornecedor> fornecedor) {
        this.fornecedor = fornecedor;
    }
}

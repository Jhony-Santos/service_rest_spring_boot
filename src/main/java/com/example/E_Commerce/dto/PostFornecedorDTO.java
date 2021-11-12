package com.example.E_Commerce.dto;


import com.example.E_Commerce.model.Fornecedor;

import java.util.ArrayList;
import java.util.List;

public class PostFornecedorDTO {

    List<Fornecedor> fornecedor = new ArrayList<>();

    public List<Fornecedor> getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(List<Fornecedor> fornecedor) {
        this.fornecedor = fornecedor;
    }
}

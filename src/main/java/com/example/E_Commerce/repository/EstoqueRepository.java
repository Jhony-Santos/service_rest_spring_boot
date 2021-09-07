package com.example.E_Commerce.repository;

import com.example.E_Commerce.model.Estoque;
import com.example.E_Commerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    Estoque findByProduto(Produto produto);

}

package com.example.sistemaControle.repository;

import com.example.sistemaControle.model.Estoque;
import com.example.sistemaControle.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    Estoque findByProduto(Produto produto);

}

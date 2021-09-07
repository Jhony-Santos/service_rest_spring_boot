package com.example.sistemaControle.repository;

import com.example.sistemaControle.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProdutoRepository extends JpaRepository<Produto, Long> {



}
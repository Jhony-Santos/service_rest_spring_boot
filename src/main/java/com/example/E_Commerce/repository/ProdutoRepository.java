package com.example.E_Commerce.repository;

import com.example.E_Commerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProdutoRepository extends JpaRepository<Produto, Long> {



}
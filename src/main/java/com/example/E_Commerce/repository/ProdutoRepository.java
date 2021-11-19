package com.example.E_Commerce.repository;

import com.example.E_Commerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProdutoRepository extends JpaRepository<Product, Long> {



}
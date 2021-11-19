package com.example.E_Commerce.repository;

import com.example.E_Commerce.model.ItemsCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsBuyRepository extends JpaRepository<ItemsCompra,Long> {
}

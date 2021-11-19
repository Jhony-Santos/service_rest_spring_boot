package com.example.E_Commerce.repository;

import com.example.E_Commerce.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellRepository extends JpaRepository<Sale, Long> {
}

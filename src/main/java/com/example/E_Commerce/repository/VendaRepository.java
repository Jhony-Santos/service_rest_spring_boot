package com.example.E_Commerce.repository;

import com.example.E_Commerce.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Sale, Long> {
}

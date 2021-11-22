package com.example.E_Commerce.repository;

import com.example.E_Commerce.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    Optional<Sale> findSaleById(Long id);

}

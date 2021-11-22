package com.example.E_Commerce.repository;

import com.example.E_Commerce.model.Buy;
import com.example.E_Commerce.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuyRepository extends JpaRepository<Buy,Long> {

    Optional<Buy> findBuyById(Long id);


}

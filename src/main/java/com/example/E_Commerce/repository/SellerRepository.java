package com.example.E_Commerce.repository;

import com.example.E_Commerce.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Long> {

    Optional<Seller> findFornecedorById(Long id);
}

package com.example.E_Commerce.repository;

import com.example.E_Commerce.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor,Long> {

    @Override
    Optional<Fornecedor> findById(Long id);
}

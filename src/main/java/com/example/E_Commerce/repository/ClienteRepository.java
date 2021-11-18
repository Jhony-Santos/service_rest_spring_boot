package com.example.E_Commerce.repository;

import com.example.E_Commerce.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    Optional<Cliente> findClienteById(Long id);
}

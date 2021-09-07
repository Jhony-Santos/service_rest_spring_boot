package com.example.sistemaControle.repository;

import com.example.sistemaControle.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,String> {
}

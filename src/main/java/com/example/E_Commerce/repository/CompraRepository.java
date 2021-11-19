package com.example.E_Commerce.repository;

import com.example.E_Commerce.model.Buy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Buy,Long> {
}

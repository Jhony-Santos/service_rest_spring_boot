package com.example.E_Commerce.repository;

import com.example.E_Commerce.model.Attribute;
import com.example.E_Commerce.model.Buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute,Long> {
}

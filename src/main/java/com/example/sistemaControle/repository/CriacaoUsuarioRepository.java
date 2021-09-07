package com.example.sistemaControle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sistemaControle.model.Usuarios;

@Repository
public interface CriacaoUsuarioRepository extends JpaRepository<Usuarios, Long> {

	Boolean existsByEmail(String email);

	Usuarios findByEmail(String email);

}

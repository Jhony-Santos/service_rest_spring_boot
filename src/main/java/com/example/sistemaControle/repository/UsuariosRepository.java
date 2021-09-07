package com.example.sistemaControle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistemaControle.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

	Optional<Usuarios> findByEmail(String email);

}

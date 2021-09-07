package com.example.sistemaControle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistemaControle.model.Perfis;

public interface PerfisRepository extends JpaRepository<Perfis, Long> {

	Perfis findByNome(String nome);

}

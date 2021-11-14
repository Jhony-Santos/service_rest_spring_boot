package com.example.E_Commerce.service;


import com.example.E_Commerce.model.Fornecedor;
import com.example.E_Commerce.repository.FornecedorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    private final FornecedorRepository forne_Repository;

    public FornecedorService(FornecedorRepository forne_repository) {
        this.forne_Repository = forne_repository;
    }

    public List<Fornecedor> getFornecedores(){
        return forne_Repository.findAll();

    }

    public Fornecedor update(Long id, Fornecedor fornecedor){
        Optional<Fornecedor> verificarFornecedor=fornecedorRepository.findById(id);


        if(verificarFornecedor.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Fornecedor fornecedorSalvo=verificarFornecedor.get();
        BeanUtils.copyProperties(fornecedor, fornecedorSalvo, "id");

        return fornecedorRepository.save(fornecedorSalvo);
    }

    public ResponseEntity<Fornecedor> findFornecedorById(@PathVariable Long id){
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);

        return fornecedor.isPresent() ? ResponseEntity.ok(fornecedor.get()): ResponseEntity.notFound().build();

    }

    public void adicionandoFornecedor(Fornecedor fornecedor) {
        System.out.println("Os fornecedores são: "+ fornecedor);

    }
}

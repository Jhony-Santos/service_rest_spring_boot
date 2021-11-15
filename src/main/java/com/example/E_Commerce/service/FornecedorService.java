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


    public FornecedorService(FornecedorRepository forne_repository) {
        this.fornecedorRepository = forne_repository;
    }

    public List<Fornecedor> getFornecedores(){
        return fornecedorRepository.findAll();

    }

    public void deleteFornecedor(Long id_fornecedor){
        boolean exists= fornecedorRepository.existsById(id_fornecedor);
        if(!exists){
            throw new IllegalStateException("Fornecedor "+ id_fornecedor +"não existe");
        }

    }

    public Fornecedor update(Long id, Fornecedor fornecedor){
        //Optional<Fornecedor> verificarFornecedor=fornecedorRepository.findById(id);

        Optional<Fornecedor> verificarFornecedor=fornecedorRepository.findFornecedorById(id);


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

        Optional<Fornecedor> fornecedorById=fornecedorRepository.findFornecedorById(fornecedor.getId());

        if(fornecedorById.isPresent()){
            throw new IllegalStateException("Fornecedor já cadastrado");
        }
        fornecedorRepository.save(fornecedor);

        System.out.println("Os fornecedores são: "+ fornecedor);

    }
}

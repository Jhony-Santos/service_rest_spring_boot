package com.example.sistemaControle.service;


import com.example.sistemaControle.model.Cliente;
import com.example.sistemaControle.model.Fornecedor;
import com.example.sistemaControle.repository.FornecedorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;


    public Fornecedor update(String cnpj, Fornecedor fornecedor){
        Optional<Fornecedor> verificarFornecedor=fornecedorRepository.findById(cnpj);


        if(verificarFornecedor.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }


        Fornecedor fornecedorSalvo=verificarFornecedor.get();
        BeanUtils.copyProperties(fornecedor, fornecedorSalvo, "cpf");

        return fornecedorRepository.save(fornecedorSalvo);
    }


    public ResponseEntity<Fornecedor> findFornecedorById(@PathVariable String cnpj){
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(cnpj);

        return fornecedor.isPresent() ? ResponseEntity.ok(fornecedor.get()): ResponseEntity.notFound().build();

    }








}

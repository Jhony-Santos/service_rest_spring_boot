package com.example.E_Commerce.service;


import com.example.E_Commerce.model.Cliente;
import com.example.E_Commerce.model.Fornecedor;
import com.example.E_Commerce.repository.FornecedorRepository;
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

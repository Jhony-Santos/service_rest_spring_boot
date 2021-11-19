package com.example.E_Commerce.service;


import com.example.E_Commerce.model.Seller;
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


    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public List<Seller> getFornecedores(){
        return fornecedorRepository.findAll();

    }

   public Seller update(Long id, Seller seller){

        Optional<Seller> verificarFornecedor=fornecedorRepository.findFornecedorById(id);


        if(verificarFornecedor.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Seller sellerSalvo =verificarFornecedor.get();
        BeanUtils.copyProperties(seller, sellerSalvo, "id");

        return fornecedorRepository.save(sellerSalvo);
    }

    public ResponseEntity<Seller> findFornecedorById(@PathVariable Long id){
        Optional<Seller> fornecedor = fornecedorRepository.findById(id);

        return fornecedor.isPresent() ? ResponseEntity.ok(fornecedor.get()): ResponseEntity.notFound().build();

    }

    public Seller adicionandoFornecedor(Seller seller) {

        Optional<Seller> fornecedorById=fornecedorRepository.findFornecedorById(seller.getId());

        if(fornecedorById.isPresent()){
            throw new IllegalStateException("Fornecedor já cadastrado");
        }

        return fornecedorRepository.save(seller);

    }
}

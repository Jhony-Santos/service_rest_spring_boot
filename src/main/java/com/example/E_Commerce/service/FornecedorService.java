package com.example.E_Commerce.service;


import com.example.E_Commerce.model.Seller;
import com.example.E_Commerce.repository.SellerRepository;
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
    private SellerRepository sellerRepository;


    public FornecedorService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public List<Seller> getFornecedores(){
        return sellerRepository.findAll();

    }

   public Seller update(Long id, Seller seller){

        Optional<Seller> verificarFornecedor= sellerRepository.findFornecedorById(id);


        if(verificarFornecedor.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Seller sellerSalvo =verificarFornecedor.get();
        BeanUtils.copyProperties(seller, sellerSalvo, "id");

        return sellerRepository.save(sellerSalvo);
    }

    public ResponseEntity<Seller> findFornecedorById(@PathVariable Long id){
        Optional<Seller> fornecedor = sellerRepository.findById(id);

        return fornecedor.isPresent() ? ResponseEntity.ok(fornecedor.get()): ResponseEntity.notFound().build();

    }

    public Seller adicionandoFornecedor(Seller seller) {

        Optional<Seller> fornecedorById= sellerRepository.findFornecedorById(seller.getId());

        if(fornecedorById.isPresent()){
            throw new IllegalStateException("Fornecedor já cadastrado");
        }

        return sellerRepository.save(seller);

    }
}

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
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;


    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public List<Seller> getSeller(){
        return sellerRepository.findAll();

    }

   public Seller update(Long id, Seller seller){

        Optional<Seller> verifySeller= sellerRepository.findSellerById(id);


        if(verifySeller.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Seller sellerSalved = verifySeller.get();
        BeanUtils.copyProperties(seller, sellerSalved, "id");

        return sellerRepository.save(sellerSalved);
    }

    public ResponseEntity<Seller> findSellerById(@PathVariable Long id){
        Optional<Seller> seller = sellerRepository.findById(id);

        return seller.isPresent() ? ResponseEntity.ok(seller.get()): ResponseEntity.notFound().build();

    }

    public Seller addSeller(Seller seller) {

        Optional<Seller> sellerById= sellerRepository.findById(seller.getId());

        if(sellerById.isPresent()){
            throw new IllegalStateException("Fornecedor já cadastrado");
        }

        return sellerRepository.save(seller);

    }
}



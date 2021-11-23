package com.example.E_Commerce.service;


import com.example.E_Commerce.model.Buy;
import com.example.E_Commerce.repository.BuyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class BuyService {

    @Autowired
    private BuyRepository buyRepository;

    public Buy update(Long id, Buy buy){

        Optional<Buy> verifyBuy=buyRepository.findById(id);

        if(verifyBuy.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Buy buySalved=verifyBuy.get();
        BeanUtils.copyProperties(buy, buySalved, "id");

        return buyRepository.save(buySalved);
    }

    public ResponseEntity<Buy> findBuyById(@PathVariable Long id){
        Optional<Buy> buy =buyRepository.findById(id);


        return buy.isPresent() ? ResponseEntity.ok(buy.get()): ResponseEntity.notFound().build();

    }

}

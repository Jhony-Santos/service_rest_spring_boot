package com.example.E_Commerce.service;

import com.example.E_Commerce.model.Sale;
import com.example.E_Commerce.repository.SaleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public Sale update(Long id , Sale sale){
        Optional<Sale> verifySell= saleRepository.findById(id);

        if(verifySell.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Sale saleSalved =verifySell.get();
        BeanUtils.copyProperties(sale, saleSalved, "id");

        return saleRepository.save(saleSalved);
    }


    public ResponseEntity<Sale> findSaleById(@PathVariable Long id){
        Optional<Sale> sale = saleRepository.findById(id);

        return sale.isPresent() ? ResponseEntity.ok(sale.get()): ResponseEntity.notFound().build();

    }

}

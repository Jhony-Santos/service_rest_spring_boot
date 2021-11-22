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
        Optional<Sale> verificarVenda= saleRepository.findById(id);

        if(verificarVenda.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Sale saleSalva =verificarVenda.get();
        BeanUtils.copyProperties(sale, saleSalva, "id");

        return saleRepository.save(saleSalva);
    }


    public ResponseEntity<Sale> findSaleById(@PathVariable Long id){
        Optional<Sale> venda = saleRepository.findById(id);

        return venda.isPresent() ? ResponseEntity.ok(venda.get()): ResponseEntity.notFound().build();

    }

}

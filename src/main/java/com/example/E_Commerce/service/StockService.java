package com.example.E_Commerce.service;


import com.example.E_Commerce.model.Stock;
import com.example.E_Commerce.repository.StockRepository;
import com.example.E_Commerce.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;


    public Stock update(Long id, Stock stock){

        Optional<Stock> verificarEstoque= stockRepository.findById(id);

        if(verificarEstoque.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Stock stockSalvo =verificarEstoque.get();
        BeanUtils.copyProperties(stock, stockSalvo, "id");

        return stockRepository.save(stockSalvo);
    }

    public ResponseEntity<Stock> findEstoqueById(@PathVariable Long id){
        Optional<Stock> estoque = stockRepository.findById(id);

        return estoque.isPresent() ? ResponseEntity.ok(estoque.get()): ResponseEntity.notFound().build();

    }


    public Stock atualizarValor(Long id, Stock stock, double valor){
        Optional<Stock> verificarEstoque= stockRepository.findById(id);

        if(verificarEstoque.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Stock stockSalvo =verificarEstoque.get();
        stockSalvo.setValor(valor);
        BeanUtils.copyProperties(stock, stockSalvo, "id");

        return stockRepository.save(stockSalvo);
    }

}



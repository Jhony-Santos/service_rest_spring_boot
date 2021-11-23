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

        Optional<Stock> verifyStock= stockRepository.findById(id);

        if(verifyStock.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Stock stockSalvo = verifyStock.get();
        BeanUtils.copyProperties(stock, stockSalvo, "id");

        return stockRepository.save(stockSalvo);
    }

    public ResponseEntity<Stock> findStockById(@PathVariable Long id){
        Optional<Stock> stock = stockRepository.findById(id);

        return stock.isPresent() ? ResponseEntity.ok(stock.get()): ResponseEntity.notFound().build();

    }


    public Stock updatePrice(Long id, Stock stock, double price){
        Optional<Stock> findStockById= stockRepository.findById(id);

        if(findStockById.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Stock stockSalved = findStockById.get();
        stockSalved.setValor(price);
        BeanUtils.copyProperties(stock, stockSalved, "id");

        return stockRepository.save(stockSalved);
    }

}



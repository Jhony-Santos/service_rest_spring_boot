package com.example.E_Commerce.service;

import com.example.E_Commerce.model.Product;
import com.example.E_Commerce.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product update(Long id, Product product){
        Optional<Product> verifyProduct= productRepository.findById(id);

        if(verifyProduct.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Product productSalved =verifyProduct.get();
        BeanUtils.copyProperties(product, productSalved, "id");

        return productRepository.save(productSalved);
    }


    public ResponseEntity<Product> findProductById(@PathVariable Long id){
        Optional<Product> produto = productRepository.findById(id);

        return produto.isPresent() ? ResponseEntity.ok(produto.get()): ResponseEntity.notFound().build();

    }
}

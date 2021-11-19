package com.example.E_Commerce.service;

import com.example.E_Commerce.model.Product;
import com.example.E_Commerce.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public Product update(Long codigo, Product product){
        Optional<Product> verificarProduto=produtoRepository.findById(codigo);

        if(verificarProduto.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Product productSalvo =verificarProduto.get();
        BeanUtils.copyProperties(product, productSalvo, "codigo");

        return produtoRepository.save(productSalvo);
    }


    public ResponseEntity<Product> findProdutoById(@PathVariable Long codigo){
        Optional<Product> produto = produtoRepository.findById(codigo);

        return produto.isPresent() ? ResponseEntity.ok(produto.get()): ResponseEntity.notFound().build();

    }
}

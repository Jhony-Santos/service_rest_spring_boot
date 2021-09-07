package com.example.E_Commerce.service;

import com.example.E_Commerce.model.Cliente;
import com.example.E_Commerce.model.Produto;
import com.example.E_Commerce.repository.FornecedorRepository;
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


    public Produto update(Long codigo, Produto produto){
        Optional<Produto> verificarProduto=produtoRepository.findById(codigo);

        if(verificarProduto.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Produto produtoSalvo=verificarProduto.get();
        BeanUtils.copyProperties(produto, produtoSalvo, "codigo");

        return produtoRepository.save(produtoSalvo);
    }


    public ResponseEntity<Produto> findProdutoById(@PathVariable Long codigo){
        Optional<Produto> produto = produtoRepository.findById(codigo);

        return produto.isPresent() ? ResponseEntity.ok(produto.get()): ResponseEntity.notFound().build();

    }
}

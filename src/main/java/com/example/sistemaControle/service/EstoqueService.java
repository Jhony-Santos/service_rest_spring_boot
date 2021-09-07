package com.example.sistemaControle.service;


import com.example.sistemaControle.model.Estoque;
import com.example.sistemaControle.repository.EstoqueRepository;
import com.example.sistemaControle.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ProdutoRepository produtoRepository;


    public Estoque update(Long id, Estoque estoque){

        Optional<Estoque> verificarEstoque=estoqueRepository.findById(id);

        if(verificarEstoque.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Estoque estoqueSalvo=verificarEstoque.get();
        BeanUtils.copyProperties(estoque, estoqueSalvo, "id");

        return estoqueRepository.save(estoqueSalvo);
    }

    public ResponseEntity<Estoque> findEstoqueById(@PathVariable Long id){
        Optional<Estoque> estoque = estoqueRepository.findById(id);

        return estoque.isPresent() ? ResponseEntity.ok(estoque.get()): ResponseEntity.notFound().build();

    }


    public Estoque atualizarValor(Long id, Estoque estoque, double valor){
        Optional<Estoque> verificarEstoque=estoqueRepository.findById(id);

        if(verificarEstoque.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Estoque estoqueSalvo=verificarEstoque.get();
        estoqueSalvo.setValor(valor);
        BeanUtils.copyProperties(estoque, estoqueSalvo, "id");

        return estoqueRepository.save(estoqueSalvo);
    }

}

package com.example.E_Commerce.service;

import com.example.E_Commerce.model.Sale;
import com.example.E_Commerce.repository.VendaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Sale update(Long id , Sale sale){
        Optional<Sale> verificarVenda=vendaRepository.findById(id);

        if(verificarVenda.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Sale saleSalva =verificarVenda.get();
        BeanUtils.copyProperties(sale, saleSalva, "id");

        return vendaRepository.save(saleSalva);
    }


    public ResponseEntity<Sale> findVendaById(@PathVariable Long id){
        Optional<Sale> venda = vendaRepository.findById(id);

        return venda.isPresent() ? ResponseEntity.ok(venda.get()): ResponseEntity.notFound().build();

    }





}

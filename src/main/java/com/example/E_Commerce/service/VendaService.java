package com.example.E_Commerce.service;

import com.example.E_Commerce.model.Venda;
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

    public Venda update(Long id , Venda venda){
        Optional<Venda> verificarVenda=vendaRepository.findById(id);

        if(verificarVenda.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Venda vendaSalva=verificarVenda.get();
        BeanUtils.copyProperties(venda, vendaSalva, "id");

        return vendaRepository.save(vendaSalva);
    }


    public ResponseEntity<Venda> findVendaById(@PathVariable Long id){
        Optional<Venda> venda = vendaRepository.findById(id);

        return venda.isPresent() ? ResponseEntity.ok(venda.get()): ResponseEntity.notFound().build();

    }





}

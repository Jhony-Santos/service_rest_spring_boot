/*package com.example.sistemaControle.service;


import com.example.sistemaControle.model.Cliente;
import com.example.sistemaControle.model.Compra;
import com.example.sistemaControle.repository.CompraRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public Compra update(Long id, Compra compra){
        Optional<Compra> verificarCompra=compraRepository.findById(id);

        if(verificarCompra.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Compra compraSalva=verificarCompra.get();
        BeanUtils.copyProperties(compra, compraSalva, "id");

        return compraRepository.save(compraSalva);
    }

    public ResponseEntity<Compra> findCompraById(@PathVariable Long id){
        Optional<Compra> compra =compraRepository.findById(id);

        return compra.isPresent() ? ResponseEntity.ok(compra.get()): ResponseEntity.notFound().build();

    }





}
*/
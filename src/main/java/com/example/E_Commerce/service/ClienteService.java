package com.example.E_Commerce.service;

import com.example.E_Commerce.model.Cliente;
import com.example.E_Commerce.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente update(Long id, Cliente cliente){
        Optional<Cliente> verificarCliente=clienteRepository.findById(id);

        if(verificarCliente.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Cliente clienteSalvo=verificarCliente.get();
        BeanUtils.copyProperties(cliente, clienteSalvo, "id");

        return clienteRepository.save(clienteSalvo);
    }

    public ResponseEntity<Cliente> findClienteById(@PathVariable Long id){
        Optional<Cliente> cliente =clienteRepository.findById(id);

        return cliente.isPresent() ? ResponseEntity.ok(cliente.get()): ResponseEntity.notFound().build();

    }

}

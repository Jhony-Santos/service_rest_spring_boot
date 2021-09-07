package com.example.sistemaControle.service;

import com.example.sistemaControle.model.Cliente;
import com.example.sistemaControle.repository.ClienteRepository;
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

    public Cliente update( String cpf,Cliente cliente){
        Optional<Cliente> verificarCliente=clienteRepository.findById(cpf);

        if(verificarCliente.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Cliente clienteSalvo=verificarCliente.get();
        BeanUtils.copyProperties(cliente, clienteSalvo, "cpf");

        return clienteRepository.save(clienteSalvo);
    }

    public ResponseEntity<Cliente> findClienteById(@PathVariable String cpf){
        Optional<Cliente> cliente =clienteRepository.findById(cpf);

        return cliente.isPresent() ? ResponseEntity.ok(cliente.get()): ResponseEntity.notFound().build();

    }

}

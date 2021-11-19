package com.example.E_Commerce.service;

import com.example.E_Commerce.model.Client;
import com.example.E_Commerce.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }

    public List<Client> getClientes(){
        return clienteRepository.findAll();
    }


    public Client update(Long id, Client client){
        Optional<Client> verificarCliente=clienteRepository.findById(id);

        if(verificarCliente.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Client clientSalvo =verificarCliente.get();
        BeanUtils.copyProperties(client, clientSalvo, "id");

        return clienteRepository.save(clientSalvo);
    }

    public ResponseEntity<Client> findClienteById(@PathVariable Long id){
        Optional<Client> cliente =clienteRepository.findById(id);

        return cliente.isPresent() ? ResponseEntity.ok(cliente.get()): ResponseEntity.notFound().build();

    }


    public Client adicionandoCliente(Client client) {

        Optional<Client> clienteById=clienteRepository.findClienteById((client.getId()));

        if(clienteById.isPresent()){
            throw new IllegalStateException("Cliente já cadastrado");
        }

        return clienteRepository.save(client);

    }





}

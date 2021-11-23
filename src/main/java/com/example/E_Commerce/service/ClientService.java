package com.example.E_Commerce.service;

import com.example.E_Commerce.model.Client;
import com.example.E_Commerce.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public List<Client> getClient(){
        return clientRepository.findAll();
    }


    public Client update(Long id, Client client){
        Optional<Client> verifyClient= clientRepository.findById(id);

        if(verifyClient.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Client clientSalved = verifyClient.get();
        BeanUtils.copyProperties(client, clientSalved, "id");

        return clientRepository.save(clientSalved);
    }

    public ResponseEntity<Client> findClientById(@PathVariable Long id){
        Optional<Client> client = clientRepository.findById(id);

        return client.isPresent() ? ResponseEntity.ok(client.get()): ResponseEntity.notFound().build();

    }


    public Client adicionandoCliente(Client client) {

        Optional<Client> clientById= clientRepository.findClientById((client.getId()));

        if(clientById.isPresent()){
            throw new IllegalStateException("Cliente já cadastrado");
        }

        return clientRepository.save(client);

    }





}

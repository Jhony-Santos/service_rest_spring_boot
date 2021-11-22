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

    public List<Client> getClientes(){
        return clientRepository.findAll();
    }


    public Client update(Long id, Client client){
        Optional<Client> verificarCliente= clientRepository.findById(id);

        if(verificarCliente.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        Client clientSalvo =verificarCliente.get();
        BeanUtils.copyProperties(client, clientSalvo, "id");

        return clientRepository.save(clientSalvo);
    }

    public ResponseEntity<Client> findClienteById(@PathVariable Long id){
        Optional<Client> cliente = clientRepository.findById(id);

        return cliente.isPresent() ? ResponseEntity.ok(cliente.get()): ResponseEntity.notFound().build();

    }


    public Client adicionandoCliente(Client client) {

        Optional<Client> clienteById= clientRepository.findClienteById((client.getId()));

        if(clienteById.isPresent()){
            throw new IllegalStateException("Cliente já cadastrado");
        }

        return clientRepository.save(client);

    }





}

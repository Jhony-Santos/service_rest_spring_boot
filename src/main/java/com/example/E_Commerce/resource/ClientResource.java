package com.example.E_Commerce.resource;


import com.example.E_Commerce.model.Client;
import com.example.E_Commerce.repository.ClientRepository;
import com.example.E_Commerce.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/*import org.springframework.security.access.prepost.PreAuthorize;*/
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@PreAuthorize("hasRole('ROLE_LOJA')")
@RequestMapping("/client")
public class ClientResource {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getClient() {
        return clientService.getClient();
    }


    @PostMapping("/create")
    public void registerClient(@RequestBody Client client){
        clientService.adicionandoCliente(client);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Client> findClientById(@PathVariable Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.isPresent() ? ResponseEntity.ok(client.get()) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        Client clientSave = clientService.update(id, client);
        return ResponseEntity.ok(clientSave);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        clientRepository.deleteById(id);

    }


}


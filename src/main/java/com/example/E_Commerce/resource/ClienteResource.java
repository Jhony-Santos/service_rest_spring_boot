package com.example.E_Commerce.resource;


import com.example.E_Commerce.model.Client;
import com.example.E_Commerce.repository.ClienteRepository;
import com.example.E_Commerce.service.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteResource {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Client> getClientes() {
        return clienteService.getClientes();
    }


    @PostMapping("/create")
    public void registrandoCliente(@RequestBody Client client){
        clienteService.adicionandoCliente(client);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Client> findClienteById(@PathVariable Long id) {
        Optional<Client> cliente = clienteRepository.findById(id);
        return cliente.isPresent() ? ResponseEntity.ok(cliente.get()) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        Client clientSave = clienteService.update(id, client);
        return ResponseEntity.ok(clientSave);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        clienteRepository.deleteById(id);

    }


}


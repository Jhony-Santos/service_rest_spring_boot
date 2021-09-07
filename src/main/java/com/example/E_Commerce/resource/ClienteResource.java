package com.example.E_Commerce.resource;


import com.example.E_Commerce.EventoCliente;
import com.example.E_Commerce.model.Cliente;
import com.example.E_Commerce.repository.ClienteRepository;
import com.example.E_Commerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
    public List<Cliente> list(){
        return clienteRepository.findAll();
    }

    @PostMapping("/create") // CREATE
    public ResponseEntity create(@RequestBody Cliente cliente, HttpServletResponse response) {

        Cliente clienteSalvo=clienteRepository.save(cliente);
        publisher.publishEvent(new EventoCliente(this,response, clienteSalvo.getCpf()));
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping("/{cpf}") // READ
    public ResponseEntity<Cliente> findClienteById(@PathVariable String cpf){
        Optional<Cliente> cliente=clienteRepository.findById(cpf);
        return cliente.isPresent() ? ResponseEntity.ok(cliente.get()): ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{cpf}")    // UPDATE
    public ResponseEntity<Cliente> update(@PathVariable String cpf, @RequestBody Cliente cliente){
        Cliente clienteSave=clienteService.update(cpf,cliente);
        return ResponseEntity.ok(clienteSave);
    }

    @DeleteMapping("/delete/{cpf}") // DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable String cpf){
        clienteRepository.deleteById(cpf);
    }



}

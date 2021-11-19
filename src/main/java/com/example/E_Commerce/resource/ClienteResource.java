package com.example.E_Commerce.resource;


import com.example.E_Commerce.EventoCliente;
import com.example.E_Commerce.EventoGenerico;
import com.example.E_Commerce.dto.PostClienteDTO;
import com.example.E_Commerce.model.Cliente;
import com.example.E_Commerce.model.Fornecedor;
import com.example.E_Commerce.repository.ClienteRepository;
import com.example.E_Commerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/*import org.springframework.security.access.prepost.PreAuthorize;*/
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
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }


    @PostMapping("/create")
    public void registrandoCliente(@RequestBody Cliente cliente){
        clienteService.adicionandoCliente(cliente);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findClienteById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.isPresent() ? ResponseEntity.ok(cliente.get()) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteSave = clienteService.update(id, cliente);
        return ResponseEntity.ok(clienteSave);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        clienteRepository.deleteById(id);

    }


}


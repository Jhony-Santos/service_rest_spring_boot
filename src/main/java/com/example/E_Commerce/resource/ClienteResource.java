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
    public List<Cliente> list() {
        return clienteRepository.findAll();
    }



    @PostMapping("/create")
    public ResponseEntity <List<Cliente>> create(@RequestBody PostClienteDTO clientes, HttpServletResponse response) {

        List<Cliente> listaCliente=clienteRepository.saveAll(clientes.getClientes());

        return ResponseEntity.status(HttpStatus.CREATED).body(listaCliente);
    }


    @GetMapping("/{id}") // READ
    public ResponseEntity<Cliente> findClienteById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.isPresent() ? ResponseEntity.ok(cliente.get()) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")    // UPDATE
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteSave = clienteService.update(id, cliente);
        return ResponseEntity.ok(clienteSave);
    }

    @DeleteMapping("/delete/{id}") // DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        clienteRepository.deleteById(id);

    }


}


  /*for(Cliente cliente:clientes.getClientes()){
            Cliente clienteSalvo=clienteRepository.save(cliente); }
       publisher.publishEvent(new EventoGenerico(this,response, listaSalva.getId()));*/
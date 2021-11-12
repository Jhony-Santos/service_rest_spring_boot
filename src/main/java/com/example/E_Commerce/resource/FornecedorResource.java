package com.example.E_Commerce.resource;


import com.example.E_Commerce.EventoGenerico;
import com.example.E_Commerce.dto.PostFornecedorDTO;
import com.example.E_Commerce.model.Fornecedor;
import com.example.E_Commerce.repository.FornecedorRepository;
import com.example.E_Commerce.service.FornecedorService;
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
@RequestMapping("/fornecedores")
public class FornecedorResource {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Fornecedor> list(){
        return fornecedorRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity <List<Fornecedor>> create(@RequestBody PostFornecedorDTO fornecedor, HttpServletResponse response) {

        List<Fornecedor> listaFornecedor=fornecedorRepository.saveAll(fornecedor.getFornecedor());

        return ResponseEntity.status(HttpStatus.CREATED).body(listaFornecedor);

    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<Fornecedor> findClienteById(@PathVariable String cnpj){
        Optional<Fornecedor> fornecedor=fornecedorRepository.findById(cnpj);
        return fornecedor.isPresent() ? ResponseEntity.ok(fornecedor.get()): ResponseEntity.notFound().build();
    }



    @PutMapping("update/{cnpj}")
    public ResponseEntity<Fornecedor> update(@PathVariable String cnpj, @RequestBody Fornecedor fornecedor){
        Fornecedor fornecedorSave=fornecedorService.update(cnpj,fornecedor);
        return ResponseEntity.ok(fornecedorSave);
    }

    @DeleteMapping("/{cnpj}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable String cnpj){
        fornecedorRepository.deleteById(cnpj);
    }



}

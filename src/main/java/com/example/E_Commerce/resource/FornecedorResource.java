package com.example.E_Commerce.resource;


import com.example.E_Commerce.model.Fornecedor;
import com.example.E_Commerce.repository.FornecedorRepository;
import com.example.E_Commerce.service.FornecedorService;
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
@RequestMapping("/fornecedores")
public class FornecedorResource {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    public FornecedorResource(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @GetMapping()
    public List<Fornecedor> getFornecedores(){
        return fornecedorService.getFornecedores();
    }

    @PostMapping("/create")
    public void registrandoFornecedor(@RequestBody Fornecedor fornecedor){
         fornecedorService.adicionandoFornecedor(fornecedor);
    }


    /*@PostMapping("/create")
    public Fornecedor regi_Fornecedor(@RequestBody Fornecedor fornecedor){
         return fornecedorRepository.save(fornecedor);
    }*/


    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findClienteById(@PathVariable Long id){
        Optional<Fornecedor> fornecedor=fornecedorRepository.findById(id);
        return fornecedor.isPresent() ? ResponseEntity.ok(fornecedor.get()): ResponseEntity.notFound().build();
    }


    @PutMapping("update/{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable Long id, @RequestBody Fornecedor fornecedor){
        Fornecedor fornecedorSave=fornecedorService.update(id,fornecedor);
        return ResponseEntity.ok(fornecedorSave);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id){
        fornecedorRepository.deleteById(id);

    }



}

    /*@PostMapping("/create")
    public ResponseEntity <List<Fornecedor>> create(@RequestBody PostFornecedorDTO fornecedor, HttpServletResponse response) {

        List<Fornecedor> listaFornecedor=fornecedorRepository.saveAll(fornecedor.getFornecedor());

        return ResponseEntity.status(HttpStatus.CREATED).body(listaFornecedor);
    }*/
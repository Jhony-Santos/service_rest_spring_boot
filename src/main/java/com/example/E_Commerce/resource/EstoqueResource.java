package com.example.E_Commerce.resource;

import com.example.E_Commerce.model.Estoque;
import com.example.E_Commerce.repository.EstoqueRepository;
import com.example.E_Commerce.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
//@PreAuthorize("hasRole('ROLE_LOJA')")
@RequestMapping("/estoque")
public class EstoqueResource {

    @Autowired
    private EstoqueService estoqueService;

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    // O ESTOQUE É CRIADO NO MOMENTO DE COMPRA
    // O PRODUTO É CADASTRADO DE ANTEMÃO

    @GetMapping // READ all
    public ResponseEntity<List<Estoque>> findAllEstoque(){
        List <Estoque> estoque=estoqueRepository.findAll();
        if(estoque.isEmpty()){
            String erro="Não existe nenhum dado em estoque";
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,erro);
        }

        return ResponseEntity.ok().body(estoque);

    }

    @GetMapping("/{id}") // READ
    public ResponseEntity<Estoque> findEstoqueById(@PathVariable Long id){
        Optional<Estoque> estoque=estoqueRepository.findById(id);

        //System.out.println(estoque);

        return estoque.isPresent() ? ResponseEntity.ok(estoque.get()): ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")    // UPDATE
    public ResponseEntity<Estoque> update(@PathVariable Long id, @RequestBody Estoque estoque){
        Estoque estoqueSave=estoqueService.update(id,estoque);
        return ResponseEntity.ok(estoqueSave);
    }

    @PutMapping("/update/{valor}")
    public ResponseEntity<Estoque> atualizarValor(@PathVariable Long id, @PathVariable double valor, @RequestBody Estoque estoque){
        Estoque estoqueSave=estoqueService.atualizarValor(id,estoque,valor);
        return ResponseEntity.ok(estoqueSave);
    }


}

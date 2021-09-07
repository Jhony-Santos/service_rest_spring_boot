package com.example.sistemaControle.resource;


import com.example.sistemaControle.EventoGenerico;
import com.example.sistemaControle.dto.CompraDTO;
import com.example.sistemaControle.dto.ItemCompraDTO;
import com.example.sistemaControle.model.*;
import com.example.sistemaControle.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@PreAuthorize("hasRole('ROLE_LOJA')")
@RequestMapping("/compra")
public class CompraResource {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ItemsCompraRepository itemsCompraRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;


    @Autowired
    private ApplicationEventPublisher publisher;


    @GetMapping
    public ResponseEntity<List<Compra>> findAllCompra(){
        List <Compra> compra = compraRepository.findAll();
        if(compra.isEmpty()){
            String erro="Nenhuma compra foi realizada ainda";
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,erro);
        }

        return ResponseEntity.ok().body(compra);

    }


    @PostMapping("/create")
    public ResponseEntity create(@RequestBody CompraDTO compra, HttpServletResponse response) {

        Compra compraSalva = new Compra();

        Fornecedor fornecedor=fornecedorRepository.findById(compra.getId_fornecedor()).get();
        compraSalva.setFornecedor(fornecedor);
        compraSalva=compraRepository.save(compraSalva);

       for (ItemCompraDTO i : compra.getItems()){

           ItemsCompra itemsCompra = new ItemsCompra();

           Produto produto = produtoRepository.findById(i.getId_produto()).get(); // vejo se o produto existe
           itemsCompra.setProduto(produto);
           itemsCompra.setQuantidade(i.getQuantidade());
           itemsCompra.setValor(i.getValor());
           itemsCompra.setCompra(compraSalva);
           compraSalva.addItem(itemsCompra);


           Estoque estoque = estoqueRepository.findByProduto(produto);

           if(estoque==null || produto==null  ){

               throw new ResponseStatusException(HttpStatus.NOT_FOUND,"SEM ESTOQUE/ SEM QUANTIDADE DO PRODUTO/ PRODUTO COM VALOR 0");
           }
           else{

               estoque.setProduto(estoque.getProduto());
               estoque.setQuantidade(estoque.getQuantidade() + i.getQuantidade());
               estoque.setValor(i.getValor());
               estoqueRepository.save(estoque);
           }
       }

        compraSalva=compraRepository.save(compraSalva);

        publisher.publishEvent(new EventoGenerico(this,response, compraSalva.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(compraSalva);
    }




}

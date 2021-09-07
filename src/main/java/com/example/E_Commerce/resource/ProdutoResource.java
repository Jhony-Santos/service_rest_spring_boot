package com.example.sistemaControle.resource;

import com.example.sistemaControle.EventoCliente;
import com.example.sistemaControle.EventoGenerico;
import com.example.sistemaControle.dto.CompraDTO;
import com.example.sistemaControle.model.Cliente;
import com.example.sistemaControle.model.Estoque;
import com.example.sistemaControle.model.Produto;
import com.example.sistemaControle.repository.EstoqueRepository;
import com.example.sistemaControle.repository.ProdutoRepository;
import com.example.sistemaControle.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@PreAuthorize("hasRole('ROLE_LOJA')")
@RequestMapping("/produto")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private EstoqueRepository estoqueRepository;


    @GetMapping
    public List<Produto> listSimples(){
        return produtoRepository.findAll();
    }

    @GetMapping("/listarProdutos")
    public List<Produto> list(){

        List<Produto> listaProdutos=new ArrayList<>();

        for(Estoque i: estoqueRepository.findAll()){

            if(i.getQuantidade() > 0 && i.getValor() > 0 ){ // caminho feliz
                    listaProdutos.add(i.getProduto());

            }
        }
        return listaProdutos;
    }


    @PostMapping("/create")// CREATE
    public ResponseEntity create(@RequestBody Produto produto, HttpServletResponse response) {

        Produto produtoSalvo=produtoRepository.save(produto);

        Estoque estoque = new Estoque();
        estoque.setValor(0.00);
        estoque.setQuantidade(0);
        estoque.setProduto(produtoSalvo);
        estoqueRepository.save(estoque);

        publisher.publishEvent(new EventoGenerico(this,response, produtoSalvo.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Produto> findProdutoById(@PathVariable Long codigo){
        Optional<Produto> produto=produtoRepository.findById(codigo);
        return produto.isPresent() ? ResponseEntity.ok(produto.get()): ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{codigo}")
    public ResponseEntity<Produto> update(@PathVariable Long codigo, @RequestBody Produto produto){
        Produto produtoSave=produtoService.update(codigo,produto);
        return ResponseEntity.ok(produtoSave);
    }


    @DeleteMapping("/delete/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long codigo ){
        produtoRepository.deleteById(codigo);
    }



}

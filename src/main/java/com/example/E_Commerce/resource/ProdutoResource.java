package com.example.E_Commerce.resource;

import com.example.E_Commerce.EventoGenerico;
import com.example.E_Commerce.model.Product;
import com.example.E_Commerce.model.Stock;
import com.example.E_Commerce.repository.StockRepository;
import com.example.E_Commerce.repository.ProductRepository;
import com.example.E_Commerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/*import org.springframework.security.access.prepost.PreAuthorize;*/
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
//@PreAuthorize("hasRole('ROLE_LOJA')")
@RequestMapping("/produto")
public class ProdutoResource {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private StockRepository stockRepository;


    @GetMapping
    public List<Product> listSimples(){
        return productRepository.findAll();
    }

    @GetMapping("/listarProdutos")
    public List<Product> list(){

        List<Product> listaProducts =new ArrayList<>();

        for(Stock i: stockRepository.findAll()){

            if(i.getQuantity() > 0 && i.getValor() > 0 ){ // caminho feliz
                    listaProducts.add(i.getProduct());

            }
        }
        return listaProducts;
    }


    @PostMapping("/create")// CREATE
    public ResponseEntity create(@RequestBody Product product, HttpServletResponse response) {

        Product productSalvo = productRepository.save(product);

        Stock stock = new Stock();
        stock.setValor(0.00);
        stock.setQuantity(0);
        stock.setProduct(productSalvo);
        stockRepository.save(stock);

        publisher.publishEvent(new EventoGenerico(this,response, productSalvo.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(productSalvo);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Product> findProdutoById(@PathVariable Long codigo){
        Optional<Product> produto= productRepository.findById(codigo);
        return produto.isPresent() ? ResponseEntity.ok(produto.get()): ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{codigo}")
    public ResponseEntity<Product> update(@PathVariable Long codigo, @RequestBody Product product){
        Product productSave =produtoService.update(codigo, product);
        return ResponseEntity.ok(productSave);
    }


    @DeleteMapping("/delete/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long codigo ){
        productRepository.deleteById(codigo);
    }



}

package com.example.E_Commerce.resource;

import com.example.E_Commerce.EventoGenerico;
import com.example.E_Commerce.model.Attribute;
import com.example.E_Commerce.model.Product;
import com.example.E_Commerce.model.Stock;
import com.example.E_Commerce.repository.StockRepository;
import com.example.E_Commerce.repository.ProductRepository;
import com.example.E_Commerce.service.AttributeService;
import com.example.E_Commerce.service.ProductService;
import com.example.E_Commerce.service.SellerService;
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
import java.util.Set;

@RestController
//@PreAuthorize("hasRole('ROLE_LOJA')")
@RequestMapping("/product")
public class ProductResource {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private StockRepository stockRepository;




    @GetMapping
    public List<Product> listSimples(){
        return productRepository.findAll();
    }

    @GetMapping("/listProducts")
    public List<Product> list(){

        List<Product> listProducts = new ArrayList<>();

        for(Stock i: stockRepository.findAll()){

            if(i.getQuantity() > 0 && i.getValor() > 0 ){ // caminho feliz
                listProducts.add(i.getProduct());

            }
        }
        return listProducts;
    }





    @PostMapping("/create")// CREATE
    public ResponseEntity create(@RequestBody Product product, HttpServletResponse response) {



        Product productSalved = productRepository.save(product);

        Stock stock = new Stock();
        stock.setValor(0.00);
        stock.setQuantity(0);
        stock.setProduct(productSalved);
        stockRepository.save(stock);

        publisher.publishEvent(new EventoGenerico(this,response, productSalved.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(productSalved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id){
        Optional<Product> product= productRepository.findById(id);
        return product.isPresent() ? ResponseEntity.ok(product.get()): ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product){
        Product productSave = productService.update(id, product);
        return ResponseEntity.ok(productSave);
    }


    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id ){
        productRepository.deleteById(id);
    }



}

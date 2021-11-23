package com.example.E_Commerce.resource;

import com.example.E_Commerce.model.Stock;
import com.example.E_Commerce.repository.StockRepository;
import com.example.E_Commerce.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/*import org.springframework.security.access.prepost.PreAuthorize;*/
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
//@PreAuthorize("hasRole('ROLE_LOJA')")
@RequestMapping("/stock")
public class StockResource {

    @Autowired
    private StockService stockService;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    // O ESTOQUE É CRIADO NO MOMENTO DE COMPRA
    // O PRODUTO É CADASTRADO DE ANTEMÃO

    @GetMapping // READ all
    public ResponseEntity<List<Stock>> findAllEstoque(){
        List <Stock> stock = stockRepository.findAll();
        if(stock.isEmpty()){
            String erro="Não existe nenhum dado em estoque";
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,erro);
        }

        return ResponseEntity.ok().body(stock);

    }

    @GetMapping("/{id}") // READ
    public ResponseEntity<Stock> findStockById(@PathVariable Long id){
        Optional<Stock> stock= stockRepository.findById(id);

        System.out.println(stock);

        return stock.isPresent() ? ResponseEntity.ok(stock.get()): ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")    // UPDATE
    public ResponseEntity<Stock> update(@PathVariable Long id, @RequestBody Stock stock){
        Stock stockSave = stockService.update(id, stock);
        return ResponseEntity.ok(stockSave);
    }

    @PutMapping("/update/{valor}")
    public ResponseEntity<Stock> updatePrice(@PathVariable Long id, @PathVariable double price, @RequestBody Stock stock){
        Stock stockSave = stockService.updatePrice(id, stock,price);
        return ResponseEntity.ok(stockSave);
    }


}

/* package com.example.E_Commerce.resource;


import com.example.E_Commerce.EventoGenerico;
import com.example.E_Commerce.dto.BuyDTO;
import com.example.E_Commerce.dto.ItemBuyDTO;
import com.example.E_Commerce.model.*;
import com.example.E_Commerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/*import org.springframework.security.access.prepost.PreAuthorize;*/
/*
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
//@PreAuthorize("hasRole('ROLE_LOJA')")
@RequestMapping("/compra")
public class BuyResource {

    @Autowired
    private BuyRepository buyRepository;

    @Autowired
    private ItemsBuyRepository itemsBuyRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SellerRepository sellerRepository;


    @Autowired
    private ApplicationEventPublisher publisher;


    @GetMapping
    public ResponseEntity<List<Buy>> findAllCompra(){
        List <Buy> buy = buyRepository.findAll();
        if(buy.isEmpty()){
            String erro="Nenhuma compra foi realizada ainda";
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,erro);
        }

        return ResponseEntity.ok().body(buy);

    }


    @PostMapping("/create")
    public ResponseEntity create(@RequestBody BuyDTO buy, HttpServletResponse response) {

        Buy buySalve = new Buy();

        Seller seller=sellerRepository.findById(buy.getId_seller()).get();
        buySalve.setSeller(seller);
        buySalve=buyRepository.save(buySalve);

        for (ItemBuyDTO i : buy.getItems()){

            ItemsBuy itemsBuy = new ItemsBuy();

            Product product = productRepository.findById(i.getId_product()).get(); // vejo se o produto existe
            itemsBuy.setProduct(product);
            itemsBuy.setQuantity(i.getQuantity());
            itemsBuy.setPrice(i.getPrice());
            itemsBuy.setBuy(buySalve);
            buySalve.addItem(itemsBuy);



            Stock stock = stockRepository.findByProduto(product);

            if(stock==null || product ==null  ){

                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"SEM ESTOQUE/ SEM QUANTIDADE DO PRODUTO/ PRODUTO COM VALOR 0");
            }
            else{

                stock.setProduct(stock.getProduct());
                stock.setQuantity(stock.getQuantity() + i.getQuantity());
                stock.setValor(i.getPrice());
                stockRepository.save(stock);
            }
        }

        buySalve = buyRepository.save(buySalve);

        publisher.publishEvent(new EventoGenerico(this,response, buySalve.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(buySalve);
    }


}


 */
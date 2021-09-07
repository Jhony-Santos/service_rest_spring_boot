package com.example.sistemaControle.resource;

import com.example.sistemaControle.model.ItemsCompra;
import com.example.sistemaControle.repository.ItemsCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsCompraResource {

    @Autowired
    private ItemsCompraRepository itemsCompraRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<ItemsCompra> list(){
        return itemsCompraRepository.findAll();
    }




}

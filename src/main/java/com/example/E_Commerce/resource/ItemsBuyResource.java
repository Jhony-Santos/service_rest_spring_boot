package com.example.E_Commerce.resource;

import com.example.E_Commerce.model.ItemsBuy;
import com.example.E_Commerce.repository.ItemsBuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsBuyResource {

    @Autowired
    private ItemsBuyRepository itemsBuyRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<ItemsBuy> list(){
        return itemsBuyRepository.findAll();
    }




}

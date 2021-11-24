package com.example.E_Commerce.resource;

import com.example.E_Commerce.model.Attribute;
import com.example.E_Commerce.model.Client;
import com.example.E_Commerce.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/attribute")


public class AttributeResource {


    @Autowired
    private AttributeService attributeService;


    @PostMapping("/create")
    public void registerClient(@RequestBody Attribute attribute){
        attributeService.saveSingle(attribute);

    }



}

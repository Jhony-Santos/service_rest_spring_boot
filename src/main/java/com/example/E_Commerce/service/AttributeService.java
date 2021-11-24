package com.example.E_Commerce.service;

import com.example.E_Commerce.model.Attribute;
import com.example.E_Commerce.repository.AttributeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AttributeService {


    private final AttributeRepository repository;

    public AttributeService(AttributeRepository repository) {
        this.repository = repository;
    }

    public void deleteAll(Set<Attribute> attributes){
        for (Attribute attribute : attributes) {
            repository.deleteById(attribute.getId());
        }
    }

    public Attribute saveSingle(Attribute attribute){
    return  repository.save(attribute);
    }

    public Set<Attribute> save(Set<Attribute> attributes) {
        Set<Attribute> att = new HashSet();
        for (Attribute attribute : attributes) {
            att.add(repository.save(attribute));
        }
        return  att;
    }






}

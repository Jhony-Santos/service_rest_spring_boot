package com.example.E_Commerce.dto;


import com.example.E_Commerce.model.Seller;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PostSellerDTO {

    List<Seller> seller = new ArrayList<>();

    public List<Seller> getSeller() {
        return seller;
    }

    public void setSeller(List<Seller> seller) {
        this.seller = seller;
    }
}


package com.example.E_Commerce.repository;

import com.example.E_Commerce.model.Product;
import com.example.E_Commerce.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Stock findProductById(Product product);

}



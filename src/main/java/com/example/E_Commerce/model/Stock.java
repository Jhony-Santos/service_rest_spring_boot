package com.example.E_Commerce.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="estoque")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(fetch= FetchType.EAGER) // pega produto automaticamente, mapeamento do banco
    @JoinColumn(name="id") // id de produto, cada produto tem um estoque
    private Product product;

    private Integer quantity;
    private Double price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getValor() {
        return price;
    }

    public void setValor(Double valor) {
        this.price = valor;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "id=" + id +
                ", produto=" + product +
                ", quantidade=" + quantity +
                ", valor=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return id.equals(stock.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

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
    @JoinColumn(name="codigo_produto") // id de produto, cada produto tem um estoque
    private Product product;

    private Integer quantidade;
    private Double valor;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduto() {
        return product;
    }

    public void setProduto(Product product) {
        this.product = product;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "id=" + id +
                ", produto=" + product +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
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

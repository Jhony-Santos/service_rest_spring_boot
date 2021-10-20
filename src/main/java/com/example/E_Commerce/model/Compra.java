package com.example.E_Commerce.model;

import com.example.E_Commerce.dto.CompraDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="compra")
public class Compra {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "fornecedor")
    private Fornecedor fornecedor;


    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "compra", fetch = FetchType.EAGER)
    private List<ItemsCompra> itemsCompra = new ArrayList<>();



    public Compra() {
    }

    public Compra(Long id, Fornecedor fornecedor, List<ItemsCompra> itemsCompra) {
        this.id = id;
        this.fornecedor = fornecedor;
        this.itemsCompra=itemsCompra;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<ItemsCompra> getItemsCompra() {
        return itemsCompra;
    }

    public void setItemsCompra(List<ItemsCompra> itemsCompra) {
        this.itemsCompra = itemsCompra;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", fornecedor=" + fornecedor +
                 +
                '}';
    }

    public void addItem(ItemsCompra itemsCompra){
        this.itemsCompra.add(itemsCompra);
    }

    public void removeItem(ItemsCompra itemsCompra){
        this.itemsCompra.remove(itemsCompra);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return id.equals(compra.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

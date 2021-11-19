package com.example.E_Commerce.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="compra")
public class Buy {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "seller")
    private Seller seller;


    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "buy", fetch = FetchType.EAGER)
    private List<ItemsCompra> itemsCompra = new ArrayList<>();


    public Buy() {
    }

    public Buy(Long id, Seller seller, List<ItemsCompra> itemsCompra) {
        this.id = id;
        this.seller = seller;
        this.itemsCompra=itemsCompra;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
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
                ", fornecedor=" + seller +
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
        Buy buy = (Buy) o;
        return id.equals(buy.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

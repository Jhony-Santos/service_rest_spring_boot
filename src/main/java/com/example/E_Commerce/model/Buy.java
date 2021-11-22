package com.example.E_Commerce.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="buy")
public class Buy {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "seller")
    private Seller seller;


    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "buy", fetch = FetchType.EAGER)
    private List<ItemsBuy> itemsBuy = new ArrayList<>();


    public Buy() {
    }

    public Buy(Long id, Seller seller, List<ItemsBuy> itemsBuy) {
        this.id = id;
        this.seller = seller;
        this.itemsBuy = itemsBuy;
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

    public List<ItemsBuy> getItemsCompra() {
        return itemsBuy;
    }

    public void setItemsCompra(List<ItemsBuy> itemsBuy) {
        this.itemsBuy = itemsBuy;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "id=" + id +
                ", Seller=" + seller +
                 +
                '}';
    }

    public void addItem(ItemsBuy itemsBuy){
        this.itemsBuy.add(itemsBuy);
    }

    public void removeItem(ItemsBuy itemsBuy){
        this.itemsBuy.remove(itemsBuy);
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

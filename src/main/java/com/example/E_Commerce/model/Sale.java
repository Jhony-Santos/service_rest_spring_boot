package com.example.E_Commerce.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;

    private boolean status;


    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "sale", fetch = FetchType.EAGER)
    private List<ItemsSell> itemsSells =new ArrayList<>();

    public Sale(){

    }

    public Sale(Long id, Client client, List<ItemsSell> itemsSells, boolean status) {
        this.id = id;
        this.client = client;
        this.itemsSells = itemsSells;
        this.status=status;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setCliente(Client client) {
        this.client = client;
    }

    public List<ItemsSell> getItemsSells() {
        return itemsSells;
    }

    public void setItemsSells(List<ItemsSell> itemsSells) {
        this.itemsSells = itemsSells;
    }

    public void addItem(ItemsSell itemsSell){
        this.itemsSells.add(itemsSell);
    }

    public void removeItem(ItemsSell itemsSell){
        this.itemsSells.add(itemsSell);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "id=" + id +
                ", Client=" + client +
                ", itemsSells=" + itemsSells +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return id.equals(sale.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


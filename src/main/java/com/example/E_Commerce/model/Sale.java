package com.example.E_Commerce.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="venda")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "cliente")
    private Client client;

    private boolean status;


    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "venda", fetch = FetchType.EAGER)
    private List<ItemsVenda> itemsVendas=new ArrayList<>();

    public Sale(){

    }

    public Sale(Long id, Client client, List<ItemsVenda> itemsVendas, boolean status) {
        this.id = id;
        this.client = client;
        this.itemsVendas = itemsVendas;
        this.status=status;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getCliente() {
        return client;
    }

    public void setCliente(Client client) {
        this.client = client;
    }

    public List<ItemsVenda> getItemsVendas() {
        return itemsVendas;
    }

    public void setItemsVendas(List<ItemsVenda> itemsVendas) {
        this.itemsVendas = itemsVendas;
    }

    public void addItem(ItemsVenda itemsVenda){
        this.itemsVendas.add(itemsVenda);
    }

    public void removeItem(ItemsVenda itemsVenda){
        this.itemsVendas.add(itemsVenda);
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
                ", itemsVendas=" + itemsVendas +
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

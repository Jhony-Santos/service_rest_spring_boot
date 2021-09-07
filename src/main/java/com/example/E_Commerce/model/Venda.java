package com.example.E_Commerce.model;

import com.example.E_Commerce.dto.VendaDTO;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    private boolean status;


    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "venda", fetch = FetchType.EAGER)
    private List<ItemsVenda> itemsVendas=new ArrayList<>();

    public Venda(){

    }

    public Venda(Long id, Cliente cliente, List<ItemsVenda> itemsVendas,boolean status) {
        this.id = id;
        this.cliente = cliente;
        this.itemsVendas = itemsVendas;
        this.status=status;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        return "Venda{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", itemsVendas=" + itemsVendas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return id.equals(venda.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

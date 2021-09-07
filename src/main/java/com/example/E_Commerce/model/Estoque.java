package com.example.sistemaControle.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(fetch= FetchType.EAGER) // pega produto automaticamente, mapeamento do banco
    @JoinColumn(name="codigo_produto") // id de produto, cada produto tem um estoque
    private Produto produto;

    private Integer quantidade;
    private Double valor;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estoque estoque = (Estoque) o;
        return id.equals(estoque.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

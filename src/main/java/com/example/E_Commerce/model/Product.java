package com.example.E_Commerce.model;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="produto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String site_id;

    private String title;

    private String subtitile;

    private Long id_integracao;

    private Long seller_id;

    private double price;

    private double base_price;

    private double original_price;

    private String currency_id;

    private int initial_quantity;

    private int avaliable_quantity;

    private String start_time;

    private String stop_time;

    private String condition;

    private String permalink;

    @Embedded
    private Brand brand;


    @Embedded
    private Adress adress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitile() {
        return subtitile;
    }

    public void setSubtitile(String subtitile) {
        this.subtitile = subtitile;
    }

    public Long getId_integracao() {
        return id_integracao;
    }

    public void setId_integracao(Long id_integracao) {
        this.id_integracao = id_integracao;
    }

    public Long getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Long seller_id) {
        this.seller_id = seller_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getBase_price() {
        return base_price;
    }

    public void setBase_price(double base_price) {
        this.base_price = base_price;
    }

    public double getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(double original_price) {
        this.original_price = original_price;
    }

    public String getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(String currency_id) {
        this.currency_id = currency_id;
    }

    public int getInitial_quantity() {
        return initial_quantity;
    }

    public void setInitial_quantity(int initial_quantity) {
        this.initial_quantity = initial_quantity;
    }

    public int getAvaliable_quantity() {
        return avaliable_quantity;
    }

    public void setAvaliable_quantity(int avaliable_quantity) {
        this.avaliable_quantity = avaliable_quantity;
    }

    public String getStart_time() {
        DateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date start_time=new Date();
        return dateFormat.format(start_time);
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getStop_time() {
        return stop_time;
    }

    public void setStop_time(String stop_time) {
        this.stop_time = stop_time;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public Adress getEndereco() {
        return adress;
    }

    public void setEndereco(Adress adress) {
        this.adress = adress;
    }
}





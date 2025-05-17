package com.products.webapi.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="product")
//@Data - not working
//@Setter - not working
//@Getter  - not working
public final class Product extends Item{

    @Column(name = "description")
    private String Description;
    @Column(name = "unit_price")
    private Integer UnitPrice;
    @Column(name = "active")
    private Integer Active;
    @Column(name = "qty")
    private Integer Qty;

    public Product() {
    }

    public Product(String name, String description, Integer unitPrice, Integer active, Integer qty) {
        super.setName(name);
        Description = description;
        UnitPrice = unitPrice;
        Active = active;
        Qty = qty;
    }

    public Integer getId() {
        return super.getId();
    }

    public String getName() {
        return super.getName();
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Integer getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        UnitPrice = unitPrice;
    }

    public Integer getActive() {
        return Active;
    }

    public void setActive(Integer active) {
        Active = active;
    }

    public Integer getQty() {
        return Qty;
    }

    public void setQty(Integer qty) {
        Qty = qty;
    }


}

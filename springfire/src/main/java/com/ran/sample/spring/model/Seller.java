package com.ran.sample.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "SELLER")
public class Seller {

    private long id;
    private String name;
    private Set<SaleItem> items;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "sellers")
    @JsonIgnore
    public Set<SaleItem> getItems() {
        return items;
    }

    public void setItems(Set<SaleItem> items) {
        this.items = items;
    }

}

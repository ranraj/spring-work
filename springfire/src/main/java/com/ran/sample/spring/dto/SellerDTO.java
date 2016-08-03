package com.ran.sample.spring.dto;

import com.ran.sample.spring.model.SaleItem;

import org.hibernate.validator.constraints.NotBlank;

import java.util.Set;

public class SellerDTO {

    private long id;

    @NotBlank(message = "Seller name must not be blank!")
    private String name;
    private Set<SaleItem> items;

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

    public Set<SaleItem> getItems() {
        return items;
    }

    public void setItems(Set<SaleItem> items) {
        this.items = items;
    }
}

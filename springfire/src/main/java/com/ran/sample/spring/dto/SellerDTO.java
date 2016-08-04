package com.ran.sample.spring.dto;

import com.ran.sample.spring.model.SaleItem;

import org.hibernate.validator.constraints.NotBlank;

import java.util.Set;

public class SellerDTO extends AbstractDTO {

    @NotBlank(message = "Seller name must not be blank!")
    private String name;

    private Set<SaleItem> items;

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

    @Override
    public String toString() {
        return "SellerDTO [getName()=" + getName() + ", getItems()=" + getItems() + ", getId()=" + getId() + "]";
    }

}

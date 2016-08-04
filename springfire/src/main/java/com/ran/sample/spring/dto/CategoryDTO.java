package com.ran.sample.spring.dto;

import com.ran.sample.spring.model.SaleItem;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

public class CategoryDTO extends AbstractDTO {

    @NotBlank(message = "Category name must not be blank!")
    private String name;
    private String description;
    private List<SaleItem> items;

    protected CategoryDTO() {
    }

    public CategoryDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public void setItems(List<SaleItem> items) {
        this.items = items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CategoryDTO [id=" + getId() + ", name=" + getName() + ", description=" + getDescription() + "]";
    }

}

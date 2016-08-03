package com.ran.sample.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "SALE_ITEM")
public class SaleItem {
    private long id;
    private String name;
    private double mrp;
    private Category category;
    private Set<Seller> sellers;

    protected SaleItem() {
    }

    public SaleItem(String name, double mrp, Category category) {
        this.name = name;
        this.mrp = mrp;
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMrp() {
        return mrp;
    }

    @ManyToOne
    @JoinColumn(name = "item_category_id")
    public Category getCategory() {
        return category;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "item_seller_mapping", joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "seller_id", referencedColumnName = "id"))
    public Set<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(Set<Seller> sellers) {
        this.sellers = sellers;
    }

    @Override
    public String toString() {
        return "SaleItem [id=" + id + ", name=" + name + ", mrp=" + mrp + ", category=" + category + "]";
    }
}

package com.ran.sample.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SALE_ITEM")
public class SaleItem {
	private long id;
	private String name;
	private double mrp;
	private Category category;
	
	protected SaleItem(){}
	public SaleItem(String name,double mrp,Category category){
		this.name=name;
		this.mrp=mrp; 
		this.category=category;		
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
	@JoinColumn(name ="item_category_id")
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
	@Override
	public String toString() {
		return "SaleItem [id=" + id + ", name=" + name + ", mrp=" + mrp + ", category=" + category + "]";
	}		
}

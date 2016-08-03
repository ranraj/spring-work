package com.ran.sample.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SALE_ORDER")
public class SaleOrder {
    private long orderId;
    private String item;
    private double amount;
    private SaleOrderDetails saleOrderDetails;

    protected SaleOrder() {
    }

    public SaleOrder(String item, double amount) {
        this.item = item;
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getOrderId() {
        return orderId;
    }

    public String getItem() {
        return item;
    }

    public double getAmount() {
        return amount;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_detail_id")
    public SaleOrderDetails getSaleOrderDetails() {
        return saleOrderDetails;
    }

    public void setSaleOrderDetails(SaleOrderDetails saleOrderDetails) {
        this.saleOrderDetails = saleOrderDetails;
    }

    @Override
    public String toString() {
        return "SaleOrder [orderId=" + orderId + ", item=" + item + ", amount=" + amount + ", saleOrderDetails="
                + saleOrderDetails + "]";
    }

}

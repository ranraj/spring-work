package com.ran.sample.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SALE_ORDER_DETAILS")
public class SaleOrderDetails {
    private long id;
    private String deleryAddress;
    private String paymentMode;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeleryAddress() {
        return deleryAddress;
    }

    public void setDeleryAddress(String deleryAddress) {
        this.deleryAddress = deleryAddress;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    @Override
    public String toString() {
        return "SaleOrderDetails [id=" + id + ", deleryAddress=" + deleryAddress + ", paymentMode=" + paymentMode + "]";
    }
}

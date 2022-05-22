package com.bcv.application.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the orderdetails database table.
 */
@Entity
@Table(name = "orderdetails")
public class Orderdetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private short orderLineNumber;

    private BigDecimal priceEach;

    private int quantityOrdered;

    //bi-directional many-to-one association to Order
    @ManyToOne
    @JoinColumn(name = "orderNumber")
    private Order order;

    //bi-directional many-to-one association to Product
    @ManyToOne
    @JoinColumn(name = "productCode")
    private Product product;

    public Orderdetail() {
    }

    public short getOrderLineNumber() {
        return this.orderLineNumber;
    }

    public void setOrderLineNumber(short orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    public BigDecimal getPriceEach() {
        return this.priceEach;
    }

    public void setPriceEach(BigDecimal priceEach) {
        this.priceEach = priceEach;
    }

    public int getQuantityOrdered() {
        return this.quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
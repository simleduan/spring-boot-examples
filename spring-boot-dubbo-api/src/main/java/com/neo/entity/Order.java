package com.neo.entity;

import java.io.Serializable;

/**
 * create by xiaocai on 2020/9/18 9:38
 **/
public class Order implements Serializable {
    private int id;
    private String custName;
    private String productName;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", custName='" + custName + '\'' +
                ", productName=" + productName +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Order(int id, String custName, String productName) {
        this.id = id;
        this.custName = custName;
        this.productName = productName;
    }
}

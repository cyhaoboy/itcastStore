package com.example.itcaststore.domain;

public class WeekHotProduct {
    Product product;
    int num;

    @Override
    public String toString() {
        return "WeekHotProduct{" +
                "product=" + product +
                ", num=" + num +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

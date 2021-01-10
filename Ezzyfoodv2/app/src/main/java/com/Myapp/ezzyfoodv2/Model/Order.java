package com.Myapp.ezzyfoodv2.Model;

public class Order {
    private Item Items;
    private int Qty = 0;

    public Order(Item Items){
        this.Items = Items;
    }

    public Item getItem() {
        return Items;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        this.Qty = qty;
    }
}

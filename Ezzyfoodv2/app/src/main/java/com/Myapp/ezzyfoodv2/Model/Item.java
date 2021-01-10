package com.Myapp.ezzyfoodv2.Model;

public class Item {
    protected String Name = "";
    protected int Price = 0;

    public Item(String Name, int Price){
        this.Name = Name;
        this.Price = Price;
    }

    public String getPrice() {
        return ("Rp " + Price);
    }

    public int getPriceValue() {
        return Price;
    }

    public String getName() {
        return Name;
    }
}

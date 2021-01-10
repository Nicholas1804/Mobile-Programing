package com.Myapp.ezzyfoodv2.Repository;

import com.Myapp.ezzyfoodv2.Model.Drink;
import com.Myapp.ezzyfoodv2.Model.Food;
import com.Myapp.ezzyfoodv2.Model.Snack;
import com.Myapp.ezzyfoodv2.Model.Item;

import java.util.Vector;

public class ItemRepository {
    static private Vector<Item> Items = new Vector<Item>();

    public ItemRepository(){
        if(Items.isEmpty()){
            addItem(newDrink("coca cola", 5000));
            addItem(newDrink("Fanta", 6000));
            addItem(newDrink("Sprite", 7000));
            addItem(newDrink("Blue Cola", 4500));
            addItem(newDrink("Lemon Tea", 3000));
            addItem(newDrink("Pepsi", 7000));
            addItem(newDrink("Pepsi Blue", 4500));
            addItem(newDrink("Big Cola", 3000));

            addItem(newFood("Nasi Goreng", 25000));
            addItem(newFood("Siomai", 30000));
            addItem(newFood("Lumpia", 45000));
            addItem(newFood("Stik Sapi", 10000));
            addItem(newFood("Nasi Putih", 7000));
            addItem(newFood("Bakso", 15000));
            addItem(newFood("Bakso Malang", 10000));
            addItem(newFood("Pempek", 25000));

            addItem(newSnack("Kentang Goreng", 7000));
            addItem(newSnack("HashBrowns", 10000));
            addItem(newSnack("Nachos", 30000));
            addItem(newSnack("HotDog", 10000));
            addItem(newSnack("Roti Abon", 7000));
            addItem(newSnack("Cheetos", 3000));
            addItem(newSnack("Hambargah", 50000));
            addItem(newSnack("Salted Egg Chips", 70000));
        }
    }

    public static Item getItemAt(String Name){
        for(Item item : Items){
            if(item.getName().equals(Name)){
                return item;
            }
        }

        return null;
    }

    public static Vector<Item> getDrinks(){
        Vector<Item> drinks = new Vector<>();

        for(Item item : Items){
            if(item instanceof Drink){
                drinks.add(item);
            }
        }

        return drinks;
    }

    public static Vector<Item> getFoods(){
        Vector<Item> foods = new Vector<>();

        for(Item item : Items){
            if(item instanceof Food){
                foods.add(item);
            }
        }

        return foods;
    }
    public static Vector<Item> getSnacks(){
        Vector<Item> snacks = new Vector<>();

        for(Item item : Items){
            if(item instanceof Snack){
                snacks.add(item);
            }
        }

        return snacks;
    }

    public static Item newFood(String name, int price){
        return new Food(name, price);
    }

    public static Item newDrink(String name, int price){
        return new Drink(name, price);
    }

    public static Item newSnack(String name, int price){
        return new Snack(name, price);
    }

    public static void addItem(Item item){
        if(!Items.contains(item)){
            Items.add(item);
        }
    }
}

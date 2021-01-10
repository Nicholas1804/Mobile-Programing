package com.Myapp.ezzyfoodv2.Repository;

import com.Myapp.ezzyfoodv2.Model.Item;
import com.Myapp.ezzyfoodv2.Model.Order;

import java.util.Vector;

public class OrderRepository {
    protected static Vector<Order> orderList;

    public static void addOrder(Item item, int Qty){
        if(orderList == null){
            orderList = new Vector<>();
        }

        if(FindOrder(item) != null){
            Order curr = FindOrder(item);
            curr.setQty(curr.getQty() + Qty);
        }
        else{
            Order newOrder = new Order(item);
            newOrder.setQty(Qty);
            orderList.add(newOrder);
        }
    }

    public static void removeOrder(Order toRemove){
        orderList.remove(toRemove);
    }

    public static Order FindOrder(Item item){
        for(Order order : orderList){
            if(order.getItem() == item){
                return order;
            }
        }

        return null;
    }

    public static Vector<Order> getOrder(){
        if(orderList==null)return null;
        return orderList;
    }

    public static int totalPriceValue(){
        int total = 0;

        for(Order order : orderList){
            total += order.getItem().getPriceValue() * order.getQty();
        }

        return total;
    }
    public static String totalPrice(){
        int total = totalPriceValue();

        return ("Total Price: Rp "+ total);
    }

    public static void clearOrder(){
        orderList.clear();
    }
}

package Accessory;

import Order.Order;

import java.io.Serializable;
import java.util.*;


public abstract class Accessory implements Serializable {

    private Double price;

    private Set<Order> orderSet = new HashSet<>();
    public static ArrayList<Accessory> accessoryList = new ArrayList<>();

    protected Accessory(Double price) {
        this.price = price;
        accessoryList.add(this);
    }

    public Accessory() {

    }

    public void addOrder(Order order){
        if (!orderSet.contains(order)){
            orderSet.add(order);
            order.addAccessory(this);
        }
    }

    public void removeOrder(Order order) {
        if (orderSet.contains(order)){
            orderSet.remove(order);
            order.removeAccessory(this);
        }
    }

    public ArrayList<Accessory> getAvailableAccessories() {
        return null;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }
}

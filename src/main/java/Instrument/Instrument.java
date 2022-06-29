package Instrument;

import Order.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Instrument implements Serializable {
    private String name;
    private Double price;
    private String condition;
    private String availability;
    private Set<Order> orderSet = new HashSet<>();
    private ProducerGift producerGift = null;
    public static ArrayList<Instrument> instrumentList = new ArrayList<>();

    public Instrument(String name, Double price, String condition, String availability) {
        this.name = name;
        this.price = price;
        this.condition = condition;
        this.availability = availability;
        instrumentList.add(this);
    }

    public void addGift(String name){
        producerGift = new ProducerGift(name);
    }

    public void addOrder(Order order){
        if (!orderSet.contains(order)){
            orderSet.add(order);
            order.addInstrument(this);
        }
    }

    public void removeOrder(Order order) {
        if (orderSet.contains(order)){
            orderSet.remove(order);
            order.removeInstrument(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return name;
    }

    public class ProducerGift implements Serializable {
        private String name;

        public ProducerGift(String name) {
            this.name = name;
        }

        public ProducerGift() {

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

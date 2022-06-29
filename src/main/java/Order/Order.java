package Order;

import Accessory.Accessory;
import Instrument.Instrument;
import Person.Client;
import Person.Employee;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Order implements Serializable {

    private LocalDate orderPlacedDate;
    private LocalDate orderCompletioinDate;
    private final int ORDER_ID;
    private static int orderIdGenerator = 1;
    public static ArrayList<Order> orderList = new ArrayList<>();

    private Set<Instrument> instrumentSet = new HashSet<>();

    private Set<Accessory> accessorySet = new HashSet<>();

    private Set<Employee> employeeSet = new HashSet<>();

    private Client client;

    public Order(LocalDate orderPlacedDate) {
        this.orderPlacedDate = orderPlacedDate;
        ORDER_ID = orderIdGenerator;
        orderIdGenerator += 1;
        orderList.add(this);
    }

    public void addAccessory(Accessory accessory){
        if (!accessorySet.contains(accessory)){
            accessorySet.add(accessory);
            accessory.addOrder(this);
        }
    }

    public void removeAccessory(Accessory accessory) {
        if (accessorySet.contains(accessory)){
            accessorySet.remove(accessory);
            accessory.removeOrder(this);
        }
    }

    public void addInstrument(Instrument instrument) {
        if (!instrumentSet.contains(instrument)){
            instrumentSet.add(instrument);
            instrument.addOrder(this);
        }
    }

    public void removeInstrument(Instrument instrument){
        if (instrumentSet.contains(instrument)){
            instrumentSet.remove(instrument);
            instrument.removeOrder(this);
        }
    }

    public void addEmployee(Employee employee) {
        if (!employeeSet.contains(employee)){
            employeeSet.add(employee);
            employee.addEmpOrder(this);
        }
    }

    public void removeEmployee(Employee employee){
        if (employeeSet.contains(employee)){
            employeeSet.remove(employee);
            employee.removeEmpOrder(this);
        }
    }

    public void addClient(Client client) {
        if (this.client == null){
            this.client = client;
            client.addClientOrder(this);
        }
    }

    public void removeClient(Client client) {
        if (this.client != null){
            this.client = null;
            client.removeClientOrder(this);
        }
    }


    public Set<Instrument> getInstrumentSet() {
        return instrumentSet;
    }


    public void setInstrumentSet(Set<Instrument> instrumentSet) {
        this.instrumentSet = instrumentSet;
    }


    public void setAccessorySet(HashSet<Accessory> accessorySet) {
        this.accessorySet = accessorySet;
    }


    public Set<Accessory> getAccessorySet() {
        return accessorySet;
    }

    public LocalDate getOrderPlacedDate() {
        return orderPlacedDate;
    }

    public void setOrderPlacedDate(LocalDate orderPlacedDate) {
        this.orderPlacedDate = orderPlacedDate;
    }

    public LocalDate getOrderCompletioinDate() {
        return orderCompletioinDate;
    }

    public void setOrderCompletioinDate(LocalDate orderCompletioinDate) {
        this.orderCompletioinDate = orderCompletioinDate;
    }

    public static ArrayList<Order> getOrderList() {
        return orderList;
    }

    public static void setOrderList(ArrayList<Order> orderList) {
        Order.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Order{" +
                ", orderPlacedDate=" + orderPlacedDate +
                ", orderCompletioinDate=" + orderCompletioinDate +
                ", instrumentSet=" + instrumentSet +
                ", accessorySet=" + accessorySet +
                ", employeeSet=" + employeeSet +
                ", client=" + client +
                '}';
    }

    public int getORDER_ID() {
        return ORDER_ID;
    }
}

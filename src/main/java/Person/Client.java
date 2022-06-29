package Person;

import Order.Order;
import Repair.Repair;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Client implements Serializable {
    private int numberOfPoints;
    private double discount;
    private Map<Integer, Order> clientOrderMap = new HashMap<>();
    private ArrayList<Repair> repairList = new ArrayList<>();
    public static ArrayList<Client> clientList = new ArrayList<>();

    private Client(int numberOfPoints, double discount) {
        this.numberOfPoints = numberOfPoints;
        this.discount = discount;
        clientList.add(this);
    }

    public static Client createClientRole(Person person, int numberOfPoints, double discount) throws Exception {
        if (person == null) {
            throw new Exception("Client must be connected to Person");
        }
        return new Client(numberOfPoints, discount);
    }

    public void payForRepair(Repair repair) {
        repair.setPaid(true);
        System.out.println("Repair payment accepted.");
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void addClientOrder(Order order) {
        if (!clientOrderMap.containsValue(order)) {
            clientOrderMap.put(order.getORDER_ID(), order);
            order.addClient(this);
        }
    }

    public void removeClientOrder(Order order) {
        if (clientOrderMap.containsValue(order)) {
            clientOrderMap.remove(order.getORDER_ID());
            order.removeClient(this);
        }
    }

    public void removeClientOrder(int orderId) {
        if (clientOrderMap.containsKey(orderId)) {
            clientOrderMap.get(orderId).removeClient(this);
            clientOrderMap.remove(orderId);
        }
    }

    public void addRepair(Repair repair){
        if (!repairList.contains(repair)){
            repairList.add(repair);
            repair.addClient(this);
        }
    }

    public void removeRepair(Repair repair){
        if (repairList.contains(repair)){
            repairList.remove(repair);
            repair.removeClient(this);
        }
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Map<Integer, Order> getClientOrderMap() {
        return clientOrderMap;
    }

    public void setClientOrderMap(Map<Integer, Order> clientOrderMap) {
        this.clientOrderMap = clientOrderMap;
    }

    @Override
    public String toString() {
        return "Client{" +
                "numberOfPoints=" + numberOfPoints +
                ", discount=" + discount +
                '}';
    }
}

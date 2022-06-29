package Person;

import Order.Order;

import java.io.Serializable;
import java.util.*;

public class Employee implements Serializable {
    private int cashRegisterCode;
    private Map<Integer, Order> employeeOrderMap = new HashMap<>();
    public static ArrayList<Employee> employeeList = new ArrayList<>();
    private Employee(int cashRegisterCode) {
        this.cashRegisterCode = cashRegisterCode;
        employeeList.add(this);
    }

    public static Employee createEmployeeRole(Person person, int cashRegisterCode) throws Exception {
        if (person == null) {
            throw new Exception("Employee must be connected to Person");
        }
        return new Employee(cashRegisterCode);
    }

    public void addEmpOrder(Order order) {
        if (!employeeOrderMap.containsValue(order)) {
            employeeOrderMap.put(order.getORDER_ID(), order);
            order.addEmployee(this);
        }
    }

    public void removeEmpOrder(Order order) {
        if (employeeOrderMap.containsValue(order)) {
            employeeOrderMap.remove(order.getORDER_ID());
            order.removeEmployee(this);
        }
    }

    public void removeEmpOrder(int orderId) {
        if (employeeOrderMap.containsKey(orderId)) {
            employeeOrderMap.get(orderId).removeEmployee(this);
            employeeOrderMap.remove(orderId);
        }
    }

    public void grantADiscount(Client client) {
        client.setDiscount(0.15);
    }

    public int getCashRegisterCode() {
        return cashRegisterCode;
    }

    public void setCashRegisterCode(int cashRegisterCode) {
        this.cashRegisterCode = cashRegisterCode;
    }

    public Map<Integer, Order> getEmployeeOrderMap() {
        return employeeOrderMap;
    }

    public void setEmployeeOrderMap(Map<Integer, Order> employeeOrderMap) {
        this.employeeOrderMap = employeeOrderMap;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "cashRegisterCode=" + cashRegisterCode +
                '}';
    }
}

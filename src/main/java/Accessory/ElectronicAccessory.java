package Accessory;

import java.util.ArrayList;


public class ElectronicAccessory extends Accessory{

    private Double power;
    private ArrayList<Integer> input;
    private String powerSupply;
    private Double weight;
    public static ArrayList<ElectronicAccessory> electronicAccessoryList = new ArrayList<>();

    public ElectronicAccessory(Double power, ArrayList<Integer> input, String powerSupply, Double weight, Double price) {
        super(price);
        this.power = power;
        this.input = input;
        this.powerSupply = powerSupply;
        this.weight = weight;
        electronicAccessoryList.add(this);
    }

    @Override
    public String toString() {
        return "ElectronicAccessory{" +
                "power=" + power +
                ", input=" + input +
                ", powerSupply='" + powerSupply + '\'' +
                ", weight=" + weight +
                '}';
    }
}

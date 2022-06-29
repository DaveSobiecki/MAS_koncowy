package Accessory;

import java.util.ArrayList;

public class ElectronicCareAccessory extends ElectronicAccessory implements ICareAccessory{
    private String country;
    private String additionalInfo;
    private String manual;
    public static ArrayList<ElectronicCareAccessory> electronicCareAccessoryList = new ArrayList<>();

    public ElectronicCareAccessory(Double power, ArrayList<Integer> input, String powerSupply, Double weight, String country, String additionalInfo, String manual, Double price) {
        super(power, input, powerSupply, weight, price);
        this.country = country;
        this.additionalInfo = additionalInfo;
        this.manual = manual;
        electronicCareAccessoryList.add(this);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getManual() {
        return manual;
    }

    public void setManual(String manual) {
        this.manual = manual;
    }

    public String getCountryFrom() {
        return country;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    @Override
    public String toString() {
        return "ElectronicCareAccessory{" +
                "country='" + country + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", manual='" + manual + '\'' +
                '}';
    }
}

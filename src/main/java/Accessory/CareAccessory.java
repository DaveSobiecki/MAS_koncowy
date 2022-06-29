package Accessory;


import java.util.ArrayList;

public class CareAccessory extends Accessory implements ICareAccessory{

    private String country;
    private String additionalInfo;
    public static ArrayList<CareAccessory> careAccessoryList = new ArrayList<>();

    public CareAccessory(String country, String additionalInfo, Double price) {
        super(price);
        this.country = country;
        this.additionalInfo = additionalInfo;
        careAccessoryList.add(this);
    }

    public String getCountryFrom() {
        return country;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    @Override
    public String toString() {
        return "CareAccessory{" +
                "country='" + country + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }
}

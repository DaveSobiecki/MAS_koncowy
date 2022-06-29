package Instrument;

import Repair.Repair;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InstrumentRepaired implements Serializable {

    private LocalDate warrantyDate = null;
    private String damageDescription;
    private List<Repair> repairList = new ArrayList<>();
    public static ArrayList<InstrumentRepaired> instrumentRepairedList = new ArrayList<>();

    public InstrumentRepaired(String damageDescription) {
        this.damageDescription = damageDescription;
        instrumentRepairedList.add(this);
    }

    public InstrumentRepaired(LocalDate warrantyDate, String damageDescription) {
        if (warrantyDate != null){
            this.warrantyDate = warrantyDate;
        }
        this.damageDescription = damageDescription;
        instrumentRepairedList.add(this);
    }

    public LocalDate getWarrantyDate() {
        return warrantyDate;
    }

    public void setWarrantyDate(LocalDate warrantyDate) {
        this.warrantyDate = warrantyDate;
    }

    public String getDamageDescription() {
        return damageDescription;
    }

    public void setDamageDescription(String damageDescription) {
        this.damageDescription = damageDescription;
    }

    public List<Repair> getRepairList() {
        return repairList;
    }

    public void setRepairList(List<Repair> repairList) {
        this.repairList = repairList;
    }

    @Override
    public String toString() {
        return "InstrumentRepaired{" +
                "warrantyDate=" + warrantyDate +
                ", damageDescription='" + damageDescription;
    }
}

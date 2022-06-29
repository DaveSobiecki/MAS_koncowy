package Repair;

import Instrument.InstrumentRepaired;
import Person.Client;
import Person.Luthier;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Repair implements Serializable {

    private InstrumentRepaired instrument;
    private ArrayList<Luthier> luthierList = new ArrayList<>();
    private InstrumentCondition condition;
    private Client client;
    private boolean isWarranty;
    private boolean isPaid;
    private LocalDate repairEndDate = null;
    public static ArrayList<Repair> repairsList = new ArrayList<>();


    public Repair() {
        repairsList.add(this);
    }

    public Repair(InstrumentRepaired instrument, Luthier luthier, InstrumentCondition condition) {
        this.instrument = instrument;
        this.addLuthier(luthier);
        this.condition = condition;
        this.instrument.getRepairList().add(this);
        repairsList.add(this);
    }

    public Repair(InstrumentRepaired instrument, Luthier luthier, InstrumentCondition condition, boolean isWarranty, boolean isPaid, LocalDate repairEndDate) {
        this.instrument = instrument;
        this.addLuthier(luthier);
        this.condition = condition;
        this.isWarranty = isWarranty;
        this.isPaid = isPaid;
        this.repairEndDate = repairEndDate;

        this.instrument.getRepairList().add(this);
        repairsList.add(this);
    }

    public void addLuthier(Luthier luthier) {
        if (!luthierList.contains(luthier)) {
            luthierList.add(luthier);
            luthier.addRepair(this);
        }
    }

    public void removeLuthier(Luthier luthier) {
        if (luthierList.contains(luthier)) {
            luthierList.remove(luthier);
            luthier.removeRepair(this);
        }
    }

    public void addClient(Client client){
        if (this.client == null){
            this.client = client;
            client.addRepair(this);
        } else {
            System.out.println("This repair have a client!");
        }
    }

    public void removeClient(Client client){
        if (this.client != null){
            client.removeRepair(this);
            this.client = null;
        } else {
            System.out.println("This repair dont have a client!");
        }
    }

    public void freeFromRepairCosts() {
        isPaid = true;
    }

    public boolean isRepairFinished() {
        return repairEndDate != null;
    }

    public void finalizeRaport() {
        setRepairEndDate(LocalDate.now());
    }

    public static ArrayList<Repair> getAllRepairs() {
        return repairsList;
    }

    public static void removeRepair(Repair repair) {
        repairsList.remove(repair);
    }

    public static boolean checkIfAvailableRepairs() {
        return !repairsList.isEmpty();
    }

    public ArrayList<Luthier> getLuthierList() {
        return luthierList;
    }

    public void setLuthierList(ArrayList<Luthier> luthierList) {
        this.luthierList = luthierList;
    }

    public static ArrayList<Repair> getRepairsList() {
        return repairsList;
    }

    public static void setRepairsList(ArrayList<Repair> repairsList) {
        Repair.repairsList = repairsList;
    }

    public InstrumentRepaired getInstrument() {
        return instrument;
    }

    public void setInstrument(InstrumentRepaired instrument) {
        this.instrument = instrument;
    }


    public InstrumentCondition getCondition() {
        return condition;
    }

    public void setCondition(InstrumentCondition condition) {
        this.condition = condition;
    }

    public boolean isWarranty() {
        return isWarranty;
    }

    public void setWarranty(boolean warranty) {
        isWarranty = warranty;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public LocalDate getRepairEndDate() {
        return repairEndDate;
    }

    public void setRepairEndDate(LocalDate repairEndDate) {
        this.repairEndDate = repairEndDate;
    }

    @Override
    public String toString() {
        return "Instrument damage: " + instrument.getDamageDescription() + " Main Luthier ID: " + luthierList.get(0).getLuthierId();
    }

    public ArrayList<String> getAllAttributes() {
        ArrayList<String> result = new ArrayList<>();
        result.add("Main Luthier ID: " + luthierList.get(0).getLuthierId());
        result.add("Client points: " + client.getNumberOfPoints());
        result.add("Instrument Condition: " + condition);
        result.add("Warranty: " + isWarranty);
        result.add("Is the repair paid: " + isPaid);
        result.add("Date of Repair: " + repairEndDate);
        return result;
    }

    public ArrayList<String> getRaportView() {
        StringBuilder ids = new StringBuilder();
        for (int i = 0; i < luthierList.size(); i++) {
            if (i < luthierList.size() - 1) {
                ids.append(luthierList.get(i).getLuthierId()).append(", ");
            } else {
                ids.append(luthierList.get(i).getLuthierId());
            }
        }

        ArrayList<String> result = new ArrayList<>();
        result.add("Luthier ID's: " + ids);
        result.add("Client points: " + client.getNumberOfPoints());
        result.add("Instrument Condition: " + condition);
        result.add("Warranty: " + isWarranty);
        result.add("Is the repair paid: " + isPaid);
        result.add("Date of Repair: " + LocalDate.now());
        return result;
    }
}

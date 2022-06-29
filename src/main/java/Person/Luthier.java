package Person;

import Repair.Repair;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Luthier implements Serializable {

    private static final int MAX_INSTRUMENTS = 8;
    private List<Repair> repairList = new ArrayList<>();
    private String luthierId;
    public static ArrayList<Luthier> luthierList = new ArrayList<>();

    private Luthier(String luthierId) {
        this.luthierId = luthierId;
        luthierList.add(this);
    }

    public static Luthier createLuthierRole(Person person) throws Exception {
        if (person == null) {
            throw new Exception("Luthier must be connected to Person");
        }
        char[] first = new char[2];
        char[] second = new char[2];
        String newid;
        person.getLastName().getChars(0, 2, first, 0);
        person.getFirstName().getChars(0,2,second,0);
        newid = String.valueOf(first) + String.valueOf(second);
        return new Luthier(newid);
    }

    public String getLuthierId() {
        return luthierId;
    }

    public void addRepair(Repair repair) {
        if (!repairList.contains(repair)) {
            repairList.add(repair);
            repair.addLuthier(this);
        }
    }

    public void removeRepair(Repair repair) {
        if (repairList.contains(repair)) {
            repairList.remove(repair);
            repair.removeLuthier(this);
        }
    }

    public void grantADiscount(Client client) {
        client.setDiscount(0.15);
    }

    public void endRepair(Repair repair) {
        repair.setRepairEndDate(LocalDate.now());
    }

    public List<Repair> getRepairList() {
        return repairList;
    }

    public void setRepairList(List<Repair> repairList) {
        this.repairList = repairList;
    }

    @Override
    public String toString() {
        return "Luthier id: " + luthierId;
    }
}

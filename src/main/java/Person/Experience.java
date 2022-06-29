package Person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Experience implements Serializable {

    private ExperiencedEmployee experiencedEmployee;
    private InexperiencedEmployee inexperiencedEmployee;
    public static ArrayList<Experience> experienceList = new ArrayList<>();

    private Experience() {
        experienceList.add(this);
    }

    public static Experience createExperience(Person person) throws Exception {
        if (person == null){
            throw new Exception("Experience must be connected to Person");
        }
        return new Experience();
    }

    public ExperiencedEmployee getExperiencedEmployee() {
        return experiencedEmployee;
    }

    public void setExperiencedEmployee(LocalDate workCommencementDate, Double baseSallary, Double bonus) {
        if (inexperiencedEmployee != null) {
            inexperiencedEmployee = null;
        }
        try {
            this.experiencedEmployee = ExperiencedEmployee.createExperiencedEmployee(this, workCommencementDate, baseSallary, bonus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public InexperiencedEmployee getInexperiencedEmployee() {
        return inexperiencedEmployee;
    }

    public void setInexperiencedEmployee(LocalDate internshipStartDate, LocalDate internshipEndDate) {
        if (experiencedEmployee != null) {
            experiencedEmployee = null;
        }
        try {
            this.inexperiencedEmployee = InexperiencedEmployee.createInexperiencedEmployee(this, internshipStartDate, internshipEndDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Experience{" +
                "experiencedEmployee=" + experiencedEmployee +
                ", inexperiencedEmployee=" + inexperiencedEmployee +
                '}';
    }
}

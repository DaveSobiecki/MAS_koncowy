package Person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class InexperiencedEmployee implements Serializable {
    private LocalDate internshipStartDate;
    private LocalDate internshipEndDate;
    public static ArrayList<InexperiencedEmployee> inexperiencedEmployeeList = new ArrayList<>();

    private InexperiencedEmployee(LocalDate internshipStartDate, LocalDate internshipEndDate) {
        this.internshipStartDate = internshipStartDate;
        this.internshipEndDate = internshipEndDate;
        inexperiencedEmployeeList.add(this);
    }

    public static InexperiencedEmployee createInexperiencedEmployee(Experience experience, LocalDate internshipStartDate, LocalDate internshipEndDate) throws Exception {
        if (experience == null){
            throw new Exception("InexperiencedEmployee must be connected to Experience");
        }
        return new InexperiencedEmployee(internshipStartDate, internshipEndDate);
    }

    public void reportProblemToExperiencedEmployee(ExperiencedEmployee employee, String problem) {
        employee.handleProblem(problem);
    }

    public LocalDate getInternshipStartDate() {
        return internshipStartDate;
    }

    public void setInternshipStartDate(LocalDate internshipStartDate) {
        this.internshipStartDate = internshipStartDate;
    }

    public LocalDate getInternshipEndDate() {
        return internshipEndDate;
    }

    public void setInternshipEndDate(LocalDate internshipEndDate) {
        this.internshipEndDate = internshipEndDate;
    }

    @Override
    public String toString() {
        return "InexperiencedEmployee{" +
                "internshipStartDate=" + internshipStartDate +
                ", internshipEndDate=" + internshipEndDate +
                '}';
    }
}

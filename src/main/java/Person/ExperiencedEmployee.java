package Person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class ExperiencedEmployee implements Serializable {
    private LocalDate workCommencementDate;
    private Double base;
    private Double bonus;
    public static ArrayList<ExperiencedEmployee> experiencedEmployeeList = new ArrayList<>();

    private ExperiencedEmployee(LocalDate workCommencementDate, Double base, Double bonus) {
        this.workCommencementDate = workCommencementDate;
        this.base = base;
        this.bonus = bonus;
        experiencedEmployeeList.add(this);
    }

    public static ExperiencedEmployee createExperiencedEmployee(Experience experience, LocalDate workCommencementDate, Double baseSallary, Double bonus) throws Exception {
        if (experience == null){
            throw new Exception("ExperiencedEmployee must be connected to Experience");
        }
        return new ExperiencedEmployee(workCommencementDate, baseSallary, bonus);
    }

    public void handleProblem(String problem) {
        System.out.println(problem + " handled.");
    }

    public Double getSallary() {
        return base + bonus;
    }

    public LocalDate getWorkCommencementDate() {
        return workCommencementDate;
    }

    public void setWorkCommencementDate(LocalDate workCommencementDate) {
        this.workCommencementDate = workCommencementDate;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "ExperiencedEmployee{" +
                "workCommencementDate=" + workCommencementDate +
                ", base=" + base +
                ", bonus=" + bonus +
                '}';
    }
}
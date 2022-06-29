package Person;

import Order.Order;
import Repair.Repair;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;


public class Person implements Serializable {

    public static ArrayList<Person> personList = new ArrayList<>();

    private Client clientRole;
    private Employee employeeRole;
    private Luthier luthierRole;

    private List<Repair> repairList = new ArrayList<>();
    private Set<Order> employeeOrderSet = new HashSet<>();
    private List<Order> clientOrderList = new ArrayList<>();

    private String firstName;
    private String lastName;
    private Experience experience;
    private final String PESEL;

    public Person(String firstName, String lastName, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        PESEL = pesel;
        personList.add(this);
    }

    public void addClietnRole(int numberOfPoints) {
        if (clientRole == null) {
            try {
                clientRole = Client.createClientRole(this, numberOfPoints, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("This person is already a client.");
        }
    }

    public void addEmployeeRole(int cashRegisterCode) {
        if (employeeRole == null) {
            try {
                employeeRole = Employee.createEmployeeRole(this, cashRegisterCode);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("This person is already a employee");
        }
    }

    public void addLuthierRole() {
        if (luthierRole == null) {
            try {
                luthierRole = Luthier.createLuthierRole(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("This person is already a luthier.");
        }
    }

    public Experience getExperience() {
        return experience;
    }

    public void setPersonExperience(LocalDate internshipStartDate, LocalDate internshipEndDate) {
        if (experience == null) {
            try {
                experience = Experience.createExperience(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        experience.setInexperiencedEmployee(internshipStartDate, internshipEndDate);
    }

    public void setPersonExperience(LocalDate workCommencementDate, Double baseSallary, Double bonus) {
        if (experience == null) {
            try {
                experience = Experience.createExperience(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        experience.setExperiencedEmployee(workCommencementDate, baseSallary, bonus);
    }

    public Client getClientInstance() throws Exception {
        if (clientRole != null)
            return clientRole;
        throw new Exception("Not a client!");
    }

    public Luthier getLuthierInstance() throws Exception {
        if (luthierRole != null)
            return luthierRole;
        throw new Exception("Not a luthier!");
    }

    public Employee getEmployeeInstance() throws Exception {
        if (employeeRole != null)
            return employeeRole;
        throw new Exception("Not a employee!");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "clientRole=" + clientRole +
                ", employeeRole=" + employeeRole +
                ", luthierRole=" + luthierRole +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", experience=" + experience +
                ", PESEL='" + PESEL + '\'' +
                '}';
    }
}

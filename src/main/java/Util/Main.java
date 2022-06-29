package Util;

import Accessory.Accessory;
import Accessory.CareAccessory;
import Accessory.ElectronicAccessory;
import Accessory.ElectronicCareAccessory;
import Instrument.Instrument;
import Instrument.InstrumentRepaired;
import Order.Order;
import Person.Person;
import Repair.InstrumentCondition;
import Repair.Repair;
import View.MainView;
import javafx.application.Application;
import java.time.LocalDate;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        //createAndSerialize();
        showLoadedData();
        showRepairEndGUI(args);
    }

    private static void createAndSerialize() {

        Person person1 = new Person("Jake", "Nil", "00000000001");
        Person person2 = new Person("Jan", "Kowalski", "00000000002");
        Person person3 = new Person("Bob", "Big", "00000000003");
        Person person4 = new Person("Alan", "Walters", "00000000004");
        Person person5 = new Person("Clint", "Westwood", "00000000005");
        person1.addClietnRole(200);
        person2.addEmployeeRole(1234);
        person3.addLuthierRole();
        person4.addClietnRole(150);
        person4.addLuthierRole();
        person5.addClietnRole(0);
        person5.addLuthierRole();
        person5.addEmployeeRole(1234);

        person2.setPersonExperience(LocalDate.now(), LocalDate.now().plusMonths(2));
        person3.setPersonExperience(LocalDate.of(2018, 5, 5), 4800.0, 500.0);
        person4.setPersonExperience(LocalDate.now(), LocalDate.now().plusMonths(3));
        person5.setPersonExperience(LocalDate.of(2015, 8, 12), 5800.0, 1000.0);

        InstrumentRepaired instrumentRepaired1 = new InstrumentRepaired(LocalDate.of(2024, 8, 12), "Deep scratches");
        InstrumentRepaired instrumentRepaired2 = new InstrumentRepaired(LocalDate.of(2024, 8, 12), "Peeling varnish");
        InstrumentRepaired instrumentRepaired3 = new InstrumentRepaired("Curved bridge");
        InstrumentRepaired instrumentRepaired4 = new InstrumentRepaired("Cracked neck");

        Repair repair1;
        Repair repair2;
        Repair repair3;
        Repair repair4;
        Repair repair5;

        try {
            repair1 = new Repair(
                    instrumentRepaired1,
                    person3.getLuthierInstance(),
                    InstrumentCondition.HIGH_DAMAGE);
            repair2 = new Repair(instrumentRepaired2,
                    person5.getLuthierInstance(),
                    InstrumentCondition.LOW_DAMAGE);
            repair3 = new Repair(instrumentRepaired3,
                    person4.getLuthierInstance(), InstrumentCondition.ADJUSTMENT);
            repair4 = new Repair(instrumentRepaired4,
                    person5.getLuthierInstance(),
                    InstrumentCondition.HIGH_DAMAGE);
            repair5 = new Repair(instrumentRepaired1,
                    person3.getLuthierInstance(),
                    InstrumentCondition.OTHER);

            repair1.setPaid(true);
            repair2.setPaid(true);
            repair2.setWarranty(true);
            repair3.setWarranty(true);

            repair1.addClient(person1.getClientInstance());
            repair2.addClient(person4.getClientInstance());
            repair3.addClient(person5.getClientInstance());
            repair4.addClient(person1.getClientInstance());
            repair5.addClient(person4.getClientInstance());

        } catch (Exception e) {
            e.printStackTrace();
        }


        Instrument instrument1 = new Instrument("Electric Guitar", 7500.0, "Brand New", "Available");
        Instrument instrument2 = new Instrument("Acoustic Guitar", 4000.0, "Brand New", "Available");
        Instrument instrument3 = new Instrument("Piano", 35000.0, "Brand New", "Available");
        Instrument instrument4 = new Instrument("Trumpet", 2000.0, "Used", "Available");
        Instrument instrument5 = new Instrument("Didgeridoo", 800.0, "Brand New", "Available");

        //InstrumentGift
        instrument1.addGift("gift1");
        instrument2.addGift("gift2");
        instrument3.addGift("gift3");
        instrument4.addGift("gift4");
        instrument5.addGift("gift5");


        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        Accessory accessory1 = new ElectronicAccessory(5.0, input, "PowerOne", 1.5, 250.0);
        Accessory accessory2 = new ElectronicAccessory(3.0, input, "PowerTwo", 2.5, 350.0);
        Accessory accessory3 = new CareAccessory("Poland", "Info3", 24.99);
        Accessory accessory4 = new CareAccessory("USA", "Info4", 49.99);
        Accessory accessory5 = new ElectronicCareAccessory(5.0, input, "PowerOne", 1.5, "Poland", "Info5", "Manual5", 750.0);



        Order order1 = new Order(LocalDate.now());
        Order order2 = new Order(LocalDate.now().minusDays(3));
        Order order3 = new Order(LocalDate.now().minusDays(5));
        Order order4 = new Order(LocalDate.now().minusDays(7));

        //Order - accessories
        order1.addAccessory(accessory5);
        order1.addAccessory(accessory2);
        order2.addAccessory(accessory1);
        order3.addAccessory(accessory3);
        order4.addAccessory(accessory4);

        //Order - instruments
        order1.addInstrument(instrument1);
        order1.addInstrument(instrument2);
        order2.addInstrument(instrument3);
        order3.addInstrument(instrument4);
        order4.addInstrument(instrument5);

        //Order - emps
        try {
            order1.addEmployee(person2.getEmployeeInstance());
            order2.addEmployee(person5.getEmployeeInstance());
            order3.addEmployee(person5.getEmployeeInstance());
            order4.addEmployee(person2.getEmployeeInstance());
            order2.addEmployee(person2.getEmployeeInstance());

            //Order - clients
            order1.addClient(person1.getClientInstance());
            order2.addClient(person4.getClientInstance());
            order3.addClient(person5.getClientInstance());
            order4.addClient(person1.getClientInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SerializationUtil.serializeObject(Order.orderList, "OrderList.obj");
        SerializationUtil.serializeObject(Repair.repairsList, "RepairList.obj");
        SerializationUtil.serializeObject(Person.personList, "PersonList.obj");
        SerializationUtil.serializeObject(Instrument.instrumentList, "InstrumentList.obj");
        SerializationUtil.serializeObject(Accessory.accessoryList, "AccessoryList.obj");

    }

    public static void showRepairEndGUI(String[] args) {
        Application.launch(MainView.class, args);
    }

    private static void showLoadedData(){
        ArrayList<Order> orders = SerializationUtil.deserializeObject(Order.class, "OrderList.obj");
        ArrayList<Repair> repairs = SerializationUtil.deserializeObject(Repair.class, "RepairList.obj");
        ArrayList<Person> persons = SerializationUtil.deserializeObject(Person.class, "PersonList.obj");
        ArrayList<Instrument> instruments = SerializationUtil.deserializeObject(Instrument.class, "InstrumentList.obj");
        ArrayList<Accessory> accessories = SerializationUtil.deserializeObject(Accessory.class, "AccessoryList.obj");

        Order.orderList = orders;
        Repair.repairsList = repairs;
        Person.personList = persons;
        Instrument.instrumentList = instruments;
        Accessory.accessoryList = accessories;

        Order.orderList.forEach(System.out::println);
        Repair.repairsList.forEach(System.out::println);
        Person.personList.forEach(System.out::println);
        Instrument.instrumentList.forEach(System.out::println);
        Accessory.accessoryList.forEach(System.out::println);
    }
}

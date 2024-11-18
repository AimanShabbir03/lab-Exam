/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author user
 */
import java.util.*;

interface Observer {
    void update(String message);
}

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

class Person {
    String id;
    String name;
    String type; // "student" or "faculty"

    public Person(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
}

class Transport {
    String transportType; // "public", "ownConvenience", "university"
    boolean isAdvancePaid;

    public Transport(String transportType, boolean isAdvancePaid) {
        this.transportType = transportType;
        this.isAdvancePaid = isAdvancePaid;
    }
}

interface Filter {
    boolean apply(Person person, Transport transport);
}

class StudentFilter implements Filter {
    public boolean apply(Person person, Transport transport) {
        return person.type.equals("student") && transport.transportType.equals("university");
    }
}

class AdvancePaidFilter implements Filter {
    public boolean apply(Person person, Transport transport) {
        return transport.isAdvancePaid;
    }
}

class Driver implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void announceDeparture() {
        notifyObservers("Driver is leaving from the university.");
    }
}

class Student implements Observer {
    String id;
    String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }
}

class TransportService {
    private List<Filter> filters = new ArrayList<>();

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public boolean checkEligibility(Person person, Transport transport) {
        for (Filter filter : filters) {
            if (!filter.apply(person, transport)) {
                return false;
            }
        }
        return true;
    }
}

public class UniversityTransportSystem {
    public static void main(String[] args) {
        Driver driver = new Driver();
        
        Student student1 = new Student("S1", "Aiman");
        Student student2 = new Student("S2", "Areeba");
        
        driver.addObserver(student1);
        driver.addObserver(student2);
        
        driver.announceDeparture();

        TransportService service = new TransportService();
        service.addFilter(new StudentFilter());
        service.addFilter(new AdvancePaidFilter());

        Person student = new Person("S1", "Aiman", "student");
        Transport universityBus = new Transport("university", true);

        if (service.checkEligibility(student, universityBus)) {
            System.out.println(student.name + " is eligible to board the bus.");
        } else {
            System.out.println(student.name + " is not eligible to board the bus.");
        }
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author user
 */


public class UniversityTransportSystem1 {
    public static void main(String[] args) {
        // Create a Driver (Subject)
        Driver driver = new Driver();

        // Create Students (Observers)
        Student student1 = new Student("S1", "warda");
        Student student2 = new Student("S2", "ferdous");

        // Register Students
        driver.addObserver(student1);
        driver.addObserver(student2);

        // Announce Departure
        driver.announceDeparture();

        // Create Transport Service and Filters
        TransportService service = new TransportService();
        service.addFilter(new StudentFilter());
        service.addFilter(new AdvancePaidFilter());

        // Test Scenario
        Person student = new Person("S1", "warda", "student");
        Transport universityBus = new Transport("university", true);

        if (service.checkEligibility(student, universityBus)) {
            System.out.println(student.name + " is eligible to board the bus.");
        } else {
            System.out.println(student.name + " is not eligible to board the bus.");
        }
    }
}


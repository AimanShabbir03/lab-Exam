/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */


public class StudentFilter implements Filter {
    @Override
    public boolean apply(Person person, Transport transport) {
        return person.type.equals("student") && transport.transportType.equals("university");
    }
}


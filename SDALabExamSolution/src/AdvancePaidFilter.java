/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */


public class AdvancePaidFilter implements Filter {
    @Override
    public boolean apply(Person person, Transport transport) {
        return transport.isAdvancePaid;
    }
}


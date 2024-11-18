/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */



import java.util.ArrayList;
import java.util.List;  

public class TransportService {
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




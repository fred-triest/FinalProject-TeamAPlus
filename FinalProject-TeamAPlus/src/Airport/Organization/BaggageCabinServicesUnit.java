/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.Organization;

import Airport.Role.BaggageHandlerRole;
import Airport.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author fredtriest
 */
public class BaggageCabinServicesUnit extends Organization {
    
    public BaggageCabinServicesUnit() {
        
        // Hard coded name for the Baggage Cabin Services Unit
        super("Baggage Cabin Services Unit");
    }
    
    // Implement from parent class
    @Override
    public ArrayList<Role> getSupportedRole() {
    ArrayList<Role> roleList = new ArrayList<Role>();
    roleList.add(new BaggageHandlerRole());
        return roleList;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.Organization;

import Airport.Enterprise.Enterprise;
import Airport.Role.PassengerServicesAgentRole;
import Airport.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author fredtriest
 */
public class PassengerServicesDepartment extends Organization {
    
    public PassengerServicesDepartment(Enterprise enterprise) {
        
        // Hard coded name for the Passenger Services Department
        super("Passenger Services Department", enterprise);
    }
    
    // Implement from parent class
    @Override
    public ArrayList<Role> getSupportedRole() {
    ArrayList<Role> roleList = new ArrayList<Role>();
    roleList.add(new PassengerServicesAgentRole(this));
        return roleList;
    }
}

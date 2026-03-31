/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.Organization;

import Airport.Role.FlightSchedulerRole;
import Airport.Role.OperationsManagerRole;
import Airport.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author fredtriest
 */
public class FlightOperationsDivision extends Organization {
    
    public FlightOperationsDivision() {
        
        // Hard coded name for the Flight Operations Division
        super("Flight Operations Division");
    }
    
    // Implement from parent class
    @Override
    public ArrayList<Role> getSupportedRole() {
    ArrayList<Role> roleList = new ArrayList<Role>();
    roleList.add(new FlightSchedulerRole(this));
    roleList.add(new OperationsManagerRole(this));
        return roleList;
    }
}

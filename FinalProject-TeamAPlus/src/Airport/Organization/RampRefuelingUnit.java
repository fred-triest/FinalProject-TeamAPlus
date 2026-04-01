/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.Organization;

import Airport.Enterprise.Enterprise;
import Airport.Role.RampSupervisorRole;
import Airport.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author fredtriest
 */
public class RampRefuelingUnit extends Organization {
    
    public RampRefuelingUnit(Enterprise enterprise) {
        
        // Hard coded name for the Ramp Refueling Unit
        super("Ramp Refueling Unit", enterprise);
    }
    
    // Implement from parent class
    @Override
    public ArrayList<Role> getSupportedRole() {
    ArrayList<Role> roleList = new ArrayList<Role>();
    roleList.add(new RampSupervisorRole(this));
        return roleList;
    }
}

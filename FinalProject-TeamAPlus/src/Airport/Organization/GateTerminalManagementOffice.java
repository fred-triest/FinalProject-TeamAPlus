/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.Organization;

import Airport.Role.GateCoordinatorRole;
import Airport.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author fredtriest
 */
public class GateTerminalManagementOffice extends Organization {
    
    public GateTerminalManagementOffice() {
        
        // Hard coded name for the Gate Terminal Management Office
        super("Gate Terminal Management Office");
    }
    
    // Implement from parent class
    @Override
    public ArrayList<Role> getSupportedRole() {
    ArrayList<Role> roleList = new ArrayList<Role>();
    roleList.add(new GateCoordinatorRole(this));
        return roleList;
    }
}

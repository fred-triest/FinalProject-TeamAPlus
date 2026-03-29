/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.Enterprise;

import Airport.Role.EnterpriseAdminRole;
import Airport.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author fredtriest
 */
public class JapanAirlines extends Enterprise {
    
    // Hardcoded name for JapanAirlines
    public JapanAirlines() {
        super("Japan Airlines");
    }
    
    // Implement from parent class
    @Override
    public ArrayList<Role> getSupportedRole() {
    ArrayList<Role> roleList = new ArrayList<Role>();
    roleList.add(new EnterpriseAdminRole());
        return roleList;
    }
}

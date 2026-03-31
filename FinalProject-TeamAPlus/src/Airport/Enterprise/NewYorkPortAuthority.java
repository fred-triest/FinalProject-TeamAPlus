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
public class NewYorkPortAuthority extends Enterprise {
    
    // Hardcoded name for NewYorkPortAuthority
    public NewYorkPortAuthority() {
        super("New York Port Authority");
    }
    
    // Implement from parent class
    @Override
    public ArrayList<Role> getSupportedRole() {
    ArrayList<Role> roleList = new ArrayList<Role>();
    roleList.add(new EnterpriseAdminRole(this));
        return roleList;
    }
}

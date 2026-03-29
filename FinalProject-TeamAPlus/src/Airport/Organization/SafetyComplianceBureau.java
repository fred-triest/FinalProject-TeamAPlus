/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.Organization;

import Airport.Role.SafetyInspectorRole;
import Airport.Role.ComplianceOfficerRole;
import Airport.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author fredtriest
 */
public class SafetyComplianceBureau extends Organization {
    
    public SafetyComplianceBureau() {
        
        // Hard coded name for the Safety Compliance Bureau
        super("Safety Compliance Bureau");
    }
    
    // Implement from parent class
    @Override
    public ArrayList<Role> getSupportedRole() {
    ArrayList<Role> roleList = new ArrayList<Role>();
    roleList.add(new SafetyInspectorRole());
    roleList.add(new ComplianceOfficerRole());
        return roleList;
    }
}

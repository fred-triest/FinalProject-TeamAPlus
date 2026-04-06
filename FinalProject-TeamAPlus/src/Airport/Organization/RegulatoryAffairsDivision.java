/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.Organization;

import Airport.Enterprise.Enterprise;
import Airport.Role.ComplianceOfficerRole;
import Airport.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author cohenpowell
 */
public class RegulatoryAffairsDivision extends Organization {

    public RegulatoryAffairsDivision(Enterprise enterprise) {

        // Hard coded name for the Regulatory Affairs Division
        super("Regulatory Affairs Division", enterprise);
    }

    // Implement from parent class
    @Override
    public ArrayList<Role> getSupportedRole() {
    ArrayList<Role> roleList = new ArrayList<Role>();
    roleList.add(new ComplianceOfficerRole(this));
        return roleList;
    }
}

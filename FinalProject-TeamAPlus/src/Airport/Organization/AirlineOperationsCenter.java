/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.Organization;

import Airport.Enterprise.Enterprise;
import Airport.Role.OperationsManagerRole;
import Airport.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author cohenpowell
 */
public class AirlineOperationsCenter extends Organization {

    public AirlineOperationsCenter(Enterprise enterprise) {

        // Hard coded name for the Airline Operations Center
        super("Airline Operations Center", enterprise);
    }

    // Implement from parent class
    @Override
    public ArrayList<Role> getSupportedRole() {
    ArrayList<Role> roleList = new ArrayList<Role>();
    roleList.add(new OperationsManagerRole(this));
        return roleList;
    }
}

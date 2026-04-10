/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.Role;

import Airport.AirportEcoSystem;
import Airport.Enterprise.Enterprise;
import Airport.Organization.Organization;
import Airport.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author fredtriest
 */
public abstract class Role {
    
    private RoleType roleType;
    private Organization organization;
    
    public Role(RoleType roleType, Organization organization) {
        
        this.roleType = roleType;
        this.organization = organization;
    }
    
    public enum RoleType{
        
        FlightScheduler("Flight Scheduler"),
        PassengerServicesAgent("Passenger Services Agent"),
        GateCoordinator("Gate Coordinator"),
        SafetyInspector("Safety Inspector"),
        RampSupervisor("Ramp Supervisor"),
        BaggageHandler("Baggage Handler"),
        OperationsManager("Operations Manager"),
        ComplianceOfficer("Compliance Officer");
        
    private String value;
    
    private RoleType(String value) {
        
        this.value = value;
    }

    public String getValue() {
        
        return value;
    }

    @Override
    public String toString() {
        
        return value;
    }
}
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
        
        UserAccount account, 
        Organization organization, 
        Enterprise enterprise, 
        AirportEcoSystem airport);
    
    public RoleType getRoleType() {
        
        return roleType;
        
    }
        
    public Organization getOrganization() {
        
        return organization;
        
    }
        
    @Override
    public String toString() {
        
        return this.getRoleType().getValue();
    }
}

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
    
    @Override
    public String toString() {
        
        return this.getClass().getName();
    }
}

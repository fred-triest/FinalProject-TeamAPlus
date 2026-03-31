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
import ui.PassengerServicesAgent.PassengerServicesAgentWorkAreaJPanel;
/**
 *
 * @author fredtriest
 */
public class PassengerServicesAgentRole extends Role {
    
    public PassengerServicesAgentRole(Organization organization) {
        
        super(RoleType.PassengerServicesAgent, organization);
        
    }

    // Pass all parameters so we know logged in user, the org they belong to, etc.
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
            UserAccount userAccount,
            Organization organization,
            Enterprise enterprise,
            AirportEcoSystem airport) {
            
            return new PassengerServicesAgentWorkAreaJPanel(userProcessContainer, userAccount, organization, enterprise, airport);    
    }
    
    // Display for panel
    public String toString() {
        
        return "Passenger Services Agent";
        
    }
            
}

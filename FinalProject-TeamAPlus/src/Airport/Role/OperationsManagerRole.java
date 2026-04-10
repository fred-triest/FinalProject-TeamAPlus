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
import ui.OperationsManager.OperationsManagerWorkAreaJPanel;
/**
 *
 * @author fredtriest
 */
public class OperationsManagerRole extends Role {
    
    public OperationsManagerRole(Organization organization) {
        
        super(RoleType.OperationsManager, organization);
        
    }

    // Pass all parameters so we know logged in user, the org they belong to, etc.
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
            UserAccount userAccount,
            Organization organization,
            Enterprise enterprise,
            AirportEcoSystem airport) {
            
            return new OperationsManagerWorkAreaJPanel(userProcessContainer, userAccount, organization, enterprise, airport);    
    }
    
    // Display for panel
    @Override
    public String toString() {
        
        return "Operations Manager";
        
    }
            
}


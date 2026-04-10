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
import ui.SystemAdmin.SystemAdminWorkAreaJPanel;

/**
 *
 * @author fredtriest
 */
// Since this extends Role, it inherits roleType and organization fields and we implement createWorkArea()
public class SystemAdminRole extends Role {
    
    // super() satisfies Role's required parameters
    public SystemAdminRole() {
        
        super(null, null);
        
    }
    
    // Implement abstract method from Role and returns work area panel for this role
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
            UserAccount userAccount,
            Organization organization,
            Enterprise enterprise,
            AirportEcoSystem airport) {
            
            return new SystemAdminWorkAreaJPanel(userProcessContainer, airport);
    }
    
    // displays role
    @Override
    public String toString() {
        
        return "System Admin";
    }
            
}

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
import ui.EnterpriseAdmin.EnterpriseAdminWorkAreaJPanel;
/**
 *
 * @author fredtriest
 */
// Since this extends Role, it inherits roleType and organization fields and we implement createWorkArea()
public class EnterpriseAdminRole extends Role {
    
    // Since enterprise admins belong to an enterprise and not organizations, we store enterprise here
    private Enterprise enterprise;
    
    public EnterpriseAdminRole(Enterprise enterprise) {
        
        super(null, null);
        this.enterprise = enterprise;
    }
    
    public Enterprise getEnterprise() {
        
        return enterprise;
        
    }
    // Pass all parameters so we know logged in user, the org they belong to, etc.
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
            UserAccount userAccount,
            Organization organization,
            Enterprise enterprise,
            AirportEcoSystem airport) {
            
            return new EnterpriseAdminWorkAreaJPanel(userProcessContainer, userAccount, organization, enterprise, airport);    
    }
    
    // Display name for panels
    @Override
    public String toString() {
        
        return "Enterprise Admin";
        
    }
}

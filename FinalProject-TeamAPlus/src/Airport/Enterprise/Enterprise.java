/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.Enterprise;

import Airport.Organization.Organization;
import Airport.Organization.OrganizationDirectory;

/**
 *
 * @author fredtriest
 */
public abstract class Enterprise extends Organization {
    
    // Initialize organizationDirectory reference
    private OrganizationDirectory organizationDirectory;

    public Enterprise (String name) {
        
        // Instantiate parent class name and organizationDirectory reference
        super(name);
        organizationDirectory = new OrganizationDirectory();
    }
    
    // Get the organizationDirectory reference
    public OrganizationDirectory getOrganizationDirectory() {
        
        return organizationDirectory;
    }
    
    // Set the organizationDirectory reference
    public void setOrganizationDirectory (OrganizationDirectory organizationDirectory) {
        
        this.organizationDirectory = organizationDirectory;
    }
    
    // Use toString() because the default value is not useful so we return name of the enterprise instead
    @Override
    public String toString() {
        
        return this.getName();
    }
}

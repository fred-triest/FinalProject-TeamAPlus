/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.Organization;

import java.util.ArrayList;

/**
 *
 * @author fredtriest
 */
public class OrganizationDirectory {
    
    // Initialize ArrayList for organizationList
    private ArrayList<Organization> organizationList;
    
    public OrganizationDirectory() {
        
        // Instantiate an organizationList
        organizationList = new ArrayList<Organization>();
    }
    
    // Add an Organization to the organization list
    public void addOrganization(Organization organization) {
        
        organizationList.add(organization);
    }
    
    // Get the organizationList
    public ArrayList<Organization> getOrganizationList() {
        
        return organizationList;
    }
    
    // Find the organization from the organizationList
    public Organization findOrganization(String name) {
        
        for (Organization o : organizationList) {
            if (o.getName().equals(name))
                return o;
        }
        return null;
    }
}

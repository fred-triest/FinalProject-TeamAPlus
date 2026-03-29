/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author fredtriest
 */
public class EnterpriseDirectory {
    
    // Initialize ArrayList for enterpriseList
    private ArrayList<Enterprise> enterpriseList;
    
    public EnterpriseDirectory() {
        
        // Instantiate an enterpriseList
        enterpriseList = new ArrayList<Enterprise>();
    }
    
    // Adds an Enterprise to the enterpriseList
    public void addEnterprise(Enterprise enterprise) {
        
        enterpriseList.add(enterprise);
    }
    
    // Get the enterpriseList
    public ArrayList<Enterprise> getEnterpriseList() {
        
        return enterpriseList;
    }
    
    // Find the Enterprise from the enterpriseList
    public Enterprise findEnterprise(String name) {
        
        for (Enterprise e : enterpriseList) {
            if (e.getName().equals(name))
                return e;
        }
        return null;
    }
    
    // Remove an enterprise from the enterpriseList
    public void removeEnterprise(Enterprise enterprise) {
        enterpriseList.remove(enterprise);
    }
}

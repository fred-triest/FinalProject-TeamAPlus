/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.Network;

import Airport.Enterprise.EnterpriseDirectory;

/**
 *
 * @author fredtriest
 */
public class Network {
    
    // Instantiate name, networkId, static counter and enterpriseDirectory reference
    private String name;
    private String networkId;
    private static int counter = 1;
    private EnterpriseDirectory enterpriseDirectory;
    
    public Network(String name) {
        
        this.name = name;
        networkId = "NID-" + String.format("%05d", counter);
        ++counter;
        enterpriseDirectory = new EnterpriseDirectory();
    }
    
    public String getName() {
        
        return name;
    }
    
    public void setName(String name) {
        
        this.name = name;
    }
    
    public String getNetworkId() {
        
        return networkId;
    }
    
    public EnterpriseDirectory getEnterpriseDirectory() {
        
        return enterpriseDirectory;
    }
    
    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        
        this.enterpriseDirectory = enterpriseDirectory;
    }
    
    @Override
    public String toString() {
        
        return name;
    }
    
    
}

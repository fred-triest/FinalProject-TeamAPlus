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

// Container that holds enterprises and we need only one network
public class Network {
    
    // Initialize name, networkId, static counter and enterpriseDirectory reference
    private String name;
    private String networkId;
    private static int counter = 1;
    private EnterpriseDirectory enterpriseDirectory;
    
    public Network(String name) {
        
        // Instantiate name, networkId population based on format and increment counter
        this.name = name;
        networkId = "NID-" + String.format("%05d", counter);
        ++counter;
        enterpriseDirectory = new EnterpriseDirectory();
    }
    
    // Get the name of the network
    public String getName() {
        
        return name;
    }
    
    // Set the name of the network
    public void setName(String name) {
        
        this.name = name;
    }
    
    // Get the networkId
    public String getNetworkId() {
        
        return networkId;
    }
    
    // Get the enterpriseDirectory reference
    public EnterpriseDirectory getEnterpriseDirectory() {
        
        return enterpriseDirectory;
    }
    
    // Set the enterpriseDirectory reference
    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        
        this.enterpriseDirectory = enterpriseDirectory;
    }
    
    // Use toString() because the default value is not useful so we return name of the network instead
    @Override
    public String toString() {
        
        return name;
    }
    
    
}

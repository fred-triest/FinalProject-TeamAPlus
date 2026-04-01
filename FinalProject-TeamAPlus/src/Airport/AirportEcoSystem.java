/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport;

import Airport.Organization.Organization;
import Airport.Network.Network;
import Airport.Role.Role;
import Airport.Role.SystemAdminRole;
import java.util.ArrayList;
/**
 *
 * @author fredtriest
 */
public class AirportEcoSystem extends Organization{
    
    // airport holds the single intance of airport
    private static AirportEcoSystem airport;
    
    // Holds the list of networks in the AirportEcoSystem
    private ArrayList<Network> networkList;
    
    // Gets the one airport instance
    public static AirportEcoSystem getInstance(){
        
        // Checks if airport is null and if it is create one or return existing airport
        if(airport == null){
            airport = new AirportEcoSystem();
        }
        return airport;
    }
    
    // Creates and adds a new network to the networkList
    public Network createAndAddNetwork(String name) {
        
        Network network = new Network(name);
        networkList.add(network);
        return network;
    }
    
    // Gets the list of supported roles for the ecosystem
    @Override
    public ArrayList<Role> getSupportedRole() {
        
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    
    // Instantiates the AirportEcoSystem and networkList without a parent
    private AirportEcoSystem() {
        
        super(null, null);
        networkList = new ArrayList<Network>();
    }
    
    // Gets the list of networks
    public ArrayList<Network> getNetworkList() {
        
        return networkList;
    }

}

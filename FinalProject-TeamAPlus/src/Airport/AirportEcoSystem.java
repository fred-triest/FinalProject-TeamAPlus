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
    
    private static AirportEcoSystem airport;
    private ArrayList<Network> networkList;
    
    public static AirportEcoSystem getInstance(){
        
        if(airport == null){
            airport = new AirportEcoSystem();
        }
        return airport;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    
    private AirportEcoSystem() {
        
        super(null);
        networkList = new ArrayList<Network>();
    }

}

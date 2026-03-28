/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport;

import Airport.Organization.Organization;
import Airport.Network.Network;
import java.util.ArrayList;
/**
 *
 * @author fredtriest
 */
public class AirportEcoSystem extends Organization{
    
    private static AirportEcoSystem airport;
    private ArrayList<Network> networkList;
    public static AirportEcoSystem getInstance(){
        if(airport==null){
            airport=new AirportEcoSystem();
        }
        return airport;
    }
}

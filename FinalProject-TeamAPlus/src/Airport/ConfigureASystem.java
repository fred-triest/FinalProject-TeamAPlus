/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport;

import Airport.Employee.Employee;
import Airport.Enterprise.GroundMasterServices;
import Airport.Enterprise.JapanAirlines;
import Airport.Enterprise.NewYorkPortAuthority;
import Airport.Network.Network;
import Airport.Organization.BaggageCabinServicesUnit;
import Airport.Organization.AirlineOperationsCenter;
import Airport.Organization.FlightOperationsDivision;
import Airport.Organization.GateTerminalManagementOffice;
import Airport.Organization.PassengerServicesDepartment;
import Airport.Organization.RampRefuelingUnit;
import Airport.Organization.RegulatoryAffairsDivision;
import Airport.Organization.SafetyComplianceBureau;
import Airport.Role.BaggageHandlerRole;
import Airport.Role.ComplianceOfficerRole;
import Airport.Role.EnterpriseAdminRole;
import Airport.Role.FlightSchedulerRole;
import Airport.Role.GateCoordinatorRole;
import Airport.Role.OperationsManagerRole;
import Airport.Role.PassengerServicesAgentRole;
import Airport.Role.RampSupervisorRole;
import Airport.Role.SafetyInspectorRole;
import Airport.Role.SystemAdminRole;
import Airport.UserAccount.UserAccount;

/**
 *
 * @author fredtriest
 */
public class ConfigureASystem {
    
    // Utility method so we can call it directly without creating an object
    public static AirportEcoSystem configure() {
        
        // Store single instance in variable
        AirportEcoSystem system = AirportEcoSystem.getInstance();
        
        // Create JFK network and add to AirportEcoSystem
        Network network = system.createAndAddNetwork("JFK International Airport Network");
        
        // Create Enterprises
        network.getEnterpriseDirectory().addEnterprise(new JapanAirlines());
        network.getEnterpriseDirectory().addEnterprise(new NewYorkPortAuthority());
        network.getEnterpriseDirectory().addEnterprise(new GroundMasterServices());
        
        // Get enterprises
        JapanAirlines japanAirlines = (JapanAirlines) network.getEnterpriseDirectory().findEnterprise("Japan Airlines");
        NewYorkPortAuthority newYorkPortAuthority = (NewYorkPortAuthority) network.getEnterpriseDirectory().findEnterprise("New York Port Authority");
        GroundMasterServices groundMasterServices = (GroundMasterServices) network.getEnterpriseDirectory().findEnterprise("Ground Master Services");
        
        // Add organizations to respective enterprises
        japanAirlines.getOrganizationDirectory().addOrganization(new FlightOperationsDivision());
        japanAirlines.getOrganizationDirectory().addOrganization(new PassengerServicesDepartment());
        japanAirlines.getOrganizationDirectory().addOrganization(new AirlineOperationsCenter());
        newYorkPortAuthority.getOrganizationDirectory().addOrganization(new GateTerminalManagementOffice());
        newYorkPortAuthority.getOrganizationDirectory().addOrganization(new SafetyComplianceBureau());
        newYorkPortAuthority.getOrganizationDirectory().addOrganization(new RegulatoryAffairsDivision());
        groundMasterServices.getOrganizationDirectory().addOrganization(new RampRefuelingUnit());
        groundMasterServices.getOrganizationDirectory().addOrganization(new BaggageCabinServicesUnit());
        
        // Create employees and userAccounts (ecoSystem admin, enterprise admins)
        Employee sysAdminEmployee = system.getEmployeeDirectory().createEmployee("sysadmin", "sysadmin@jfk.org", "212-555-0147", "Airport Systems Administrator", 28);
        UserAccount sysAdminUA = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", sysAdminEmployee, new SystemAdminRole());
        Employee jalAdminEmployee = japanAirlines.getEmployeeDirectory().createEmployee("jaladmin", "jaladmin@jal.co.jp", "646-555-0382", "JAL Systems Administrator", 38);
        UserAccount jalAdminUA = japanAirlines.getUserAccountDirectory().createUserAccount("jaladmin", "jaladmin", jalAdminEmployee, new EnterpriseAdminRole(japanAirlines));
        Employee nypaAdminEmployee = newYorkPortAuthority.getEmployeeDirectory().createEmployee("nypaadmin", "nypaadmin@nypa.org", "718-555-1239", "NYPA Systems Administrator", 32);
        UserAccount nypaAdminUA = newYorkPortAuthority.getUserAccountDirectory().createUserAccount("nypaadmin", "nypaadmin", nypaAdminEmployee, new EnterpriseAdminRole(newYorkPortAuthority));
        Employee groundAdminEmployee = groundMasterServices.getEmployeeDirectory().createEmployee("groundadmin", "groundadmin@groundmasterservices.com", "917-555-0897", "Grounds System Administrator", 45);
        UserAccount groundAdminUA = groundMasterServices.getUserAccountDirectory().createUserAccount("groundadmin", "groundadmin", groundAdminEmployee,new EnterpriseAdminRole(groundMasterServices));
        
        // Create FlightOperationsDivision with Flight Scheduler and Operations Manager
        FlightOperationsDivision flightOps = (FlightOperationsDivision) japanAirlines.getOrganizationDirectory().findOrganization("Flight Operations Division");
        Employee flightSchedulerEmployee = flightOps.getEmployeeDirectory().createEmployee("flightScheduler", "flightscheduler@jal.co.jp", "234-122-8899", "Senior Flight Scheduler", 31);
        UserAccount flightSchedulerUA = flightOps.getUserAccountDirectory().createUserAccount("flightScheduler", "flightScheduler", flightSchedulerEmployee, new FlightSchedulerRole(flightOps));
        Employee operationsManagerEmployee = flightOps.getEmployeeDirectory().createEmployee("operationsManager", "operationsmanager@jal.co.jp", "223-345-8798","Ops Manager", 52);
        UserAccount operationsManagerUA = flightOps.getUserAccountDirectory().createUserAccount("operationsManager", "operationsManager", operationsManagerEmployee, new OperationsManagerRole(flightOps));
        
        // Create PassengeServicesDepartment with Passenger Services Agent
        PassengerServicesDepartment passengerServices = (PassengerServicesDepartment) japanAirlines.getOrganizationDirectory().findOrganization("Passenger Services Department");
        Employee passengerAgentEmployee = passengerServices.getEmployeeDirectory().createEmployee("passengerAgent", "passengeragent@jal.co.jp", "454-333-8789", "Senior Passenger Agent",28);
        UserAccount passengerAgentUA = passengerServices.getUserAccountDirectory().createUserAccount("passengerAgent", "passengerAgent", passengerAgentEmployee, new PassengerServicesAgentRole(passengerServices));
        
        // Create GateTerminalManagementOffice with Gate Coordinator
        GateTerminalManagementOffice gateTerminal = (GateTerminalManagementOffice) newYorkPortAuthority.getOrganizationDirectory().findOrganization("Gate Terminal Management Office");
        Employee gateCoordinatorEmployee = gateTerminal.getEmployeeDirectory().createEmployee("gateCoordinator", "gatecoordinator@nypa.org", "111-234-8912", "Gate Coordinator", 29);
        UserAccount gateCoordinatorUA = gateTerminal.getUserAccountDirectory().createUserAccount("gateCoordinator", "gateCoordinator", gateCoordinatorEmployee, new GateCoordinatorRole(gateTerminal));
        
        // Create SafetyComplianceBureau with Safety Inspector and Compliance Officer
        SafetyComplianceBureau safetyBureau = (SafetyComplianceBureau) newYorkPortAuthority.getOrganizationDirectory().findOrganization("Safety Compliance Bureau");
        Employee safetyInspectorEmployee = safetyBureau.getEmployeeDirectory().createEmployee("safetyInspector", "safetyinsepctor@nypa.org", "917-333-9123", "Junior Safety Inspector", 26);
        UserAccount safetyInspectorUA = safetyBureau.getUserAccountDirectory().createUserAccount("safetyInspector", "safetyInspector", safetyInspectorEmployee, new SafetyInspectorRole(safetyBureau));
        Employee complianceOfficerEmployee = safetyBureau.getEmployeeDirectory().createEmployee("complianceOfficer", "complianceofficer@nypa.org", "889-908-0098", "Director of Compliance", 54);
        UserAccount complianceOfficerUA = safetyBureau.getUserAccountDirectory().createUserAccount("complianceOfficer", "complianceOfficer", complianceOfficerEmployee, new ComplianceOfficerRole(safetyBureau));
        
        // Create RampRefuelingUnit with Ramp Supervisor
        RampRefuelingUnit rampRefueling = (RampRefuelingUnit) groundMasterServices.getOrganizationDirectory().findOrganization("Ramp Refueling Unit");
        Employee rampSupervisorEmployee = rampRefueling.getEmployeeDirectory().createEmployee("rampSupervisor", "rampsupervisor@groundmasterservices.com", "832-888-4321", "Ramp Supervisor",37);
        UserAccount rampSupervisorUA = rampRefueling.getUserAccountDirectory().createUserAccount("rampSupervisor", "rampSupervisor", rampSupervisorEmployee, new RampSupervisorRole(rampRefueling));
                
        // Create BaggageCabinServicesUnit with Baggage Handler
        BaggageCabinServicesUnit baggageServices = (BaggageCabinServicesUnit) groundMasterServices.getOrganizationDirectory().findOrganization("Baggage Cabin Services Unit");
        Employee baggageHandlerEmployee = baggageServices.getEmployeeDirectory().createEmployee("baggageHandler", "baggagehandler@groundmasterservices.com", "334-890-7865", "Baggage Handler", 31);
        UserAccount baggageHandlerUA = baggageServices.getUserAccountDirectory().createUserAccount("baggageHandler", "baggageHandler", baggageHandlerEmployee, new BaggageHandlerRole(baggageServices));
                
        return system;
    }
    
}

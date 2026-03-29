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
import Airport.Organization.FlightOperationsDivision;
import Airport.Organization.GateTerminalManagementOffice;
import Airport.Organization.PassengerServicesDepartment;
import Airport.Organization.RampRefuelingUnit;
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
        newYorkPortAuthority.getOrganizationDirectory().addOrganization(new GateTerminalManagementOffice());
        newYorkPortAuthority.getOrganizationDirectory().addOrganization(new SafetyComplianceBureau());
        groundMasterServices.getOrganizationDirectory().addOrganization(new RampRefuelingUnit());
        groundMasterServices.getOrganizationDirectory().addOrganization(new BaggageCabinServicesUnit());
        
        // Create employees and userAccounts (ecoSystem admin, enterprise admins)
        Employee sysAdminEmployee = system.getEmployeeDirectory().createEmployee("sysadmin", "sysadmin@jfk.org");
        UserAccount sysAdminUA = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", sysAdminEmployee, new SystemAdminRole());
        Employee jalAdminEmployee = japanAirlines.getEmployeeDirectory().createEmployee("jaladmin", "jaladmin@jal.co.jp");
        UserAccount jalAdminUA = japanAirlines.getUserAccountDirectory().createUserAccount("jaladmin", "jaladmin", jalAdminEmployee, new EnterpriseAdminRole());
        Employee nypaAdminEmployee = newYorkPortAuthority.getEmployeeDirectory().createEmployee("nypaadmin", "nypaadmin@nypa.org");
        UserAccount nypaAdminUA = newYorkPortAuthority.getUserAccountDirectory().createUserAccount("nypaadmin", "nypaadmin", nypaAdminEmployee, new EnterpriseAdminRole());
        Employee groundAdminEmployee = groundMasterServices.getEmployeeDirectory().createEmployee("groundadmin", "groundadmin@groundmasterservices.com");
        UserAccount groundAdminUA = groundMasterServices.getUserAccountDirectory().createUserAccount("groundadmin", "groundadmin", groundAdminEmployee,new EnterpriseAdminRole());
        
        // Create FlightOperationsDivision with Flight Scheduler and Operations Manager
        FlightOperationsDivision flightOps = (FlightOperationsDivision) japanAirlines.getOrganizationDirectory().findOrganization("Flight Operations Division");
        Employee flightSchedulerEmployee = flightOps.getEmployeeDirectory().createEmployee("flightScheduler", "flightscheduler@jal.co.jp");
        UserAccount flightSchedulerUA = flightOps.getUserAccountDirectory().createUserAccount("flightScheduler", "flightScheduler", flightSchedulerEmployee, new FlightSchedulerRole());
        Employee operationsManagerEmployee = flightOps.getEmployeeDirectory().createEmployee("operationsManager", "operationsmanager@jal.co.jp");
        UserAccount operationsManagerUA = flightOps.getUserAccountDirectory().createUserAccount("operationsManager", "operationsManager", operationsManagerEmployee, new OperationsManagerRole());
        
        // Create PassengeServicesDepartment with Passenger Services Agent
        PassengerServicesDepartment passengerServices = (PassengerServicesDepartment) japanAirlines.getOrganizationDirectory().findOrganization("Passenger Services Department");
        Employee passengerAgentEmployee = passengerServices.getEmployeeDirectory().createEmployee("passengerAgent", "passengeragent@jal.co.jp");
        UserAccount passengerAgentUA = passengerServices.getUserAccountDirectory().createUserAccount("passengerAgent", "passengerAgent", passengerAgentEmployee, new PassengerServicesAgentRole());
        
        // Create GateTerminalManagementOffice with Gate Coordinator
        GateTerminalManagementOffice gateTerminal = (GateTerminalManagementOffice) newYorkPortAuthority.getOrganizationDirectory().findOrganization("Gate Terminal Management Office");
        Employee gateCoordinatorEmployee = gateTerminal.getEmployeeDirectory().createEmployee("gateCoordinator", "gatecoordinator@nypa.org");
        UserAccount gateCoordinatorUA = gateTerminal.getUserAccountDirectory().createUserAccount("gateCoordinator", "gateCoordinator", gateCoordinatorEmployee, new GateCoordinatorRole());
        
        // Create SafetyComplianceBureau with Safety Inspector and Compliance Officer
        SafetyComplianceBureau safetyBureau = (SafetyComplianceBureau) newYorkPortAuthority.getOrganizationDirectory().findOrganization("Safety Compliance Bureau");
        Employee safetyInspectorEmployee = safetyBureau.getEmployeeDirectory().createEmployee("safetyInspector", "safetyinsepctor@nypa.org");
        UserAccount safetyInspectorUA = safetyBureau.getUserAccountDirectory().createUserAccount("safetyInspector", "safetyInspector", safetyInspectorEmployee, new SafetyInspectorRole());
        Employee complianceOfficerEmployee = safetyBureau.getEmployeeDirectory().createEmployee("complianceOfficer", "complianceofficer@nypa.org");
        UserAccount complianceOfficerUA = safetyBureau.getUserAccountDirectory().createUserAccount("complianceOfficer", "complianceOfficer", complianceOfficerEmployee, new ComplianceOfficerRole());
        
        // Create RampRefuelingUnit with Ramp Supervisor
        RampRefuelingUnit rampRefueling = (RampRefuelingUnit) groundMasterServices.getOrganizationDirectory().findOrganization("Ramp Refueling Unit");
        Employee rampSupervisorEmployee = rampRefueling.getEmployeeDirectory().createEmployee("rampSupervisor", "rampsupervisor@groundmasterservices.com");
        UserAccount rampSupervisorUA = rampRefueling.getUserAccountDirectory().createUserAccount("rampSupervisor", "rampSupervisor", rampSupervisorEmployee, new RampSupervisorRole());
                
        // Create BaggageCabinServicesUnit with Baggage Handler
        BaggageCabinServicesUnit baggageServices = (BaggageCabinServicesUnit) groundMasterServices.getOrganizationDirectory().findOrganization("Baggage Cabin Services Unit");
        Employee baggageHandlerEmployee = baggageServices.getEmployeeDirectory().createEmployee("baggageHandler", "baggagehandler@groundmasterservices.com");
        UserAccount baggageHandlerUA = baggageServices.getUserAccountDirectory().createUserAccount("baggageHandler", "baggageHandler", baggageHandlerEmployee, new BaggageHandlerRole());
                
        return system;
    }
    
}

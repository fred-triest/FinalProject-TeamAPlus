/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport;

import Airport.Employee.Employee;
import Airport.Enterprise.Enterprise;
import Airport.Network.Network;
import Airport.Organization.BaggageCabinServicesUnit;
import Airport.Organization.FlightOperationsDivision;
import Airport.WorkQueue.GroundHandlingRequest;
import Airport.Organization.RampRefuelingUnit;
import Airport.WorkQueue.BaggageIrregularityReport;
import Airport.Role.BaggageHandlerRole;
import Airport.Role.FlightSchedulerRole;
import com.github.javafaker.Faker;


/**
 * DataGenerator - Populates the system with realistic fake employee data
 * @author Larry Tsao (wakingstardust)
 */
public class DataGenerator {

    public static void generate(AirportEcoSystem system) {

        Faker faker = new Faker();

        Network network = system.getNetworkList().get(0);

        Enterprise japanAirlines = network.getEnterpriseDirectory().findEnterprise("Japan Airlines");
        Enterprise groundMasterServices = network.getEnterpriseDirectory().findEnterprise("Ground Master Services");

        // Add 10 fake Baggage Handlers to BaggageCabinServicesUnit
        BaggageCabinServicesUnit baggageUnit = (BaggageCabinServicesUnit) groundMasterServices.getOrganizationDirectory().findOrganization("Baggage Cabin Services Unit");

        for (int i = 0; i < 10; i++) {
            String name = faker.name().fullName();
            String email = faker.internet().emailAddress();

            Employee emp = baggageUnit.getEmployeeDirectory().createEmployee(name, email, faker.phoneNumber().cellPhone(), "Baggage Handler", faker.number().numberBetween(22, 60));
                        
            baggageUnit.getUserAccountDirectory().createUserAccount("baggage" + i, "baggageHandler1&", emp, new BaggageHandlerRole(baggageUnit));
        }

        // Add 10 fake Flight Schedulers to FlightOperationsDivision
        FlightOperationsDivision flightOps = (FlightOperationsDivision) japanAirlines.getOrganizationDirectory().findOrganization("Flight Operations Division");

        for (int i = 0; i < 10; i++) {
            String name = faker.name().fullName();
            String email = faker.internet().emailAddress();

            Employee emp = flightOps.getEmployeeDirectory().createEmployee(name, email, faker.phoneNumber().cellPhone(), "Flight Scheduler", faker.number().numberBetween(22, 60));

            flightOps.getUserAccountDirectory().createUserAccount("scheduler" + i, "flightScheduler1&", emp, new FlightSchedulerRole(flightOps));
            
           
        }
        
        // Add fake work requests to org work queues for Report B
        BaggageCabinServicesUnit baggageUnit2 = (BaggageCabinServicesUnit) groundMasterServices.getOrganizationDirectory().findOrganization("Baggage Cabin Services Unit");
        RampRefuelingUnit rampUnit = (RampRefuelingUnit) groundMasterServices.getOrganizationDirectory().findOrganization("Ramp Refueling Unit");
        FlightOperationsDivision flightOps2 = (FlightOperationsDivision) japanAirlines.getOrganizationDirectory().findOrganization("Flight Operations Division");

        for (int i = 0; i < 5; i++) {
            BaggageIrregularityReport bir = new BaggageIrregularityReport(
                "Lost", "TAG-" + faker.number().digits(6),
                "JL" + faker.number().numberBetween(100, 999),
                faker.name().fullName(), "Terminal 1",
                baggageUnit2, rampUnit, "Baggage Handler"
            );
            baggageUnit2.getWorkQueue().addWorkRequest(bir);
        }

        for (int i = 0; i < 5; i++) {
            GroundHandlingRequest ghr = new GroundHandlingRequest(
                "JL" + faker.number().numberBetween(100, 999),
                "Gate " + faker.number().numberBetween(1, 30),
                "Boeing 787",
                true, true, false,
                rampUnit, flightOps2, "Ramp Supervisor"
            );
            rampUnit.getWorkQueue().addWorkRequest(ghr);
        }
    }
}

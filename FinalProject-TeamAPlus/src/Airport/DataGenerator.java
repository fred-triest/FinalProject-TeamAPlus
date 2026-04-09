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

            Employee emp = baggageUnit.getEmployeeDirectory().createEmployee(name, email);
            baggageUnit.getUserAccountDirectory().createUserAccount("baggage" + i, "password", emp, new BaggageHandlerRole());
        }

        // Add 10 fake Flight Schedulers to FlightOperationsDivision
        FlightOperationsDivision flightOps = (FlightOperationsDivision) japanAirlines.getOrganizationDirectory().findOrganization("Flight Operations Division");

        for (int i = 0; i < 10; i++) {
            String name = faker.name().fullName();
            String email = faker.internet().emailAddress();

            Employee emp = flightOps.getEmployeeDirectory().createEmployee(name, email);
            flightOps.getUserAccountDirectory().createUserAccount("scheduler" + i, "password", emp, new FlightSchedulerRole());
        }
    }
}

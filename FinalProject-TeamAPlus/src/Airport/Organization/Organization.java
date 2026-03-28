/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.Organization;

import Airport.Employee.EmployeeDirectory;
import Airport.Role.Role;
import Airport.UserAccount.UserAccountDirectory;
import Airport.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author fredtriest
 */
// Abstract base class for organizations, always a specific org like FlightOperationsDivision
public abstract class Organization {
    
    // Initialize name, references and organizationId variables
    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private String organizationId;
    private static int counter = 1;
    
    // Instantiating name, refererences, and populating the organizationId format
    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationId = "OID-" + String.format("%05d", counter);
        ++counter;
    }
    
    // Get the supported role from the organization (e.g. For FlightOperationsDivision, Flight Scheduler and Operations Manager
    public abstract ArrayList<Role> getSupportedRole();
    
    // Get the name of the organization
    public String getName() {
        
        return name;
    }
    
    // Set the name of the organization
    public void setName(String name) {
        
        this.name = name;
    }
    
    // Get the WorkQueue reference
    public WorkQueue getWorkQueue() {
        
        return workQueue;
    }
    
    // Set the WorkQueue reference
    public void setWorkQueue(WorkQueue workQueue) {
        
        this.workQueue = workQueue;
    }
    
    // Get the EmployeeDirectory reference
    public EmployeeDirectory getEmployeeDirectory() {
        
        return employeeDirectory;
    }
    
    // Set the EmployeeDirectory reference
    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
       
        this.employeeDirectory = employeeDirectory;
    }
    
    // Get the UserAccountDirectory reference
    public UserAccountDirectory getUserAccountDirectory() {
        
        return userAccountDirectory;
    }
    
    // Set the UserAccountDirectory reference
    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        
        this.userAccountDirectory = userAccountDirectory;
    }
    
    // Get the formatted organizationId
    public String getOrganizationId() {
        
        return organizationId;
    }
    
    // Use toString() because the default value is not useful so we return name instead
    @Override
    public String toString() {
        
        return name;
    }
    
}

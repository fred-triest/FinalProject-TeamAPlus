/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.Employee;

/**
 *
 * @author fredtriest
 */
public class Employee {
    
    // Initialize name, email, employeeId and counter
    private String name;
    private String email;
    private String employeeId;
    private static int counter = 1;
    
    public Employee() {
        
        // Instantiate employeeId based on format
        employeeId = "EID-" + String.format("%05d", counter);
        ++counter;
    }
    
    public String getName() {
        
        return name;
    }
    
    public void setName(String name) {
        
        this.name = name;
    }
    
    public String getEmail() {
        
        return email;
    }
    
    public void setEmail(String email) {
        
        this.email = email;
    }
    
    public String getEmployeeId() {
        
        return employeeId;
    }
    
    // Use toString() because the default value is not useful so we return name instead
    @Override
    public String toString() {
        
        return name;
    }
    
    
}

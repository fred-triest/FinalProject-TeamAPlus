/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.UserAccount;

import Airport.Employee.Employee;
import Airport.Role.Role;

/**
 *
 * @author fredtriest
 */
public class UserAccount {
    
    // Initialize username, password, employee and role references
    private String username;
    private String password;
    private String userAccountId;
    private Employee employee;
    private Role role;
    private static int counter = 1;
    
    public UserAccount(String username, String password, Employee employee, Role role) {
        
        this.username = username;
        this.password = password;
        this.employee = employee;
        this.role = role;
        // Instantiate userAccountId based on format
        userAccountId = "UAID-" + String.format("%05d", counter);
        ++counter;
    }
    
    public String getUsername() {
        
        return username;
    }
    
    public void setUsername(String username) {
        
        this.username = username;
    }
    
    public void setPassword(String password) {
        
        this.password = password;
    }
    
    public Employee getEmployee() {
        
        return employee;
    }
    
    public void setEmployee(Employee employee) {
        
        this.employee = employee;
    }
    
    public Role getRole() {
        
        return role;
    }
    
    public void setRole(Role role) {
        
        this.role = role;
    }
    
    public String getUserAccountId() {
        
        return userAccountId;
        
    }
    
    // Checks if username and pw match
    public boolean validateUser(String username, String password) {
        
        return this.username.equals(username) && this.password.equals(password);
    }
     
    // Use toString() because the default value is not useful so we return name instead
    @Override
    public String toString() {
        
        return username;
    }   
}

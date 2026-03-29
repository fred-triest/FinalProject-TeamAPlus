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
    private Employee employee;
    private Role role;
    
    public UserAccount() {
                
    }
    
    public String getUsername() {
        
        return username;
    }
    
    public void setUsername(String username) {
        
        this.username = username;
    }
    
    public String getPassword() {
        
        return password;
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
     
    // Use toString() because the default value is not useful so we return name instead
    @Override
    public String toString() {
        
        return username;
    }   
}

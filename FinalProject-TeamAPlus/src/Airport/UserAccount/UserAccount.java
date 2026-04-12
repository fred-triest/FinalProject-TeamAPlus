/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.UserAccount;

import Airport.Employee.Employee;
import Airport.Role.Role;
import java.security.MessageDigest;

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
        this.employee = employee;
        this.role = role;
        // Instantiate userAccountId based on format
        userAccountId = "UAID-" + String.format("%05d", counter);
        ++counter;
        setPassword(password);
        
    }
    
    private String hashPassword(String password) {
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            StringBuilder hexString = new StringBuilder();
            byte[] hash = md.digest(password.getBytes());
            for (byte b : hash) {
                String hex = String.format("%02x", b);
                hexString.append(hex);
            } 
            return hexString.toString();   
        } catch (Exception e) {
            return password;
        }
    }
    
    private boolean passwordRequirementsMet(String password) {
        
        if (password.length() < 8) {
            
            return false;
            
        }
        
        boolean upperCase = false;
        boolean digit = false;
        boolean specialCharacter = false;
        
        for (int i = 0; i < password.length(); i++) {
            
            char ch = password.charAt(i);
            
            if (Character.isUpperCase(ch)) {
                
                upperCase = true;
                
            }
            
            if (Character.isDigit(ch)) {
                
                digit = true;
                
            }
            
            if (!Character.isLetter(ch) && !Character.isDigit(ch)) {
                
                specialCharacter = true;
                
            }
                        
        }
        
        return upperCase && digit && specialCharacter;

    }
    
    public String getUsername() {
        
        return username;
    }
    
    public void setUsername(String username) {
        
        this.username = username;
    }
    
    public boolean setPassword(String password) {
        
        if (!passwordRequirementsMet(password)) {
            
            return false;
            
        }
        
        this.password = hashPassword(password);
        return true;
        
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
        
        if (this.password == null) {
            
            return false;
            
        }
        return this.username.equals(username) && this.password.equals(hashPassword(password));
    }
     
    // Use toString() because the default value is not useful so we return name instead
    @Override
    public String toString() {
        
        return username;
    }   
}

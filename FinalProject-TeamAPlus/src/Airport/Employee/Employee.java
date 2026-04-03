/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.Employee;

import javax.swing.JOptionPane;

/**
 *
 * @author fredtriest
 */
public class Employee {
    
    // Initialize name, email, employeeId and counter
    private String name;
    private String email;
    private String employeeId;
    private String phone;
    private String title;
    private int age;
    private static int counter = 1;
    
    public Employee(String name, String email, String phone, String title, int age) {
        
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.title = title;
        this.age = age;
        
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
        
        if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            JOptionPane.showMessageDialog(null, "Please enter in valid email");
        } else {
            this.email = email;

        }
    }
    
    public String getEmployeeId() {
        
        return employeeId;
    }
    
    public String getPhone() {
        
        return phone;
    }
    
    public void setPhone(String phone) {
        
        this.phone = phone;
    }
    
    public String getTitle() {
        
        return title;
    }
    
    public void setTitle(String title) {
        
        this.title = title;
    }
    
    public int getAge() {
        
        return age;
    }
    
    public void setAge(int age) {
        
        if (age < 16 || age > 100) {
            JOptionPane.showMessageDialog(null, "You can only enter an age of 16 to 100 years old");
        } else {
            
            this.age = age;
        }
    }
    
    // Use toString() because the default value is not useful so we return name instead
    @Override
    public String toString() {
        
        return name;
    }
    
    
}

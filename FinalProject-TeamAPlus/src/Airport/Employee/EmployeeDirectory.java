/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.Employee;

import java.util.ArrayList;

/**
 *
 * @author fredtriest
 */
public class EmployeeDirectory {
    
    // Initialize ArrayList for employeeList
    private ArrayList<Employee> employeeList;
    
    public EmployeeDirectory() {
        
        // Instantiate an employeeList
        employeeList = new ArrayList<Employee>();
    }
    
    // Get the employeeList
    public ArrayList<Employee> getEmployeeList() {
        
        return employeeList;
    }
    
    // Find the employee from the employeeList
    public Employee findEmployee(String employeeId) {
        
        for (Employee e : employeeList) {
            if (e.getEmployeeId().equals(employeeId)) {
                return e;
            }
        }
        return null;
    }
    
    // Creates an employee
    public Employee createEmployee(String name, String email, String phone, String title, int age){
        Employee employee = new Employee(name, email, phone, title, age);
        employeeList.add(employee);
        return employee;
    } 
        
}

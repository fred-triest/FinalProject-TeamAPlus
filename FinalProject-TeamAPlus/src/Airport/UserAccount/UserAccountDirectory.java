/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.UserAccount;

import Airport.Employee.Employee;
import Airport.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author fredtriest
 */
public class UserAccountDirectory {
    
    // Initialize ArrayList for userAccountList
    private ArrayList<UserAccount> userAccountList;
    
    public UserAccountDirectory() {
        
        // Instantiate a userAccountList
        userAccountList = new ArrayList<UserAccount>();
    }
    
    // Adds a userAccount to the userAccountList
    public void addUserAccount(UserAccount userAccount) {
        
        userAccountList.add(userAccount);
    }
    
    // Get the userAccountList
    public ArrayList<UserAccount> getUserAccountList() {
        
        return userAccountList;
    }
    
    // Find the userAccount from the userAccountList
    public UserAccount findUserAccount(String username) {
        
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equals(username)) {
                return ua;
            }
        }
        return null;
    }
    
    // Authenticate user by matching username and password
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    // Creates a userAccount
    public UserAccount createUserAccount(String username, String password, Employee employee, Role role){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    } 
    
    // Confirms if a username already exists
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount ua : userAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.WorkQueue;

/**
 *
 * @author fredtriest
 */
// Abstract base class for work requests because fields like status with be the same across different work requests and it can be extended for org specific work request fields
public abstract class WorkRequest {
    
    // Initialize auto-generated workRequestId, status, description and counter for generated workRequestId
    private String workRequestId;
    private String status;
    private String description;
    private static int counter = 1;
    
    public WorkRequest() {
        
        // Generate the workRequestId
        workRequestId = "WRID-" + String.format("%05d", counter);
        ++counter;
    }
    
    // Get the workRequestId
    public String getWorkRequestId() {
        
        return workRequestId;
    }
    
    // Get the status
    public String getStatus() {
        
        return status;
    }
    
    // Set the status
    public void setStatus(String status) {
        
        this.status = status;
    }
    
    // Get the description
    public String getDescription() {
        
        return description;
    }
    
    // Set the description
    public void setDescription(String description) {
        
        this.description = description;
    }

    // Use toString() because the default value is not useful so we return name instead
    @Override
    public String toString() {
        
        return workRequestId;
    }
}

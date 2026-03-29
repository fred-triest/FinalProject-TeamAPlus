/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author fredtriest
 */
public class WorkQueue {
    
    // Initialize ArrayList for the workQueue
    private ArrayList<WorkRequest> workQueue;
    
    public WorkQueue() {
        
        // Instantiate a workQueue
        workQueue = new ArrayList<WorkRequest>();
    }
    
    // Add a workRequest to the workQueue
    public void addWorkRequest(WorkRequest workRequest) {
        
        workQueue.add(workRequest);
    }
    
    // Get the workQueue
    public ArrayList<WorkRequest> getWorkQueue() {
        
        return workQueue;
    }
    
    // Find the workRequest from the workQueue
    public WorkRequest getWorkRequest(String workRequestId) {
        
        for (WorkRequest wr : workQueue) {
            if (wr.getWorkRequestId().equals(workRequestId)) {
                return wr;
            }
        }
        return null;
    }
}

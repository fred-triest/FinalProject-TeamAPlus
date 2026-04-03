/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airport.WorkQueue;

import Airport.Organization.Organization;

/**
 *
 * @author cohenpowell
 */
public class GroundHandlingRequest extends WorkRequest {

    private String flightNumber;
    private String gateNumber;
    private String aircraftType;

    private boolean refuelingRequired;
    private boolean cleaningRequired;
    private boolean cateringRequired;
    private String crewAssignment;
    private String estimatedCompletionTime;

    private Organization senderOrganization;
    private Organization receiverOrganization;
    private String senderName;
    private String receiverName;
    private String notes;

    public GroundHandlingRequest(String flightNumber, String gateNumber, String aircraftType,
            boolean refuelingRequired, boolean cleaningRequired, boolean cateringRequired,
            Organization senderOrg, Organization receiverOrg, String senderName) {

        super();
        this.flightNumber = flightNumber;
        this.gateNumber = gateNumber;
        this.aircraftType = aircraftType;
        this.refuelingRequired = refuelingRequired;
        this.cleaningRequired = cleaningRequired;
        this.cateringRequired = cateringRequired;
        this.senderOrganization = senderOrg;
        this.receiverOrganization = receiverOrg;
        this.senderName = senderName;
        this.receiverName = "";
        this.crewAssignment = "";
        this.estimatedCompletionTime = "";
        this.notes = "";

        setStatus("Dispatched");
        setDescription("Ground handling request for flight " + flightNumber + " at gate " + gateNumber);
    }

    public boolean canTransitionTo(String newStatus) {
        String current = getStatus();
        switch (current) {
            case "Dispatched":
                return newStatus.equals("Crew Assigned");
            case "Crew Assigned":
                return newStatus.equals("In Progress");
            case "In Progress":
                return newStatus.equals("Completed");
            case "Completed":
                return false;
            default:
                return false;
        }
    }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public String getGateNumber() { return gateNumber; }
    public void setGateNumber(String gateNumber) { this.gateNumber = gateNumber; }

    public String getAircraftType() { return aircraftType; }
    public void setAircraftType(String aircraftType) { this.aircraftType = aircraftType; }

    public boolean isRefuelingRequired() { return refuelingRequired; }
    public void setRefuelingRequired(boolean refuelingRequired) { this.refuelingRequired = refuelingRequired; }

    public boolean isCleaningRequired() { return cleaningRequired; }
    public void setCleaningRequired(boolean cleaningRequired) { this.cleaningRequired = cleaningRequired; }

    public boolean isCateringRequired() { return cateringRequired; }
    public void setCateringRequired(boolean cateringRequired) { this.cateringRequired = cateringRequired; }

    public String getCrewAssignment() { return crewAssignment; }
    public void setCrewAssignment(String crewAssignment) { this.crewAssignment = crewAssignment; }

    public String getEstimatedCompletionTime() { return estimatedCompletionTime; }
    public void setEstimatedCompletionTime(String estimatedCompletionTime) { this.estimatedCompletionTime = estimatedCompletionTime; }

    public Organization getSenderOrganization() { return senderOrganization; }
    public Organization getReceiverOrganization() { return receiverOrganization; }

    public String getSenderName() { return senderName; }
    public void setSenderName(String senderName) { this.senderName = senderName; }

    public String getReceiverName() { return receiverName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    @Override
    public String toString() {
        return "Ground Handling: " + flightNumber + " [" + getStatus() + "]";
    }
}

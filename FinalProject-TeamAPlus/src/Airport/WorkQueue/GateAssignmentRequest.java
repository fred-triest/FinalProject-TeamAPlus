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
public class GateAssignmentRequest extends WorkRequest {

    private String flightNumber;
    private String aircraftType;
    private String scheduledTime;
    private String flightType; // arrival or departure

    private String requestedGate;
    private String assignedGate;
    private String terminalSection;

    private Organization senderOrganization;
    private Organization receiverOrganization;
    private String senderName;
    private String receiverName;
    private String conflictNotes;

    public GateAssignmentRequest(String flightNumber, String aircraftType, String scheduledTime,
            String flightType, String requestedGate, Organization senderOrg, Organization receiverOrg,
            String senderName) {

        super();
        this.flightNumber = flightNumber;
        this.aircraftType = aircraftType;
        this.scheduledTime = scheduledTime;
        this.flightType = flightType;
        this.requestedGate = requestedGate;
        this.senderOrganization = senderOrg;
        this.receiverOrganization = receiverOrg;
        this.senderName = senderName;
        this.receiverName = "";
        this.conflictNotes = "";
        this.assignedGate = "";
        this.terminalSection = "";

        setStatus("Submitted");
        setDescription("Gate assignment request for flight " + flightNumber);
    }

    public boolean canTransitionTo(String newStatus) {
        String current = getStatus();
        switch (current) {
            case "Submitted":
                return newStatus.equals("Under Review");
            case "Under Review":
                return newStatus.equals("Assigned") || newStatus.equals("Conflict Flagged");
            case "Assigned":
                return newStatus.equals("Confirmed");
            case "Conflict Flagged":
                return newStatus.equals("Under Review") || newStatus.equals("Assigned");
            case "Confirmed":
                return false;
            default:
                return false;
        }
    }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public String getAircraftType() { return aircraftType; }
    public void setAircraftType(String aircraftType) { this.aircraftType = aircraftType; }

    public String getScheduledTime() { return scheduledTime; }
    public void setScheduledTime(String scheduledTime) { this.scheduledTime = scheduledTime; }

    public String getFlightType() { return flightType; }
    public void setFlightType(String flightType) { this.flightType = flightType; }

    public String getRequestedGate() { return requestedGate; }
    public void setRequestedGate(String requestedGate) { this.requestedGate = requestedGate; }

    public String getAssignedGate() { return assignedGate; }
    public void setAssignedGate(String assignedGate) { this.assignedGate = assignedGate; }

    public String getTerminalSection() { return terminalSection; }
    public void setTerminalSection(String terminalSection) { this.terminalSection = terminalSection; }

    public Organization getSenderOrganization() { return senderOrganization; }
    public Organization getReceiverOrganization() { return receiverOrganization; }

    public String getSenderName() { return senderName; }
    public void setSenderName(String senderName) { this.senderName = senderName; }

    public String getReceiverName() { return receiverName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }

    public String getConflictNotes() { return conflictNotes; }
    public void setConflictNotes(String conflictNotes) { this.conflictNotes = conflictNotes; }

    @Override
    public String toString() {
        return "Gate Request: " + flightNumber + " [" + getStatus() + "]";
    }
}

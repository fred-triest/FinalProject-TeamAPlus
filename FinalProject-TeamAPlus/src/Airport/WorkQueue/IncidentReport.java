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
public class IncidentReport extends WorkRequest {

    private String incidentType; // Ramp Collision, FOD, Spill, Runway Incursion, etc.
    private String location;
    private String dateTime;
    private String severity; // Low, Medium, High, Critical
    private String involvedParties;
    private String incidentDescription;
    private String auditFindings;
    private String violationDetails;

    private Organization senderOrganization;
    private Organization receiverOrganization;
    private String senderName;
    private String receiverName;

    public IncidentReport(String incidentType, String location, String dateTime,
            String severity, String involvedParties, String incidentDescription,
            Organization senderOrg, Organization receiverOrg, String senderName) {

        super();
        this.incidentType = incidentType;
        this.location = location;
        this.dateTime = dateTime;
        this.severity = severity;
        this.involvedParties = involvedParties;
        this.incidentDescription = incidentDescription;
        this.senderOrganization = senderOrg;
        this.receiverOrganization = receiverOrg;
        this.senderName = senderName;
        this.receiverName = "";
        this.auditFindings = "";
        this.violationDetails = "";

        setStatus("Reported");
        setDescription(severity + " incident: " + incidentType + " at " + location);
    }

    public boolean canTransitionTo(String newStatus) {
        String current = getStatus();
        switch (current) {
            case "Reported":
                return newStatus.equals("Under Review");
            case "Under Review":
                return newStatus.equals("Audit Initiated") || newStatus.equals("Closed");
            case "Audit Initiated":
                return newStatus.equals("Closed") || newStatus.equals("Violation Issued");
            case "Closed":
            case "Violation Issued":
                return false;
            default:
                return false;
        }
    }

    public String getIncidentType() { return incidentType; }
    public void setIncidentType(String incidentType) { this.incidentType = incidentType; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDateTime() { return dateTime; }
    public void setDateTime(String dateTime) { this.dateTime = dateTime; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getInvolvedParties() { return involvedParties; }
    public void setInvolvedParties(String involvedParties) { this.involvedParties = involvedParties; }

    public String getIncidentDescription() { return incidentDescription; }
    public void setIncidentDescription(String incidentDescription) { this.incidentDescription = incidentDescription; }

    public String getAuditFindings() { return auditFindings; }
    public void setAuditFindings(String auditFindings) { this.auditFindings = auditFindings; }

    public String getViolationDetails() { return violationDetails; }
    public void setViolationDetails(String violationDetails) { this.violationDetails = violationDetails; }

    public Organization getSenderOrganization() { return senderOrganization; }
    public Organization getReceiverOrganization() { return receiverOrganization; }

    public String getSenderName() { return senderName; }
    public void setSenderName(String senderName) { this.senderName = senderName; }

    public String getReceiverName() { return receiverName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }

    @Override
    public String toString() {
        return "Incident: " + incidentType + " [" + getStatus() + "]";
    }
}

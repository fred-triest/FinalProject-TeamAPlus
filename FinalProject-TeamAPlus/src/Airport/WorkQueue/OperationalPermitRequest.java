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
public class OperationalPermitRequest extends WorkRequest {

    private String permitType; // New Route, Off-Hours Operation, New Aircraft Type
    private String routeDetails;
    private String justification;
    private String complianceNotes;
    private String conditions; // conditions for conditional approval
    private String denialReason;

    private Organization senderOrganization;
    private Organization receiverOrganization;
    private String senderName;
    private String receiverName;

    public OperationalPermitRequest(String permitType, String routeDetails, String justification,
            Organization senderOrg, Organization receiverOrg, String senderName) {

        super();
        this.permitType = permitType;
        this.routeDetails = routeDetails;
        this.justification = justification;
        this.senderOrganization = senderOrg;
        this.receiverOrganization = receiverOrg;
        this.senderName = senderName;
        this.receiverName = "";
        this.complianceNotes = "";
        this.conditions = "";
        this.denialReason = "";

        setStatus("Submitted");
        setDescription(permitType + " permit request: " + routeDetails);
    }

    public boolean canTransitionTo(String newStatus) {
        String current = getStatus();
        switch (current) {
            case "Submitted":
                return newStatus.equals("Under Review");
            case "Under Review":
                return newStatus.equals("Approved") || newStatus.equals("Conditionally Approved") || newStatus.equals("Denied");
            case "Approved":
            case "Conditionally Approved":
            case "Denied":
                return false;
            default:
                return false;
        }
    }

    public String getPermitType() { return permitType; }
    public void setPermitType(String permitType) { this.permitType = permitType; }

    public String getRouteDetails() { return routeDetails; }
    public void setRouteDetails(String routeDetails) { this.routeDetails = routeDetails; }

    public String getJustification() { return justification; }
    public void setJustification(String justification) { this.justification = justification; }

    public String getComplianceNotes() { return complianceNotes; }
    public void setComplianceNotes(String complianceNotes) { this.complianceNotes = complianceNotes; }

    public String getConditions() { return conditions; }
    public void setConditions(String conditions) { this.conditions = conditions; }

    public String getDenialReason() { return denialReason; }
    public void setDenialReason(String denialReason) { this.denialReason = denialReason; }

    public Organization getSenderOrganization() { return senderOrganization; }
    public Organization getReceiverOrganization() { return receiverOrganization; }

    public String getSenderName() { return senderName; }
    public void setSenderName(String senderName) { this.senderName = senderName; }

    public String getReceiverName() { return receiverName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }

    @Override
    public String toString() {
        return "Permit: " + permitType + " [" + getStatus() + "]";
    }
}

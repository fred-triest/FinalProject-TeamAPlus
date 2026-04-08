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
// When a passenger is affected by cancellation/delay/overbooking, this gets sent up for authorization
public class PassengerDisruptionRequest extends WorkRequest {

    private String disruptionType;
    private String flightNumber;
    private int affectedPassengers;
    private String requestedAction;
    private double estimatedCost;
    private String passengerDetails;
    private String authorizationNotes;
    private String denialReason;

    private Organization senderOrganization;
    private Organization receiverOrganization;
    private String senderName;
    private String receiverName;

    public PassengerDisruptionRequest(String disruptionType, String flightNumber,
            int affectedPassengers, String requestedAction, double estimatedCost,
            String passengerDetails, Organization senderOrg, Organization receiverOrg,
            String senderName) {

        super();
        this.disruptionType = disruptionType;
        this.flightNumber = flightNumber;
        this.affectedPassengers = affectedPassengers;
        this.requestedAction = requestedAction;
        this.estimatedCost = estimatedCost;
        this.passengerDetails = passengerDetails;
        this.senderOrganization = senderOrg;
        this.receiverOrganization = receiverOrg;
        this.senderName = senderName;
        receiverName = "";
        authorizationNotes = "";
        denialReason = "";

        setStatus("Escalated");
        setDescription(disruptionType + " disruption on " + flightNumber + " - " + affectedPassengers + " passengers affected");
    }

    public boolean canTransitionTo(String newStatus) {
        String current = getStatus();
        switch (current) {
            case "Escalated":
                return newStatus.equals("Under Review");
            case "Under Review":
                return newStatus.equals("Authorized") || newStatus.equals("Denied");
            case "Authorized":
            case "Denied":
                return newStatus.equals("Resolved");
            default:
                return false;
        }
    }

    public String getDisruptionType() { return disruptionType; }
    public void setDisruptionType(String disruptionType) { this.disruptionType = disruptionType; }
    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public int getAffectedPassengers() { return affectedPassengers; }
    public void setAffectedPassengers(int affectedPassengers) { this.affectedPassengers = affectedPassengers; }

    public String getRequestedAction() { return requestedAction; }
    public void setRequestedAction(String requestedAction) { this.requestedAction = requestedAction; }
    public double getEstimatedCost() { return estimatedCost; }
    public void setEstimatedCost(double estimatedCost) { this.estimatedCost = estimatedCost; }

    public String getPassengerDetails() { return passengerDetails; }
    public void setPassengerDetails(String passengerDetails) { this.passengerDetails = passengerDetails; }

    public String getAuthorizationNotes() { return authorizationNotes; }
    public void setAuthorizationNotes(String authorizationNotes) { this.authorizationNotes = authorizationNotes; }

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
        return disruptionType + " on " + flightNumber + " (" + affectedPassengers + " pax)";
    }
}

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
public class BaggageIrregularityReport extends WorkRequest {

    private String irregularityType; // Lost, Damaged, Misrouted
    private String baggageTagId;
    private String flightNumber;
    private String passengerName;
    private String lastKnownLocation;
    private String resolution;
    private boolean escalatedToAirline;

    private Organization senderOrganization;
    private Organization receiverOrganization;
    private String senderName;
    private String receiverName;

    public BaggageIrregularityReport(String irregularityType, String baggageTagId,
            String flightNumber, String passengerName, String lastKnownLocation,
            Organization senderOrg, Organization receiverOrg, String senderName) {

        super();
        this.irregularityType = irregularityType;
        this.baggageTagId = baggageTagId;
        this.flightNumber = flightNumber;
        this.passengerName = passengerName;
        this.lastKnownLocation = lastKnownLocation;
        this.senderOrganization = senderOrg;
        this.receiverOrganization = receiverOrg;
        this.senderName = senderName;
        this.receiverName = "";
        this.resolution = "";
        this.escalatedToAirline = false;

        setStatus("Filed");
        setDescription(irregularityType + " baggage report for " + passengerName + " on " + flightNumber);
    }

    public boolean canTransitionTo(String newStatus) {
        String current = getStatus();
        switch (current) {
            case "Filed":
                return newStatus.equals("Under Investigation");
            case "Under Investigation":
                return newStatus.equals("Escalated") || newStatus.equals("Resolved");
            case "Escalated":
                return newStatus.equals("Resolved");
            case "Resolved":
                return false;
            default:
                return false;
        }
    }

    public String getIrregularityType() { return irregularityType; }
    public void setIrregularityType(String irregularityType) { this.irregularityType = irregularityType; }

    public String getBaggageTagId() { return baggageTagId; }
    public void setBaggageTagId(String baggageTagId) { this.baggageTagId = baggageTagId; }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }

    public String getLastKnownLocation() { return lastKnownLocation; }
    public void setLastKnownLocation(String lastKnownLocation) { this.lastKnownLocation = lastKnownLocation; }

    public String getResolution() { return resolution; }
    public void setResolution(String resolution) { this.resolution = resolution; }

    public boolean isEscalatedToAirline() { return escalatedToAirline; }
    public void setEscalatedToAirline(boolean escalatedToAirline) { this.escalatedToAirline = escalatedToAirline; }

    public Organization getSenderOrganization() { return senderOrganization; }
    public Organization getReceiverOrganization() { return receiverOrganization; }

    public String getSenderName() { return senderName; }
    public void setSenderName(String senderName) { this.senderName = senderName; }

    public String getReceiverName() { return receiverName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }

    @Override
    public String toString() {
        return "Baggage: " + irregularityType + " - " + baggageTagId + " [" + getStatus() + "]";
    }
}

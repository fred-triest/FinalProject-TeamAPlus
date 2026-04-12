# Airport Operations Management System

## Problem Statement

International airport operations have crucial needs in order to coordinate across multiple independent enterprises, each with unique responsibilities and employees. If an integrated platform is missing, communication between airlines, airport authorities, and ground service providers is fragmented. This leads to delayed gate assignments, missed ground handling windows, and passenger disruptions that are unresolved.

This project offers a digital ecosystem platform for JFK International Airport that connects three enterprises: Japan Airlines, New York Port Authority, and GroundMaster Services. The ecosystem has been carefully designed and built on a unified, role-based communication and work request system. This platform enables cross-enterprise coordination that no single enterprise can achieve alone and delivers value greater than the sum of its parts.

These enterprises are dependent on each other because Japan Airlines has the aircraft and passengers, but no airport infrastructure and ground workers. The New York Port Authority owns and operates the infrastructure but has no airlines to utilize it. GroundMaster Services has the workforce but no direction without flight schedules and gate assignments. No matter the flight, every departure depends on all three of these entities working in smooth coordination. One missed handoff or conflict turns into delays, missed connections, and passenger disruptions.

---

## Team Contributions

**Person 1 (Fred Triest)**
- Create class hierarchy, role-based authentication, System Admin and Enterprise Admin CRUD panels, ConfigureASystem with pre-populated test data, high-level diagram, project proposal.

**Person 2 (Cohen Powell)**
- Work request engine with all 6 request types and status transitions, cross-enterprise and cross-organization routing, work area UI panels for all 8 operational roles. Presentation slides.

**Person 3 (Larry Tsao)**
- Faker data integration, reporting module with analytics and summaries, UML diagram.

---

## The Enterprises

### Japan Airlines
The main carrier operating out of JFK. JAL manages flight schedules, passenger services, and coordinates with the port authority on gate assignments and operational permits. JAL cannot function without the infrastructure and ground services the other enterprises offer.

### New York Port Authority
The governing body that owns and operates JFK airport. This enterprise allocates gates, issues operational permits, manages the capacity of terminals, and enforces safety and compliance standards. No airplane takes off without the port authority's authorization. The port authority is the central coordinator of the entire platform.

### GroundMaster Services
The private company that is a contractor responsible for servicing the airplanes between flights. This enterprise refuels planes, loads baggage, cleans cabins, and operates all ramp operations. Every aircraft turnaround depends on GroundMaster. If this enterprise was not here, no aircraft is ready for its next departure regardless of how well the gate is assigned or the permit is issued.

---

## Organizations

| Enterprise | Organization | Description |
|---|---|---|
| Japan Airlines | Flight Operations Division | Manages flight scheduling and operational activities |
| Japan Airlines | Passenger Services Department | Manages check-in, boarding, and passenger complaints |
| New York Port Authority | Gate & Terminal Management Office | Allocates gates and manages terminal capacity |
| New York Port Authority | Safety & Compliance Bureau | Performs safety inspections and issues permits |
| GroundMaster Services | Ramp & Refueling Unit | Manages ramp crews and aircraft refueling |
| GroundMaster Services | Baggage & Cabin Services Unit | Handles baggage loading and cabin turnaround |

---

## Roles

| Role | Enterprise | Organization |
|---|---|---|
| Flight Scheduler | Japan Airlines | Flight Operations Division |
| Operations Manager | Japan Airlines | Flight Operations Division |
| Passenger Services Agent | Japan Airlines | Passenger Services Department |
| Gate Coordinator | New York Port Authority | Gate & Terminal Management Office |
| Safety Inspector | New York Port Authority | Safety & Compliance Bureau |
| Compliance Officer | New York Port Authority | Safety & Compliance Bureau |
| Ramp Supervisor | GroundMaster Services | Ramp & Refueling Unit |
| Baggage Handler | GroundMaster Services | Baggage & Cabin Services Unit |
| System Admin | Platform | EcoSystem Level |
| Enterprise Admin | Platform | Enterprise Level |

---

## Work Requests

| Request Type | Sender | Receiver | Scope | Statuses |
|---|---|---|---|---|
| Gate Assignment Request | Flight Scheduler | Gate Coordinator | Cross-enterprise | Submitted → Under Review → Assigned/Conflict Flagged → Confirmed |
| Ground Handling Request | Flight Scheduler | Ramp Supervisor | Cross-enterprise | Dispatched → Crew Assigned → In Progress → Completed |
| Operational Permit Request | Operations Manager | Safety Inspector | Cross-enterprise | Submitted → Under Review → Approved/Conditionally Approved/Denied |
| Baggage Irregularity Report | Baggage Handler | Ramp Supervisor | Cross-org (GroundMaster) | Filed → Under Investigation → Escalated/Resolved |
| Incident Report & Safety Audit | Safety Inspector | Compliance Officer | Cross-org (NYPA) | Reported → Under Review → Audit Initiated/Closed/Violation Issued |
| Passenger Disruption Request | Passenger Services Agent | Operations Manager | Cross-org (JAL) | Escalated → Under Review → Authorized/Denied → Resolved |

---

## Key Architectural Decisions

- **Singleton Pattern** — AirportEcoSystem is implemented as a Singleton ensuring only one instance of the ecosystem exists at runtime, preventing duplicate data and authentication conflicts.
- **Abstract Class Hierarchy** — Role and Organization are abstract classes, enforcing that every subclass implements `createWorkArea()` and `getSupportedRole()` respectively.
- **Role-based Authentication** — Login searches user accounts across three levels of the hierarchy (ecosystem, enterprise, organization). Passwords are hashed using SHA-256 and validated against strength requirements (minimum 8 characters, one uppercase letter, one digit, one special character). Passwords are never stored in plain text.
- **CardLayout Navigation** — Work area panels are managed with a single JFrame using CardLayout, which provides a single-window experience with named card routing based on the user's role.
- **Encapsulation and Validation** — All fields are private with validated setters. Email addresses are validated against a regular expression pattern. Age is validated against legal employment bounds of 16 to 100.
- **Unique ID Generation** — Every Employee, UserAccount, Organization, Enterprise, and Network receives an auto-generated ID using a static counter shared across all instances of each class.

---

## Test Users

| Username | Password | Role |
|---|---|---|
| sysadmin | sysAdmin1& | System Admin |
| jaladmin | jalAdmin1& | Enterprise Admin (Japan Airlines) |
| nypaadmin | nypaAdmin1& | Enterprise Admin (NY Port Authority) |
| groundadmin | groundAdmin1& | Enterprise Admin (GroundMaster) |
| flightScheduler | flightScheduler1& | Flight Scheduler |
| operationsManager | operationsManager1& | Operations Manager |
| passengerAgent | passengerAgent1& | Passenger Services Agent |
| gateCoordinator | gateCoordinator1& | Gate Coordinator |
| safetyInspector | safetyInspector1& | Safety Inspector |
| complianceOfficer | complianceOfficer1& | Compliance Officer |
| rampSupervisor | rampSupervisor1& | Ramp Supervisor |
| baggageHandler | baggageHandler1& | Baggage Handler |

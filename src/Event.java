import java.time.LocalDate;
import java.util.ArrayList;
public class Event {
    private String eventID;
    private String eventName;
    private LocalDate eventDate;
    private String eventVenue;
    private ArrayList<String> eventAttendees;

    public Event(String eventID, String eventName, String eventVenue, LocalDate eventDate) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.eventDate = eventDate;
        this.eventAttendees = new ArrayList<>();
    }

    public void addAttendee(String attendeeName) {
        eventAttendees.add( attendeeName );
    }

    public void removeAttendee(String attendeeName) {
        eventAttendees.remove( attendeeName );
    }

    public void updateAttendee(String oldName, String newName) {
        int index = eventAttendees.indexOf(oldName);
        if (index != -1) {
            eventAttendees.set(index, newName);
        }
    }

    public String findAttendee(String attendeeName) {
        int index = eventAttendees.indexOf(attendeeName);
        if (index != -1) {
            return eventAttendees.get(index);
        }
        return null;
    }

    public int getTotalAttendees() {
        return eventAttendees.size();
    }

    // Getters and Setters
    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public ArrayList<String> getEventAttendees() {
        return eventAttendees;
    }

    public void setEventAttendees(ArrayList<String> eventAttendees) {
        this.eventAttendees = eventAttendees;
    }

    @Override
    public String toString() {
    return "Event ID: " + eventID + "\nEvent Name: " + eventName + "\nEvent Venue: " + eventVenue + "\nEvent Date: " + eventDate + "\nAttendees: " + eventAttendees + "\nTotal Attendees: " +  getTotalAttendees();
    }
}

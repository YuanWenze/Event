    import java.time.LocalDate;
    import java.util.Scanner;
    public class Main{
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

        System.out.print("Enter event ID: ");
        String eventID = scanner.nextLine();

        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine();

        System.out.print("Enter event venue: ");
        String eventVenue = scanner.nextLine();

        System.out.print("Enter event date (yyyy-MM-dd): ");
        String eventDateString = scanner.nextLine();
        LocalDate eventDate = LocalDate.parse(eventDateString);

        Event event = new Event(eventID, eventName, eventVenue, eventDate);
    //Add
        System.out.println("enter the names of the attendees (enter 'done' to finish):");
        String input;
        while (!(input = scanner.nextLine()).equalsIgnoreCase("done")) 
        {
            event.addAttendee(input);
        }
    // Display event details
        System.out.println(event);
    // Perform operations
        System.out.println("Available operations: add, remove, update, find, total");
        System.out.print("Enter an operation: ");
        String operation = scanner.nextLine();

        switch (operation) {
            case "remove":
                System.out.print("Enter the name of the attendee to remove: ");
                String attendeeToRemove = scanner.nextLine();
                event.removeAttendee(attendeeToRemove);
                System.out.println("Attendee removed successfully!");
                break;
            case "add":
                System.out.print("Enter the name of the attendee to add: ");
                String newAttendee = scanner.nextLine();
                event.addAttendee(newAttendee);
                System.out.println("Attendee added successfully!");
                break;
            case "update":
                System.out.print("Enter the old name of the attendee: ");
                String oldAttendee = scanner.nextLine();
                System.out.print("Enter the new name of the attendee: ");
                String newAttendeeName = scanner.nextLine();
                event.updateAttendee(oldAttendee, newAttendeeName);
                System.out.println("Attendee updated successfully!");
                break;
            case "find":
                System.out.print("Enter the name of the attendee to find: ");
                String attendeeToFind = scanner.nextLine();
                String foundAttendee = event.findAttendee(attendeeToFind);
                if (foundAttendee != null) {
                    System.out.println("Attendee found: " + foundAttendee);
                } else {
                    System.out.println("Attendee not found!");
                }
                break;
            case "total":
                System.out.println("Total number of attendees: " + event.getTotalAttendees());
                break;
            default:
                System.out.println("Invalid operation!");
        }

        // Display event details again
        System.out.println(event);

        scanner.close();
    }






}
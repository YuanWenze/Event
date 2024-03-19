import java.time.LocalDate;
import java.util.*;
public class Event {

    Scanner reader = new Scanner(System.in);
    public final static int capacity = 200;
    HashMap<String, Attendee> seatDetails = new HashMap<>(capacity, 0.6f);
    private String eventID;
    private String eventName;
    private String eventVenue;
    private LocalDate eventDate; 
    ArrayList<Attendee> eventAttendees = new ArrayList<>();

    public Event(){}

    public void setSeatDetails(String seatNumber, Attendee attendee) {
        seatDetails.put(seatNumber, attendee);
    }

    public Attendee getSeatDetails(String seatNumber) {
        return seatDetails.get(seatNumber);
    }
    
    public void setEventID(String id){
        eventID = id;
    }
    
    public String getEventID(){
        return eventID;
    }

    public void setEventName(String name) {
        eventName = name;
    }
    
    public String getEventName() {
        return eventName;
    }
    
    public void setEventDate(LocalDate date) {
        eventDate = date;
    } 

    public LocalDate getEventDate() {
        return eventDate;
    }
    
    public void setEventVenue(String venue) {
        eventVenue = venue;
    }
    
    public String getEventVenue() {
        return eventVenue;
     }

    public void organizeEvent(int choice){

    switch(choice){
        case 1:
        System.out.println("Enter the Event ID :");
        String id = reader.nextLine();
        setEventID(id);

        System.out.println("Enter the name of the Event: ");
        String eventName =reader.nextLine();
        setEventName(eventName);

        System.out.println("Enter the Event date (YYYY-MM-DD):");
        LocalDate date = LocalDate.parse(reader.nextLine());
        setEventDate(date);

        System.out.println("Enter the event's venue: ");
        String venue =reader.nextLine();
        setEventVenue(venue);
        break;

    case 2:
        System.out.println("How many attendees are coming? :");
        int num = reader.nextInt();
        reader.nextLine();

        for(int i=0; i<num; i++) {
        System.out.println("Enter the name of the attendee: ");
        String name = reader.nextLine();

        System.out.println("Enter the gender of the attendee: ");
        char gender = reader.nextLine().charAt(0);

        System.out.println("Enter the age of the attendee: ");
        int age = reader.nextInt();
        reader.nextLine();

        System.out.println("Enter the email of the attendee: ");
        String email = reader.nextLine();

        System.out.println("Enter the seat number of the attendee: ");
        String seat = reader.nextLine();

       
        Attendee attendee = new Attendee(name, gender, email, age, seat);
        eventAttendees.add(attendee);
        setSeatDetails(seat, attendee);
        }
        System.out.println("\n"+"All attendees are added.");
        break;
       
    case 3:
       System.out.println("Enter the name of the Attendee to remove: ");
       String nameToRemove = reader.nextLine();
       for(Attendee attendee : eventAttendees) {
          if(nameToRemove.equals(attendee.getName())){
              eventAttendees.remove(attendee);
              seatDetails.remove(attendee.getSeatNo());
              break;
          }
       }
       eventAttendees.removeIf(attendee->attendee.getName().equals(nameToRemove));
       System.out.println("\n"+ nameToRemove +"is removed.");
       break;
    case 4:
        System.out.println("Enter the name of the attendee you want to update: ");
        String nameToUpdate = reader.nextLine();
        for(Attendee attendee : eventAttendees) {
            if(nameToUpdate.equals(attendee.getName())){
               System.out.println("Enter the new name, or enter null if you don' want to update : ");
               String newName = reader.nextLine();
            if(!newName.equals("null")){
                    attendee.setName(newName);
                }
                 
        System.out.println("Enter the new gender, or enter null if you don't want to update :");
        String newGender = reader.nextLine();
            if(!newGender.equals("null")){
               attendee.setGender(newGender.charAt(0));
              }

        System.out.println("Enter the new age, or enter null if you don't want to update :");
        int newAge = reader.nextInt();
        reader.nextLine();
            if(newAge != 0){
               attendee.setAge(newAge);
              }
        System.out.println("Enter the new email, or enter null if you don't want to update :");
        String newEmail = reader.nextLine();
            if(!newEmail.equals("null")){
               attendee.setEmail(newEmail);
              }
            seatDetails.put(attendee.getSeatNo(), attendee);
            System.out.println("Attendee details updated.");
            break;
              } else {
            System.out.println("\nInvalid position. No update performed.");
            break;
        }

    }
    break;
    case 5:
        System.out.println("Enter the name of the attendee to find: ");
        String nameToFind = reader.nextLine();
            for(Attendee attendee : eventAttendees) {

                if(attendee.getName().equals(nameToFind)){
                    System.out.println(attendee);
                    System.out.println(nameToFind + " is found in the list of attendees") ;
                    break;
                } else {
                    System.out.println("\n Sorry,it didn't found");
                    break;
                }
            }
         break;

    case 6:
        System.out.println("Here is the list of attendees: " + "\n" + eventAttendees );
        break;

    case 7:
        HandleComplementaryPasses compPass = new HandleComplementaryPasses();
        compPass.handleComplementaryPasses();
        break;
    case 8:
        HandlePerformances performance = new HandlePerformances();
        performance.handlePerformances();
        break;
    case 9:
        System.out.println("Enter the seat number to find the details:");
        String seat = reader.nextLine();
        getSeatDetails(seat);
        break;
     case 10:
        break;
        default:
        System.out.println("Invalid choice");
      }
    }
}
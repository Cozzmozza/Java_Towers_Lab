import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {

    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<Booking> bedroomBookings;
    private HashMap<String, DiningRoom> diningRooms;
    private ArrayList<Bedroom> vacantBedrooms;

    public Hotel(String name, ArrayList<Bedroom> bedrooms, ArrayList<ConferenceRoom> conferenceRooms) {
    this.name = name;
    this.bedrooms = bedrooms;
    this.conferenceRooms = conferenceRooms;
    this.bedroomBookings = new ArrayList<>();
    this.diningRooms = new HashMap<>();
    this.vacantBedrooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCountBedrooms(){
        return bedrooms.size();
    }

    public int getCountConferenceRooms(){
        return conferenceRooms.size();
    }

    public void checkInGuest(Guest guest, Room room) {
//        First do the check for all the current vacant rooms
        setVacantBedrooms();
//        If the room is listed in the vacantBedrooms ArrayList, we can safely add a new guest to it
        if (vacantBedrooms.contains(room)){
            room.addGuestToRoom(guest);
        }
    }

    public void checkOutGuest(Guest guest, Room room) {
        ArrayList<Guest> guests = room.getAllGuests();
        if (guests.contains(guest)){
            room.removeGuestFromRoom(guest);
        }
    }

    public Booking bookRoom(int nightsBooked, Bedroom bedroom){
        Booking booking = new Booking(nightsBooked, bedroom);
        addBookingToBookings(booking);
        return booking;
    }

    public int getBookingsCount(){
        return bedroomBookings.size();
    }

    public void addBookingToBookings(Booking booking){
        bedroomBookings.add(booking);
    }

    public double getBill(Booking booking) {
        double bill = booking.getTotalCost();
        return bill;
    }

    public int getDiningRoomCount() {
        return diningRooms.size();
    }

    public void addDiningRoom(DiningRoom diningRoom) {
        diningRooms.put(diningRoom.getName(), diningRoom);
    }

    public int getCountVacantBedrooms() {
//       Can either do an ArrayList that returns the bedrooms
//        Or do a hashmap that returns the bedrooms, and another property e.g. roomType value, or capacity
//        Going to go with the arraylist
        return vacantBedrooms.size();
    }

    public void setVacantBedrooms(){
        vacantBedrooms.clear();
//        For type Bedroom, object bedroom, in bedrooms ArrayList
//          if bedroom.getGetCount() = 0
//                add bedroom to vacantBedrooms
        for(Bedroom bedroom : bedrooms) {
            if (bedroom.getGuestCount() == 0) {
                vacantBedrooms.add(bedroom);
            }
        }
    }

    public ArrayList getVacantBedrooms(){
        return vacantBedrooms;
    }
}

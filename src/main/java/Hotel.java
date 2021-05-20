import java.util.ArrayList;

public class Hotel {

    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;

    public Hotel(String name, ArrayList<Bedroom> bedrooms, ArrayList<ConferenceRoom> conferenceRooms) {
    this.name = name;
    this.bedrooms = bedrooms;
    this.conferenceRooms = conferenceRooms;
    }


    // GETTERS
    public String getName() {
        return name;
    }

//    public ArrayList<Bedroom> getBedrooms() {
//        return bedrooms;
//    }
//
//    public ArrayList<ConferenceRoom> getConferenceRooms() {
//        return conferenceRooms;
//    }

    public int getCountBedrooms(){
        return bedrooms.size();
    }

    public int getCountConferenceRooms(){
        return conferenceRooms.size();
    }

    public void checkInGuest(Guest guest, Room room) {
//        Do some check on the remaining room capacity
//        if there is space left, check in the guest
//        call the rooms addGuestToRoom fn
        int capacityCheck = room.getRemainingCapacity();
        if (capacityCheck >= 1){
            room.addGuestToRoom(guest);
        }
    }


    public void checkOutGuest(Guest guest, Room room) {
        ArrayList<Guest> guests = room.getAllGuests();
        if (guests.contains(guest)){
            room.removeGuestFromRoom(guest);
        }
    }
}

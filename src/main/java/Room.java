import java.util.ArrayList;

public abstract class Room {
//    Abstract class, has a capacity and a collection of Guests

    private int capacity;
    private ArrayList<Guest> guests;

    public Room(int capacity) {
        this.capacity = capacity;
        this.guests = new ArrayList<Guest>();
    }


//    Add a new guest to a room
    public void addGuestToRoom(Guest guest){
        guests.add(guest);
    }


//    Remove a guest from a room
    public void removeGuestFromRoom(Guest guest){
        guests.remove(guest);
    }


//    GETTERS
    public int getCapacity() {
        return capacity;
    }

    public int getGuestCount() {
        return guests.size();
    }
}

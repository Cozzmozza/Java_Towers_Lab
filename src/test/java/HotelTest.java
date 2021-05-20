import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    Hotel hotel;
    Bedroom bedroom1;
    Bedroom bedroom2;
    ConferenceRoom conferenceRoom1;
    Guest guest1;
    Guest guest2;
    Guest guest3;
    Booking booking1;
    DiningRoom diningRoom1;

    @Before
    public void before(){
//        Making some guests
        guest1 = new Guest("Bob");
        guest2 = new Guest("Sal");
        guest3 = new Guest("Shirley");

        // Making an array of bedrooms to go into Hotel
        ArrayList<Bedroom> bedrooms;
        bedroom1 = new Bedroom(10, RoomType.DOUBLE);
        bedroom2 = new Bedroom(5, RoomType.TWIN);
        bedrooms = new ArrayList<>();
        bedrooms.add(bedroom1);
        bedrooms.add(bedroom2);

        // Making an array of conferenceRooms to go into Hotel
        ArrayList<ConferenceRoom> conferenceRooms;
        conferenceRoom1 = new ConferenceRoom(10, "Cawdor");
        conferenceRooms = new ArrayList<>();
        conferenceRooms.add(conferenceRoom1);

        booking1 = new Booking(4, bedroom1);
        diningRoom1 = new DiningRoom(5, "Main");

        hotel = new Hotel("JavaTowers", bedrooms, conferenceRooms);
    }

    @Test
    public void canGetName(){
        assertEquals("JavaTowers", hotel.getName());
    }

    @Test
    public void canGetBedroomCount(){
        assertEquals(2, hotel.getCountBedrooms());
    }

    @Test
    public void canGetConferenceRoomsCount() {
        assertEquals(1, hotel.getCountConferenceRooms());
    }

    @Test
    public void canCheckInGuestToVacantBedroom(){
        hotel.checkInGuest(guest1, bedroom1);
        assertEquals(1, bedroom1.getGuestCount());
    }

    @Test
    public void cannotCheckInGuestToNonVacantBedroom(){
        hotel.checkInGuest(guest1, bedroom1);
        hotel.checkInGuest(guest2, bedroom1);
        assertEquals(1, bedroom1.getGuestCount());
    }

    @Test
    public void canCheckInGuestToConferenceRoom(){
        hotel.checkInGuest(guest1, conferenceRoom1);
        hotel.checkInGuest(guest2, conferenceRoom1);
        hotel.checkInGuest(guest3, conferenceRoom1);
        assertEquals(3, conferenceRoom1.getGuestCount());
    }

    @Test
    public void canCheckOutGuestFromRoom(){
        hotel.checkInGuest(guest1, bedroom1);
        hotel.checkOutGuest(guest1, bedroom1);
        assertEquals(0, bedroom1.getGuestCount());
    }

    @Test
    public void canCheckOutGuestFromConferenceRoom(){
        hotel.checkInGuest(guest1, conferenceRoom1);
        hotel.checkInGuest(guest2, conferenceRoom1);
        hotel.checkOutGuest(guest1, conferenceRoom1);
        hotel.checkOutGuest(guest2, conferenceRoom1);
        assertEquals(0, conferenceRoom1.getGuestCount());
    }

    @Test
    public void cannotCheckOutGuestThatDoesntExistInRoom(){
        hotel.checkInGuest(guest1, bedroom1);
        hotel.checkOutGuest(guest2, bedroom1);
        assertEquals(1, bedroom1.getGuestCount());
    }

    @Test
    public void canGetBookingsCount(){
        assertEquals(0, hotel.getBookingsCount());
    }

    @Test
    public void canAddBookingToBookings(){
        hotel.addBookingToBookings(booking1);
        assertEquals(1, hotel.getBookingsCount());
    }

    @Test
    public void canAddBookingUsingBookRoomMethod(){
        hotel.bookRoom(4, bedroom1);
        assertEquals(1, hotel.getBookingsCount());
    }

    @Test
    public void hotelCanReturnBill(){
        assertEquals(200.00, hotel.getBill(booking1), 0.005);
    }

    @Test
    public void hotelCanGetCountOfDiningRoomsInHashMap(){
        assertEquals(0, hotel.getDiningRoomCount());
    }

    @Test
    public void canAddDiningRoomToHashMap(){
        hotel.addDiningRoom(diningRoom1);
        assertEquals(1, hotel.getDiningRoomCount());
    }

    @Test
    public void canGetCountOfVacantBedrooms(){
        assertEquals(0, hotel.getCountVacantBedrooms());
    }

    @Test
    public void canReturnVacantBedrooms(){
//        Add a guest to bedroom 1
        hotel.checkInGuest(guest1, bedroom1);
//        Initialise the vacant bedrooms , our "check for vacant rooms"
        hotel.setVacantBedrooms();
//        We then want to check that bedroom 2 is returned, when we check our vacant Bedrooms function
        assertEquals(1, hotel.getCountVacantBedrooms());
    }

    @Test
    public void willNotReturnNonVacantBedrooms(){
//        Calling it first time will set vacant bedrooms to bedroom1, and bedroom 2
        hotel.setVacantBedrooms();
//        Then adding a guest to bedroom 1
        hotel.checkInGuest(guest1, bedroom1);
//        Re-running to make sure it then removes any non-vacants from the list, with the clear() method
        hotel.setVacantBedrooms();
        assertEquals(1, hotel.getCountVacantBedrooms());
    }

    @Test
    public void canGetVacantBedroomsArrayList(){
        hotel.checkInGuest(guest1, bedroom1);
        hotel.setVacantBedrooms();
        ArrayList<Bedroom> testList = new ArrayList<>();
        testList.add(bedroom2);
        assertEquals(testList, hotel.getVacantBedrooms());
    }
}

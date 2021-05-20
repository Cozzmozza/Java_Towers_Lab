import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    Hotel hotel;
    Bedroom bedroom1;
    ConferenceRoom conferenceRoom1;
    Guest guest1;
    Guest guest2;
    Guest guest3;

    @Before
    public void before(){
//        Making some guests
        guest1 = new Guest("Bob");
        guest2 = new Guest("Sal");
        guest3 = new Guest("Shirley");

        // Making an array of bedrooms to go into Hotel
        ArrayList<Bedroom> bedrooms;
        bedroom1 = new Bedroom(10, RoomType.DOUBLE);
        bedrooms = new ArrayList<>();
        bedrooms.add(bedroom1);

        // Making an array of conferenceRooms to go into Hotel
        ArrayList<ConferenceRoom> conferenceRooms;
        conferenceRoom1 = new ConferenceRoom(10, "Cawdor");
        conferenceRooms = new ArrayList<>();
        conferenceRooms.add(conferenceRoom1);

        hotel = new Hotel("JavaTowers", bedrooms, conferenceRooms);
    }

    @Test
    public void canGetName(){
        assertEquals("JavaTowers", hotel.getName());
    }

    @Test
    public void canGetBedroomCount(){
        assertEquals(1, hotel.getCountBedrooms());
    }

    @Test
    public void canGetConferenceRoomsCount() {
        assertEquals(1, hotel.getCountConferenceRooms());
    }

    @Test
    public void canCheckInGuestToBedroom(){
        hotel.checkInGuest(guest1, bedroom1);
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
        Booking booking = new Booking(4, bedroom1);
        hotel.addBookingToBookings(booking);
        assertEquals(1, hotel.getBookingsCount());
    }

    @Test
    public void canAddBookingUsingBookRoomMethod(){
        hotel.bookRoom(4, bedroom1);
        assertEquals(1, hotel.getBookingsCount());

    }
}

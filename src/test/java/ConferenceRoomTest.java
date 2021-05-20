import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom;
    Guest guest;

    @Before
    public void before() {
        conferenceRoom = new ConferenceRoom(40, "Cawdor");
        guest = new Guest("Bob");
    }

    @Test
    public void hasCapacity() {
        assertEquals(40, conferenceRoom.getCapacity());
    }

    @Test
    public void hasName() {
        assertEquals("Cawdor", conferenceRoom.getName());
    }

    @Test
    public void hasGuests() {
        assertEquals(0, conferenceRoom.getGuestCount());
    }

    @Test
    public void canAddGuestToConferenceRoom() {
        conferenceRoom.addGuestToRoom(guest);
//        assertEquals("Bob", conferenceRoom.getGuests());
        assertEquals(1, conferenceRoom.getGuestCount());
    }

}

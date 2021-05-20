import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom;
    Guest guest;
    ArrayList <Guest> guests;;

    @Before

    public void before() {
        conferenceRoom = new ConferenceRoom(40, guests, "Cawdor");
        guest = new Guest("Bob");
    }

    @Test
    public void canAddGuestToConferenceRoom() {
        conferenceRoom.addGuestToRoom(guest);
        assertEquals(1, conferenceRoom.getGuestCount());
    }
}

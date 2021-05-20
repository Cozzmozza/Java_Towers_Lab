import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom;
    Guest guest;

    @Before
    public void before() {bedroom = new Bedroom(10, RoomType.SINGLE);
    guest = new Guest("Bob");
    }

    @Test
    public void canGetCapacity() {
        assertEquals(1, bedroom.getCapacity());
    }

    @Test
    public void canGetPrice(){
        assertEquals(35.00, bedroom.getRoomPrice(), 0.005);
    }

    @Test
    public void hasRoomNumber() {
        assertEquals(10, bedroom.getRoomNumber());
    }

    @Test
    public void canAddGuestToRoom() {
        bedroom.addGuestToRoom(guest);
        assertEquals(1, bedroom.getGuestCount());
    }

    @Test
    public void canRemoveGuestFromRoom() {
        bedroom.addGuestToRoom(guest);
        bedroom.addGuestToRoom(guest);
        bedroom.removeGuestFromRoom(guest);
        assertEquals(1, bedroom.getGuestCount());
    }

    @Test
    public void testRoomType(){
        assertEquals(RoomType.SINGLE, bedroom.getRoomType());
    }
}

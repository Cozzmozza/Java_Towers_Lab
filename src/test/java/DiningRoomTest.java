import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    DiningRoom diningRoom;
    Guest guest1;

    @Before
    public void before(){
        diningRoom = new DiningRoom(5, "Main");
        guest1 = new Guest("Bob");
    }

    @Test
    public void canGetCapacity(){
        assertEquals(5, diningRoom.getCapacity());
    }

    @Test
    public void canGetGuestCount(){
        assertEquals(0, diningRoom.getGuestCount());
    }

    @Test
    public void canAddGuest(){
        diningRoom.addGuestToRoom(guest1);
        assertEquals(1, diningRoom.getGuestCount());
    }

    @Test
    public void canRemoveGuest(){
        diningRoom.addGuestToRoom(guest1);
        diningRoom.removeGuestFromRoom(guest1);
        assertEquals(0, diningRoom.getGuestCount());
    }

    @Test
    public void canGetName(){
        assertEquals("Main", diningRoom.getName());
    }
}

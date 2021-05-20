import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    Booking booking;
    Bedroom bedroom1;

    @Before
    public void setUp() {
        bedroom1 = new Bedroom(10, RoomType.DOUBLE);
        booking = new Booking(4, bedroom1);
    }

    @Test
    public void canGetNightsbooked(){
        assertEquals(4, booking.getNightsBooked());
    }

    @Test
    public void canGetBedroom(){
        assertEquals(bedroom1, booking.getBedroom());
    }

    @Test
    public void canGetTotalCost(){
        assertEquals(200.00, booking.getTotalCost(), 0.005);
    }
}

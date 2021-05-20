import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom;

    @Before
    public void before() {bedroom = new Bedroom(10, RoomType.SINGLE);
    }

    @Test
    public void canGetCapacity() {
        assertEquals(1, bedroom.getCapacity());
    }
}

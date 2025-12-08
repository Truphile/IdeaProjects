import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class HotelSystemTest {

    @Test
    public void testNewHotelHasNoRooms() {
        HotelSystem hotel = new HotelSystem(0);
        assertEquals(0, hotel.getRoomCount());
    }

}
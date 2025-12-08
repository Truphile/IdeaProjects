import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class HotelSystemTest {

    @Test
    public void testNewHotelHasNoRooms() {
        HotelSystem hotel = new HotelSystem(0);
        assertEquals(0, hotel.getRoomCount());
    }

    @Test
    public void testNewHotelCanAddRooms() {
        HotelSystem hotel = new HotelSystem(0);
        hotel.addRoom(001, "Single", 10000);
        assertEquals(1, hotel.getRoomCount());

    }

}
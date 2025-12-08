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
    @Test
    public void testIfAddedRoomIsAvailable() {
        HotelSystem hotel = new HotelSystem(0);
        hotel.addRoom(001, "Single", 10000);
        assertEquals(1, hotel.getRoomCount());

        Room room = hotel.getRoom(001);
        assertEquals("Single",room.getType());
        assertFalse(room.isAvailable());
    }

    @Test
    public void testIfRoomIsUnavailable() {
        HotelSystem hotel = new HotelSystem(0);
        hotel.addRoom(001, "Single", 10000);
        Room room = hotel.getRoom(001);
        hotel.bookRoom(1,003,10000);
        assertFalse(room.isAvailable());


    }

    @Test
    public void testCancelBookingToMakeRoomAvailable() {
        HotelSystem hotel = new HotelSystem(0);
        hotel.addRoom(001, "Single", 10000);
        hotel.bookRoom(1,003,10000);
        Room room = hotel.getRoom(001);
        assertFalse(room.isAvailable());
        hotel.cancelBooking(1);
        assertTrue(room.isAvailable());
    }

}
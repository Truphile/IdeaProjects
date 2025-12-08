import java.util.ArrayList;

public class HotelSystem {

    private int roomCount;
    private ArrayList<Room> rooms;
    public HotelSystem(int roomCount) {
        rooms = new ArrayList<>();
    }


    public int getRoomCount() {
        return roomCount;
    }

    public void addRoom(int number, String type, int price) {
        rooms.add(new Room(number, type, price));
        roomCount++;
    }

    public Room getRoom(int number) {
        for (Room room : rooms) {
            if (room.getNumber() == number) {
                return room;
            }
        }
        return null;
    }

    public void bookRoom(int amount, int number, int price) {
        Room roomCheck = getRoom(number);
        if (roomCheck != null) {
            roomCheck.setAvailable(false);
        }
    }

    public void cancelBooking(int number) {
        Room roomCheck = getRoom(number);
        if (roomCheck != null) {
            roomCheck.setAvailable(true);
        }
    }
}

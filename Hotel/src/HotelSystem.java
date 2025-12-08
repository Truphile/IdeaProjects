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
}

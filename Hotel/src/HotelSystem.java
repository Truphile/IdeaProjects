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
}

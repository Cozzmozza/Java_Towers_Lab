public class Bedroom extends Room{

    private int roomNumber;
    private RoomType roomType;
    private int RoomCapacity;

//    public Bedroom(int capacity, int RoomCapacity, int roomNumber, RoomType roomType) {
    public Bedroom(int roomNumber, RoomType roomType) {
        super(roomType.getValue());
        this.roomNumber = roomNumber;
        this.roomType = roomType;
//        this.RoomCapacity = roomType.getValue();
//        this.capacity = roomType.getValue();
    }

    // GETTERS
    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }



}

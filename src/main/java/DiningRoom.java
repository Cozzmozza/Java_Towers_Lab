public class DiningRoom extends Room{
//    Task - DiningRoom Class with a Name, capacity, number of guests
//    Best way is to inherit the Room class, since this class already has the capacity and number of guests

    private String name;

    public DiningRoom(int capacity, String name) {
        super(capacity);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

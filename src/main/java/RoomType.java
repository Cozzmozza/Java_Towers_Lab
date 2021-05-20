public enum RoomType {

//  enum with bedroom types e.g. Single, Double. And capacity

    SINGLE(1, 35.00),
    DOUBLE(2, 50.00),
    TWIN(2, 55.00),
    FAMILY(4, 70.00);

    private final int capacity;
    private final double price;

    RoomType(int value, double price) {
        this.capacity = value;
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPrice(){
        return price;
    }
}

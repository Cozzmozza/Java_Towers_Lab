public enum RoomType {

//  enum with bedroom types e.g. Single, Double. And capacity

    SINGLE(1),
    DOUBLE(2),
    TWIN(2),
    FAMILY(4);

    private final int value;

    RoomType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

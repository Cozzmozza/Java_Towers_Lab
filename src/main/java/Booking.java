public class Booking {

    private int nightsBooked;
    private Bedroom bedroom;

    public Booking(int nightsBooked, Bedroom bedroom) {
        this.nightsBooked = nightsBooked;
        this.bedroom = bedroom;
    }

    public int getNightsBooked() {
        return nightsBooked;
    }

    public Bedroom getBedroom() {
        return bedroom;
    }

    public double getTotalCost() {
        double roomCost = bedroom.getRoomPrice();
        return roomCost * nightsBooked;
    }
}

abstract class Seat {
    int count;
    static final double CONVENIENCE_FEE = 20;

    Seat(int count) {
        this.count = count;
    }

    abstract double getPricePerTicket();

    double getAmount() {
        return (getPricePerTicket() + CONVENIENCE_FEE) * count;
    }
}

class RegularSeat extends Seat {
    RegularSeat(int count) {
        super(count);
    }

    double getPricePerTicket() {
        return 150;
    }
}

class PremiumSeat extends Seat {
    PremiumSeat(int count) {
        super(count);
    }

    double getPricePerTicket() {
        return 250;
    }
}

class ReclinerSeat extends Seat {
    ReclinerSeat(int count) {
        super(count);
    }

    double getPricePerTicket() {
        return 400;
    }
}

public class w8p1{
    public static void main(String[] args) {
        Seat[] seats = {
            new RegularSeat(2),
            new PremiumSeat(3),
            new ReclinerSeat(1)
        };

        double grandTotal = 0;

        for (Seat seat : seats) {
            double amount = seat.getAmount();
            System.out.println("SEAT: " + amount);
            grandTotal += amount;
        }

        System.out.println("GRAND TOTAL: " + grandTotal);
    }
}
abstract class Cab {
    abstract double getRatePerKm();

    double calculateFare(double km) {
        return Math.max(km * getRatePerKm(), 100);
    }
}

interface NightServiceCapable {
    double applyNightSurcharge(double fare);
}

class MiniCab extends Cab {
    double getRatePerKm() {
        return 10;
    }
}

class SedanCab extends Cab implements NightServiceCapable {
    double getRatePerKm() {
        return 14;
    }

    public double applyNightSurcharge(double fare) {
        return fare * 1.2;
    }
}

class SUVCab extends Cab implements NightServiceCapable {
    double getRatePerKm() {
        return 18;
    }

    public double applyNightSurcharge(double fare) {
        return fare * 1.2;
    }
}

public class w8p4 {
    public static void main(String[] args) {
        Cab[] cabs = {
            new MiniCab(),
            new SedanCab(),
            new SUVCab()
        };

        String TIME = "NIGHT";
        double total = 0;

        for (Cab cab : cabs) {
            double fare = cab.calculateFare(10);

            if (TIME.equals("NIGHT")) {
                if (cab instanceof NightServiceCapable n) {
                    fare = n.applyNightSurcharge(fare);
                    System.out.println("Fare = " + fare);
                    total += fare;
                } else {
                    System.out.println("night service not available");
                }
            } else {
                System.out.println("Fare = " + fare);
                total += fare;
            }
        }

        System.out.println("TOTAL = " + total);
    }
}
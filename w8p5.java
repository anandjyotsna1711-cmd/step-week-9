abstract class Appliance {
    double powerWatts;
    double hours;

    Appliance(double powerWatts, double hours) {
        this.powerWatts = powerWatts;
        this.hours = hours;
    }

    double calculateUnits() {
        return powerWatts * hours / 1000;
    }
}

interface SaverModeCapable {
    double applySaverMode(double units);
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(150, hours);
    }
}

class AC extends Appliance implements SaverModeCapable {
    AC(double hours) {
        super(1500, hours);
    }

    public double applySaverMode(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(100, hours);
    }
}

class Washer extends Appliance implements SaverModeCapable {
    Washer(double hours) {
        super(500, hours);
    }

    public double applySaverMode(double units) {
        return units * 0.75;
    }
}

public class w8p5 {
    public static void main(String[] args) {
        Appliance[] appliances = {
            new Fridge(10),
            new AC(8),
            new TV(5),
            new Washer(2)
        };

        boolean SAVER = true;

        for (Appliance appliance : appliances) {
            double units = appliance.calculateUnits();

            if (SAVER) {
                if (appliance instanceof SaverModeCapable s) {
                    units = s.applySaverMode(units);
                    System.out.println("Units = " + units);
                } else {
                    System.out.println("saver mode not supported");
                }
            } else {
                System.out.println("Units = " + units);
            }
        }
    }
}
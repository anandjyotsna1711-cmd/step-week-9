abstract class Parcel {
    double weightKg;
    double declaredValue;

    Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();
}

interface Insurable {
    double getInsurance();
}

class StandardParcel extends Parcel {
    StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double calculateCharge() {
        return 40 + 10 * weightKg;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double calculateCharge() {
        return 80 + 15 * weightKg;
    }

    public double getInsurance() {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double calculateCharge() {
        return 40 + 10 * weightKg + 50;
    }

    public double getInsurance() {
        return declaredValue * 0.03;
    }
}

public class w8p2 {
    public static void main(String[] args) {
        Parcel[] parcels = {
            new StandardParcel(5, 1000),
            new ExpressParcel(4, 2000),
            new FragileParcel(3, 1500)
        };

        for (Parcel parcel : parcels) {
            System.out.println("Charge=" + parcel.calculateCharge());

            if (parcel instanceof Insurable i) {
                System.out.println("Insurance=" + i.getInsurance());
            } else {
                System.out.println("Insurance=0.00");
            }
        }
    }
}
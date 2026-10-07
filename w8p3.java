abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateTuition();
}

interface UsesBus {
    double TRANSPORT_FEE = 5000;
}

class DayScholar extends Student implements UsesBus {
    DayScholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000 + 60000;
    }
}

class Scholar extends Student implements UsesBus {
    Scholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 20000;
    }
}

public class w8p3 {
    public static void main(String[] args) {
        Student[] students = {
            new DayScholar("A"),
            new Hosteller("B"),
            new Scholar("C")
        };

        double total = 0;

        for (Student student : students) {
            double fee = student.calculateTuition();

            if (student instanceof UsesBus) {
                fee += UsesBus.TRANSPORT_FEE;
            }

            System.out.println(student.name + " = " + fee);
            total += fee;
        }

        System.out.println("TOTAL = " + total);
    }
}
package polymorphism.challenge;


class Car {
    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;

    public Car(String name, int cylinders) {
        this.name = name;
        this.engine = true;
        this.cylinders = cylinders;
        this.wheels = 4;
    }

    public String getName() {
        return name;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String startEngine() {
        return (name + " engine starts");
    }

    public String accelerate() {
        return (name + " accelerated");
    }

    public String brake() {
        return (name + " brake activated");
    }
}

class Palio extends Car {
    public Palio() {
        super("Palio", 4);
    }

    @Override
    public String startEngine() {
        return super.startEngine() + " it is a great moment in my life.";
    }

    @Override
    public String accelerate() {
        return super.accelerate() + " and it consumes a lot of gasoline.";
    }

    @Override
    public String brake() {
        return super.brake() + " and it breaks perfectly.";
    }
}

class Vitz extends Car {
    public Vitz() {
        super("Vitz", 4);
    }

    @Override
    public String startEngine() {
        return super.startEngine() + " and it was an uncertain moment of my life.";
    }

    @Override
    public String accelerate() {
        return super.accelerate() + " and I like the performance.";
    }

    @Override
    public String brake() {
        return super.brake() + " and feels more high-tech then my Palio.";
    }
}

class Insight extends Car {
    public Insight() {
        super("Insight", 4);
    }

    @Override
    public String startEngine() {
        return super.startEngine() + " and it stops because it is hybrid.";
    }

    @Override
    public String accelerate() {
        return super.accelerate() + " and it suffers to speed up.";
    }

    @Override
    public String brake() {
        return super.brake() + " is nothing memorable.";
    }
}

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i <= 5; i++) {
            Car car = randomCar();
            System.out.println("Car #" + i + " is " + car.getName() + ".\n" +
                    car.getName() + " works with " + car.getCylinders() + " cylinders." + "\n" +
                    "When " + car.startEngine() + "\n" +
                    "When " + car.accelerate() + "\n" +
                    "When " + car.brake() + "\n");

        }

    }

    public static Car randomCar() {
        int randomNumber = (int) (Math.random() * 3) + 1;
        switch (randomNumber) {
            case 1:
                return new Palio();
            case 2:
                return new Vitz();
            case 3:
                return new Insight();
        }
        return null;
    }
}

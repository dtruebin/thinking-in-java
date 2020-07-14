package main.java.chapter9_interfaces;

interface Cycle {
    int getWheels();

    void ride();
}

interface CycleFactory {
    Cycle getCycle();
}

class Unicycle implements Cycle {

    Unicycle() {
        System.out.println("Unicycle()");
    }

    @Override
    public int getWheels() {
        return 1;
    }

    @Override
    public void ride() {
        System.out.println("Unicycle.ride()");
    }
}

class UnicycleFactory implements CycleFactory {

    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }
}

class Bicycle implements Cycle {

    Bicycle() {
        System.out.println("Bicycle");
    }

    @Override
    public int getWheels() {
        return 2;
    }

    @Override
    public void ride() {
        System.out.println("Bicycle.ride()");
    }
}

class BicycleFactory implements CycleFactory {

    @Override
    public Cycle getCycle() {
        return new Bicycle();
    }
}

class Tricycle implements Cycle {

    Tricycle() {
        System.out.println("Tricycle");
    }

    @Override
    public int getWheels() {
        return 3;
    }

    @Override
    public void ride() {
        System.out.println("Tricycle.ride()");
    }
}

class TricycleFactory implements CycleFactory {

    @Override
    public Cycle getCycle() {
        return new Tricycle();
    }
}

public class E18_CycleFactory {
    static void ride(CycleFactory cf) {
        cf.getCycle().ride();
    }

    public static void main(String[] args) {
        ride(new UnicycleFactory());
        ride(new BicycleFactory());
        ride(new TricycleFactory());
    }
}

import java.util.LinkedList;

class Car {
    private Engine engine;
    String nameOfCar;

    public Car(Engine engine, String nameOfCar) {
        this.engine = engine;
        this.nameOfCar = nameOfCar;
    }

    public String getName() {
        return nameOfCar;
    }

    public Engine getEngine() {
        return engine;
    }
}

class Engine {
    String engineNumber;
    int manufactureYear;

    public Engine(String engineNumber, int manufactureYear) {
        this.engineNumber = engineNumber;
        this.manufactureYear = manufactureYear;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }
}

public class CompositionLinked {
    public static void main(String[] args) {
        LinkedList<Engine> engines = new LinkedList<>();
        Engine engine1 = new Engine("BM2018XM5", 2018);
        Engine engine2 = new Engine("MRC2022C1", 2022);
        engines.add(engine1);
        engines.add(engine2);
       
        LinkedList<Car> cars = new LinkedList<>();
        Car car1 = new Car(engine1, "BMW");
        Car car2 = new Car(engine2,"Mercedes");
        cars.add(car1);
        cars.add(car2);
        
        for (Car car : cars) {
            System.out.println("Car Name: " + car.getName());
            System.out.println("Engine Number: " + car.getEngine().getEngineNumber());
            System.out.println("Manufacture Year: " + car.getEngine().getManufactureYear());
            System.out.println();
        }
    }
}

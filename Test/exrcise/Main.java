import java.util.ArrayList;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        ArrayList<Car> listCar = new ArrayList<>();
        Vector<Circle> listCircle = new Vector<>();

        listCar.add(new Car("Ford", 1999));
        listCar.add(new Car("Toyota", 2000));
        listCircle.add(new Circle(10));
        listCircle.add(new Circle(20));

        

    }
}

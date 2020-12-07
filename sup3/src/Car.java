import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Car
{
    public String manufacturer;
    public int age;
    public Car(String brand, int years)
    {
        manufacturer = brand;
        age = years;
    }
}
class CarCompare implements Comparator<Car>
{
    @Override
    public int compare(Car car1, Car car2)
    {
        if((car1.manufacturer).compareTo(car2.manufacturer) > 0)
            return 1;
        else
        if((car1.manufacturer).compareTo(car2.manufacturer) < 0)
            return -1;
        else
            return (car1.age-car2.age);
    }
    public static void main(String[] args)
    {
        ArrayList<Car> CarCollection = new ArrayList<Car>();
        CarCollection.add(new Car("audi", 2));
        CarCollection.add(new Car("audi", 4));
        CarCollection.add(new Car("pontiac", 1));
        CarCollection.add(new Car("toyota", 4));
        Collections.sort(CarCollection, new CarCompare());
        for (Car car : CarCollection) {
            System.out.println(car.manufacturer + " " + car.age);

        }
    }
}

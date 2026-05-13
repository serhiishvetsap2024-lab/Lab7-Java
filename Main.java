import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class Driver {
    String name;
    int age;
    int drivingExperience;

    public Driver(String name, int age, int drivingExperience) {
        this.name = name;
        this.age = age;
        this.drivingExperience = drivingExperience;
    }

    public void improveExperience() {
        drivingExperience++;
    }

    public void printInfo() {
        System.out.println("Водій: " + name + ", вік: " + age + ", стаж: " + drivingExperience + " років");
    }
}

class Car {
    String brand;
    double enginePower;
    Driver driver;
    double price;
    int year;

    public Car(String brand, double enginePower, Driver driver, double price, int year) {
        this.brand = brand;
        this.enginePower = enginePower;
        this.driver = driver;
        this.price = price;
        this.year = year;
    }

    public void repairEngine() {
        enginePower = enginePower * 1.10;
    }

    public void increasePowerAndPrice() {
        enginePower = enginePower * 1.10;
        price = price * 1.05;
    }

    public void changeDriver(Driver newDriver) {
        driver = newDriver;
    }

    public void printInfo() {
        System.out.println("Марка: " + brand);
        System.out.println("Потужність двигуна: " + String.format("%.2f", enginePower));
        System.out.println("Ціна: " + String.format("%.2f", price));
        System.out.println("Рік випуску: " + year);
        driver.printInfo();
        System.out.println();
    }
}

class TaxiHelper {
    public static Car getRandomCar(Car[] cars) {
        int randomIndex = new Random().nextInt(cars.length);
        Car selectedCar = cars[randomIndex];

        System.out.println("Автомобіль марки " + selectedCar.brand +
                " з водієм " + selectedCar.driver.name + " виїхав за вами");

        return selectedCar;
    }

    public static void driverArrived(Car car) {
        System.out.println("Водій " + car.driver.name + " прибув на місце");
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Лабораторна робота 7");
        System.out.println("Робота з колекціями в Java");
        System.out.println();


        // Завдання 1
        System.out.println("Завдання 1. Сервіс таксі з використанням ArrayList");

        ArrayList<Car> taxiCars = new ArrayList<>();

        taxiCars.add(new Car("Toyota Camry", 180, new Driver("Андрій", 28, 4), 18000, 2017));
        taxiCars.add(new Car("Volkswagen Passat", 160, new Driver("Богдан", 35, 10), 15500, 2016));
        taxiCars.add(new Car("Skoda Octavia", 150, new Driver("Іван", 24, 3), 14000, 2018));
        taxiCars.add(new Car("Hyundai Sonata", 170, new Driver("Олег", 31, 2), 16500, 2019));
        taxiCars.add(new Car("Ford Focus", 125, new Driver("Максим", 29, 6), 9500, 2015));
        taxiCars.add(new Car("Renault Megane", 115, new Driver("Роман", 27, 1), 8500, 2014));
        taxiCars.add(new Car("Mazda 6", 190, new Driver("Юрій", 40, 15), 17500, 2018));
        taxiCars.add(new Car("Honda Accord", 185, new Driver("Дмитро", 26, 4), 17000, 2017));
        taxiCars.add(new Car("Kia Optima", 175, new Driver("Сергій", 33, 8), 16000, 2019));
        taxiCars.add(new Car("Nissan Altima", 165, new Driver("Петро", 23, 2), 13500, 2016));

        System.out.println("Початковий автопарк:");
        for (Car car : taxiCars) {
            car.printInfo();
        }

        System.out.println("Ремонт мотору для половини автопарку та заміна водіїв:");

        for (int i = 0; i < taxiCars.size() / 2; i++) {
            Car car = taxiCars.get(i);
            car.repairEngine();
            car.changeDriver(new Driver("Новий водій " + (i + 1), 30 + i, 5 + i));
        }

        System.out.println("Підвищення потужності і ціни для кожної другої машини:");

        for (int i = 0; i < taxiCars.size(); i += 2) {
            taxiCars.get(i).increasePowerAndPrice();
        }

        System.out.println("Перевірка досвіду всіх водіїв:");

        for (Car car : taxiCars) {
            if (car.driver.drivingExperience < 5 && car.driver.age > 25) {
                car.driver.improveExperience();
                System.out.println(car.driver.name + " відправлений на курси. Новий стаж: "
                        + car.driver.drivingExperience + " років");
            }
        }

        System.out.println();
        System.out.println("Оновлений автопарк:");

        for (Car car : taxiCars) {
            car.printInfo();
        }

        System.out.println("Вибір випадкового автомобіля:");

        Car[] carsArray = taxiCars.toArray(new Car[0]);
        Car selectedCar = TaxiHelper.getRandomCar(carsArray);
        TaxiHelper.driverArrived(selectedCar);

        System.out.println();


        // Завдання 2
        System.out.println("Завдання 2. Телефонна книга з використанням HashMap");

        HashMap<String, String> phoneBook = new HashMap<>();

        phoneBook.put("Шевченко", "0971112233");
        phoneBook.put("Коваль", "0502223344");
        phoneBook.put("Бондар", "0633334455");
        phoneBook.put("Мельник", "0994445566");
        phoneBook.put("Ткаченко", "0685556677");
        phoneBook.put("Кравчук", "0666667788");
        phoneBook.put("Мороз", "0957778899");
        phoneBook.put("Лисенко", "0938889900");
        phoneBook.put("Савчук", "0989990011");
        phoneBook.put("Гнатюк", "0670001122");

        System.out.println("Телефонна книга:");

        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println("Прізвище: " + entry.getKey() + ", номер: " + entry.getValue());
        }

        System.out.println();

        System.out.print("Введіть прізвище для пошуку номера: ");
        String surname = scanner.nextLine();

        if (phoneBook.containsKey(surname)) {
            System.out.println("Номер абонента " + surname + ": " + phoneBook.get(surname));
        } else {
            System.out.println("У книзі відсутній такий абонент");
        }

        System.out.println();

        System.out.println("Перевірка containsKey(\"Коваль\"): " + phoneBook.containsKey("Коваль"));
        System.out.println("Перевірка containsValue(\"0502223344\"): " + phoneBook.containsValue("0502223344"));

        System.out.println();

        System.out.println("Видаляємо запис з прізвищем Мороз");
        phoneBook.remove("Мороз");

        System.out.println("Кількість записів у книзі: " + phoneBook.size());

        System.out.println();

        System.out.println("Телефонна книга після видалення:");

        for (String key : phoneBook.keySet()) {
            System.out.println("Прізвище: " + key + ", номер: " + phoneBook.get(key));
        }

        scanner.close();
    }
}
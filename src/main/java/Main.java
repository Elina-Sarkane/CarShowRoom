import cars.Car;
import cars.ShowRoom;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    ShowRoom showRoom = new ShowRoom();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }
        void showMenu(){
            String userInput = "";
            do {
                System.out.println("Welcome to showroom, please choose activity:");
                System.out.println("1. Add car");
                System.out.println("2. View All cars");
                System.out.println("3. View Single car");
                System.out.println("4. Remove car");
                System.out.println("5. Update car");
                System.out.println("6. Exit showroom");

                System.out.print("\nEnter your choice:");
                userInput = scanner.nextLine();

                switch (userInput){
                    case "1":
                        addCar();
                        break;
                    case "2":
                        viewAllCars();
                        break;
                    case "3":
                        viewSingleCar();
                        break;
                    case "4":
                        deleteCar();
                        break;
                    case "5":
                        updateCar();
                        break;
                    case "6":
                        System.out.println("Exiting showroom!");
                        break;
                    default:
                        break;
                }

                System.out.print("\nPress 0 to continue\n");
                scanner.nextLine();

            } while (!userInput.equalsIgnoreCase("6"));

            return;
        }
        void addCar(){
            System.out.println("\nAdd car\n");

            Car car = new Car();
            System.out.println("Enter Name:");
            car.name = scanner.nextLine();

            System.out.println("Enter Manufacturer:");
            car.manufacturer = scanner.nextLine();

            System.out.println("Enter Type:");
            car.type = scanner.nextLine();

            car.id = UUID.randomUUID();

            String message = showRoom.addCar(car); //info no showroom parādās no metodes addCar
            System.out.println(message);

        }
        void viewAllCars(){
            ArrayList<Car> allCars = showRoom.getAllCars();

            System.out.println("\nAll available cars\n");
            System.out.println("Id\t Car Name\t Manufacturer\t Car Type");

            int counter = 0;

            for (Car car: allCars){
                System.out.println(counter + ". \t " + car.name + " \t\t " + car.manufacturer + " \t\t " + car.type);
                counter ++;//pieskaitīs katru reizi par vienu counter klāt. Katrai mašīnai savs numurs pēc kārtas no 0
            }
        }
        void viewSingleCar(){
            System.out.println("\nView car \n");
            System.out.print("Enter car ID: ");

            Integer carId = Integer.parseInt(scanner.nextLine());
            Car car = showRoom.getSingleCar(carId);

            System.out.println("Car Number: " + car.id);
            System.out.println("Car Name: " + car.name);
            System.out.println("Car Manufacturer: " + car.manufacturer);
            System.out.print("Car Type: " + car.type + "\n");

        }
        void deleteCar(){
            System.out.println("Delete car \n");
            System.out.println("Enter Car ID: ");

            int carId = scanner.nextInt();

            String message = showRoom.removeCar(carId);
            System.out.print(message);

        }
        void updateCar(){
            Car car = new Car();

            this.viewAllCars();

            System.out.println("Update car");

            System.out.println("Enter car id:");
            int carId = Integer.parseInt(scanner.nextLine()); // šo raksta, lai pie nextInt sistēma neapstātos. tāpēc vajag int uztaisīt kā Line un tad izmanto Integer.parseInt(scannner.nextLine())

            System.out.println("Enter new name for car: ");
            car.name = scanner.nextLine();

            System.out.println("Enter car manufacturer: ");
            car.manufacturer = scanner.nextLine();

            System.out.println("Enter car type: ");
            car.type = scanner.nextLine();

            String response = showRoom.updateCar(carId, car);
            System.out.println(response);
        }
}

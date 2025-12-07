package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private VehicleDao vehicleDao;

    public void display(String dbUrl, String dbUser, String dbPassword){
        init(dbUrl, dbUser, dbPassword);

        boolean running = true;
        while(running){
            displayMenu();
            System.out.println("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehicleRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 99 -> running = false;
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private void displayMenu(){
        System.out.println("=== Car Dealership ===");
        System.out.println("1 - Find vehicles within price range");
        System.out.println("2 - Find vehicles by make / model");
        System.out.println("3 - Find vehicles by year range");
        System.out.println("4 - Find vehicles by color");
        System.out.println("5 - Find vehicles by mileage range");
        System.out.println("6 - Find vehicles by type (car, truck, SUV, van)");
        System.out.println("7 - List ALL Vehicles");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("99 - Quit");
    }

    public void init(String dbUrl, String dbUser, String dbPassword){
        this.vehicleDao = new VehicleDao(dbUrl, dbUser, dbPassword);
    }

    private void displayVehicles(List<Vehicle> vehicles){
        if (vehicles.isEmpty()){
            System.out.println("No vehicles found.");
        } else {
            System.out.println("\n=== Vehicles ===");
            for (Vehicle vehicle : vehicles){
                System.out.printf("VIN: %s | %d %s %s | Type: %s | Color: %s | Miles: %d | Price: $%.2f\n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice());
            }
            System.out.println();
        }
    }

    public void processGetByPriceRequest(){
        System.out.println("Enter minimum price: $");
        double min = scanner.nextDouble();

        System.out.println("Enter maximum price: $");
        double max = scanner.nextDouble();
        scanner.nextLine();

        List<Vehicle> vehicles = vehicleDao.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByModelRequest(){
        System.out.println("Enter make: ");
        String make = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();

        List<Vehicle> vehicles = vehicleDao.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    public void processGetByYearRequest(){
        System.out.println("Enter minimum year: ");
        int min = scanner.nextInt();
        System.out.println("Enter maximum year: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        List<Vehicle> vehicles = vehicleDao.getVehiclesByYear(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByColorRequest(){
        System.out.println("Enter color: ");
        String color = scanner.nextLine();

        List<Vehicle> vehicles = vehicleDao.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    public void processGetByMileageRequest(){
        System.out.println("Enter minimum miles: ");
        double min = scanner.nextDouble();
        System.out.println("Enter maximum miles: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        List<Vehicle> vehicles = vehicleDao.getVehiclesByMiles(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByVehicleTypeRequest(){
        System.out.println("Enter vehicle type (car, truck, SUV, van): ");
        String type = scanner.nextLine();

        List<Vehicle> vehicles = vehicleDao.getVehiclesByType(type);
        displayVehicles(vehicles);
    }

    public void processGetAllVehicleRequest(){
        List<Vehicle> vehicles = vehicleDao.getAllVehicles();
        displayVehicles(vehicles);
    }

    public void processAddVehicleRequest(){
        System.out.print("Enter VIN: ");
        String vin = scanner.nextLine();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter vehicle type: ");
        String type = scanner.nextLine();
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        System.out.print("Enter odometer: ");
        int odometer = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        vehicleDao.createVehicle(vehicle);

        System.out.println("Vehicle added successfully!");
    }

    public void processRemoveVehicleRequest(){
        System.out.print("Enter VIN of vehicle to remove: ");
        String vin = scanner.nextLine();

        vehicleDao.deleteVehicle(vin);

        System.out.println("Vehicle removed successfully!");
    }
}
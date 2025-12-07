package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }

    public void removeVehicle(String vin){
        inventory.removeIf(vehicle -> vehicle.getVin().equals(vin));
    }

    public List<Vehicle> getAllVehicles(){
        return new ArrayList<>(inventory);
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max){
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle i: inventory){
            if (i.getPrice() >= min && i.getPrice() <= max){
                result.add(i);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle i: inventory){
            if (i.getMake().equalsIgnoreCase(make) && i.getModel().equalsIgnoreCase(model)){
                result.add(i);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max){
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle i: inventory){
            if (i.getYear() >= min && i.getYear() <= max){
                result.add(i);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByColor(String color){
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle i: inventory){
            if(i.getColor().equalsIgnoreCase(color)){
                result.add(i);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByMiles(double min, double max){
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle i: inventory){
            if (i.getOdometer() >= min && i.getOdometer() <= max){
                result.add(i);
            }
        }
        return result;
    }

    public List<Vehicle> getVehicleByType(String vehicleType){
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle i: inventory){
            if(i.getVehicleType().equalsIgnoreCase(vehicleType)){
                result.add(i);
            }
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}

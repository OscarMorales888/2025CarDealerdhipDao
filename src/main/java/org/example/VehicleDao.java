package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VehicleDao {
    private final String dbUrl;
    private final String dbUser;
    private final String dbPass;

    public VehicleDao(String dbUrl, String dbUser, String dbPass) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPass = dbPass;
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicles";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String vin = rs.getString("VIN");
                int year = rs.getInt("year");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String color = rs.getString("color");
                String vehicleType = rs.getString("vehicle_type");
                int odometer = rs.getInt("odometer");
                double price = rs.getDouble("price");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                vehicles.add(vehicle);
            }
        } catch (SQLException ex) {
            System.out.println("There was a problem with the database");
            ex.printStackTrace();
        }
        return vehicles;
    }

    public Optional<Vehicle> getVehicleByVin(String vin) {
        String sqlQuery = "SELECT * FROM vehicles WHERE VIN = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, vin);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int year = rs.getInt("year");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String color = rs.getString("color");
                String vehicleType = rs.getString("vehicle_type");
                int odometer = rs.getInt("odometer");
                double price = rs.getDouble("price");

                return Optional.of(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
            }
        } catch (SQLException ex) {
            System.out.println("There was a problem with the database");
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicles WHERE price >= ? AND price <= ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setDouble(1, min);
            ps.setDouble(2, max);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String vin = rs.getString("VIN");
                int year = rs.getInt("year");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String color = rs.getString("color");
                String vehicleType = rs.getString("vehicle_type");
                int odometer = rs.getInt("odometer");
                double price = rs.getDouble("price");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                vehicles.add(vehicle);
            }
        } catch (SQLException ex) {
            System.out.println("There was a problem with the database");
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicles WHERE make = ? AND model = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, make);
            ps.setString(2, model);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String vin = rs.getString("VIN");
                int year = rs.getInt("year");
                String color = rs.getString("color");
                String vehicleType = rs.getString("vehicle_type");
                int odometer = rs.getInt("odometer");
                double price = rs.getDouble("price");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                vehicles.add(vehicle);
            }
        } catch (SQLException ex) {
            System.out.println("There was a problem with the database");
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicles WHERE year >= ? AND year <= ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, min);
            ps.setInt(2, max);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String vin = rs.getString("VIN");
                int year = rs.getInt("year");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String color = rs.getString("color");
                String vehicleType = rs.getString("vehicle_type");
                int odometer = rs.getInt("odometer");
                double price = rs.getDouble("price");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                vehicles.add(vehicle);
            }
        } catch (SQLException ex) {
            System.out.println("There was a problem with the database");
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicles WHERE color = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, color);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String vin = rs.getString("VIN");
                int year = rs.getInt("year");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String vehicleType = rs.getString("vehicle_type");
                int odometer = rs.getInt("odometer");
                double price = rs.getDouble("price");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                vehicles.add(vehicle);
            }
        } catch (SQLException ex) {
            System.out.println("There was a problem with the database");
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMiles(double min, double max) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicles WHERE odometer >= ? AND odometer <= ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setDouble(1, min);
            ps.setDouble(2, max);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String vin = rs.getString("VIN");
                int year = rs.getInt("year");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String color = rs.getString("color");
                String vehicleType = rs.getString("vehicle_type");
                int odometer = rs.getInt("odometer");
                double price = rs.getDouble("price");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                vehicles.add(vehicle);
            }
        } catch (SQLException ex) {
            System.out.println("There was a problem with the database");
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicles WHERE vehicle_type = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, vehicleType);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String vin = rs.getString("VIN");
                int year = rs.getInt("year");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String color = rs.getString("color");
                int odometer = rs.getInt("odometer");
                double price = rs.getDouble("price");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                vehicles.add(vehicle);
            }
        } catch (SQLException ex) {
            System.out.println("There was a problem with the database");
            ex.printStackTrace();
        }
        return vehicles;
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        String sqlQuery = "INSERT INTO vehicles(VIN, year, make, model, color, vehicle_type, odometer, price) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, vehicle.getVin());
            ps.setInt(2, vehicle.getYear());
            ps.setString(3, vehicle.getMake());
            ps.setString(4, vehicle.getModel());
            ps.setString(5, vehicle.getColor());
            ps.setString(6, vehicle.getVehicleType());
            ps.setInt(7, vehicle.getOdometer());
            ps.setDouble(8, vehicle.getPrice());

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Vehicle added successfully to database!");
            }
        } catch (SQLException ex) {
            System.out.println("There was a problem with the database");
            ex.printStackTrace();
        }
        return vehicle;
    }

    public Vehicle updateVehicle(Vehicle vehicle) {
        String sqlQuery = "UPDATE vehicles SET year = ?, make = ?, model = ?, color = ?, vehicle_type = ?, odometer = ?, price = ? WHERE VIN = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, vehicle.getYear());
            ps.setString(2, vehicle.getMake());
            ps.setString(3, vehicle.getModel());
            ps.setString(4, vehicle.getColor());
            ps.setString(5, vehicle.getVehicleType());
            ps.setInt(6, vehicle.getOdometer());
            ps.setDouble(7, vehicle.getPrice());
            ps.setString(8, vehicle.getVin());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("There was a problem with the database");
            ex.printStackTrace();
        }
        return vehicle;
    }

    public void deleteVehicle(String vin) {
        String sqlQuery = "DELETE FROM vehicles WHERE VIN = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, vin);
            ps.executeUpdate();
            System.out.println("Vehicle deleted successfully from database!");
        } catch (SQLException ex) {
            System.out.println("There was a problem with the database");
            ex.printStackTrace();
        }
    }
}
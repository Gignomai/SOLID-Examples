package com.gignomai.solid.liskov_substitution;

class Vehicle {
    public void move() {
        System.out.println("Vehicle moving!");
    }
}

class Car extends Vehicle {
    @Override
    public void move() {
        System.out.println("Car riding!");
    }
}

class Plane extends Vehicle {
    @Override
    public void move() {
        System.out.println("Plane flying!");
    }
}

// All subclasses that extend Vehicle implement move method in the same way thus it doesn't break the main execution.
// Master classes must be replaceable by the subclasses and the program must behave the same.

public class LiskovSubstitutionExample {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle();
        Car car = new Car();
        Plane plane = new Plane();

        moveVehicle(vehicle);
        moveVehicle(car);
        moveVehicle(plane);
    }

    private static void moveVehicle(Vehicle vehicle) {
        vehicle.move();
    }
}

package com.gignomai.solid.interface_segregation;

interface Animal {
    void run();
    void swim();
    void fly();
}

class Dog implements Animal {
    @Override
    public void run() {
        System.out.println("Dogs can run quite fast.");
    }

    @Override
    public void swim() {
        System.out.println("Dogs can swim, but slowly.");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Dogs cannot fly!!");
    }

}

interface RunningAnimal {
    void run();
}

interface SwimmingAnimal {
    void swim();
}

interface FlyingAnimal {
    void fly();
}

class Fish implements SwimmingAnimal {
    @Override
    public void swim() {
        System.out.println("Fish can swim very fast.");
    }
}

class Duck implements SwimmingAnimal, FlyingAnimal, RunningAnimal {
    @Override
    public void run() {
        System.out.println("Ducks can run but not very fast.");
    }

    @Override
    public void swim() {
        System.out.println("Ducks can swim very fast.");
    }

    @Override
    public void fly() {
        System.out.println("Ducks can fly very fast.");
    }
}


public class InterfaceSegregationExample {

    // No code should be force to depend on methods that does not use
    public static void main(String[] args) {
        // This implementation violates the ISP as it forces to override a not needed method.
        Dog dog = new Dog();
        dog.run();
        dog.swim();
        try {
            dog.fly();
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }

        // This implementation is better as any animal can decide which interfaces to implement
        Fish fish = new Fish();
        fish.swim();

        Duck duck = new Duck();
        duck.fly();
        duck.run();
        duck.swim();
    }
}

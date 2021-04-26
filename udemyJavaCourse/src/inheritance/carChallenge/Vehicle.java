/*
 * Copyright (c) 2021. Higor Shindy Kudo
 */

package inheritance.carChallenge;

public class Vehicle {

    private String name;
    private String size;

    private int currentVelocity;
    private int currentDirection;

    public Vehicle(String name, String size) {
        this.name = name;
        this.size = size;

        this.currentVelocity = 0;
        this.currentDirection = 0;
    }

    public void steer(int direction){
        System.out.println("Vehicles.steer(): Steering at " + currentDirection + " degrees.");
        this.currentDirection += direction;



    }

    public void move(int velocity, int direction){
        currentVelocity = velocity;
        currentDirection = direction;
        System.out.println("Vehicle.move(): Moving at " + currentVelocity + " in direction of " + currentDirection + " degrees.");
    }
//    public void increaseSpeed(int speed){
//        move();
//        System.out.println(" faster at " + speed + "speed");
//    }
//    public void decreaseSpeed(int speed){
//        move();
//        System.out.println(" slower at " + speed + "speed");
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public void setCurrentVelocity(int currentVelocity) {
        this.currentVelocity = currentVelocity;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void stop(){
        this.currentVelocity = 0;
    }
}

/*
 * Copyright (c) 2021. Higor Shindy Kudo
 */

package composition.Video92;

public class Sofa {

    private String fabric;
    private int numberOfSeats;
    private String color;

    public Sofa(String fabric, int numberOfSeats, String color) {
        this.fabric = fabric;
        this.numberOfSeats = numberOfSeats;
        this.color = color;
    }

    private void makePillows() {
        System.out.println("Making Pillows");
    }

    public void decorating() {
        makePillows();
    }


    public String getFabric() {
        return fabric;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getColor() {
        return color;
    }
}

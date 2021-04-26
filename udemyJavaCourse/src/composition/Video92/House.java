/*
 * Copyright (c) 2021. Higor Shindy Kudo
 */

package composition.Video92;

public class House {
    private Room room;
    private int numberOfRooms;
    private String color;

    public House(Room room, int numberOfRooms, String color) {
        this.room = room;
        this.numberOfRooms = numberOfRooms;
        this.color = color;
    }

    public Room getRoom() {
        return room;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public String getColor() {
        return color;
    }
}

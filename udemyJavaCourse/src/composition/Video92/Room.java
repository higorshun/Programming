/*
 * Copyright (c) 2021. Higor Shindy Kudo
 */

package composition.Video92;

public class Room {

    private Door door;
    private Window window;
    private Sofa sofa;

    public Room(Door door, Window window, Sofa sofa) {
        this.door = door;
        this.window = window;
        this.sofa = sofa;
    }

    public void installSofa(Sofa sofa) {

        this.sofa = sofa;
        System.out.println("Sofa was placed");
        closeDoor();
    }


    private void closeDoor() {
        System.out.println("Door closed");
    }


}

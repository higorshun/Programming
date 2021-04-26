/*
 * Copyright (c) 2021. Higor Shindy Kudo
 */

package composition.Video92;

public class Main {

    public static void main(String[] args) {

        Room  livingRoom = new Room(new Door("wood"),new Window("white"), new Sofa("leather",2, "white"));

        House houseExample = new House(livingRoom,2,"white");

        Sofa newSofa = new Sofa("synthetic", 3, "black");

        houseExample.getRoom().installSofa(newSofa);
        newSofa.decorating();



    }
}

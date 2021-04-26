/*
 * Copyright (c) 2021. Higor Shindy Kudo
 */

package composition.video91;

/**
 * Composition is a matter of HAVE
 * Inheritance is a matter of TO BE
 */
public class PC {
    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp() {
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        //Fancy graphics
        monitor.drawPixelAt(1200, 50, "yellow");
    }

}

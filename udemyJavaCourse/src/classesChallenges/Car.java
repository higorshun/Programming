package classesChallenges;

/**
 * The public keyword means that other classes that we create has access
 * Classes are a blueprint
 * creating a field for a class - it has to be private to comply with encapsulation
 */

public class Car {

    //lets create some fields, characteristics, states!!!!
    // cannot see in the main
    private int door; //state components, characteristics
    private int wheels;
    private String model;
    private String engine;
    private String color;

    public void setModel(String model) {
        /**
         *  THIS means the private variable to be modified
         */
        String validModel = model.toLowerCase();
        if (validModel.equals("carrera") || validModel.equals("commodore")) {
            this.model = model;
        } else {
            this.model = "Unknown";
        }

    }

    public String getModel() {
        return this.model;
    }


}

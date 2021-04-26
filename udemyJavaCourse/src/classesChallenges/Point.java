package classesChallenges;

/**
 * You have to represent a point in 2D space. Write a class with the name Point. The class needs two fields (instance
 * variables) with name x and y of type int.
 * <p>
 * The class needs to have two constructors. The first constructor does not have any parameters (no-arg constructor).
 * The second constructor has parameters x and y of type int and it needs to initialize the fields.
 * <p>
 * Write the following methods (instance methods):
 * * Method named getX without any parameters, it needs to return the value of x field.
 * * Method named getY without any parameters, it needs to return the value of y field.
 * * Method named setX with one parameter of type int, it needs to set the value of the x field.
 * * Method named setY with one parameter of type int, it needs to set the value of the y field.
 * * Method named distance without any parameters, it needs to return the distance between this Point and Point 0,0
 * as double.
 * * Method named distance with two parameters x, y both of type int, it needs to return the distance between this
 * Point and Point x,y as double.
 * * Method named distance with parameter another of type Point, it needs to return the distance between this Point
 * and another Point as double.
 * <p>
 * How to find the distance between two points?To find a distance between points A(xA,yA) and B(xB,yB), we use the
 * formula:
 * <p>
 * d(A,B)=√ (xB − xA) * (xB - xA) + (yB − yA) * (yB - yA)
 * <p>
 * Where √ represents square root.
 * <p>
 * <p>
 * <p>
 * <p>
 * TEST EXAMPLE
 * <p>
 * → TEST CODE:
 * <p>
 * Point first = new Point(6, 5);
 * Point second = new Point(3, 1);
 * System.out.println("distance(0,0)= " + first.distance());
 * System.out.println("distance(second)= " + first.distance(second));
 * System.out.println("distance(2,2)= " + first.distance(2, 2));
 * Point point = new Point();
 * System.out.println("distance()= " + point.distance());
 * <p>
 * OUTPUT
 * <p>
 * distance(0,0)= 7.810249675906654
 * distance(second)= 5.0
 * distance(2,2)= 5.0
 * distance()= 0.0
 * <p>
 * NOTE: Use Math.sqrt to calculate the square root √.
 * <p>
 * NOTE: Try to avoid duplicated code.
 * <p>
 * NOTE: All methods should be defined as public NOT public static.
 * <p>
 * NOTE: In total, you have to write 7 methods.
 * <p>
 * NOTE: Do not add a main method to the solution code.
 */
public class Point {

    private int x;
    private int y;

    public Point() {
        this(0, 0);

    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Method named distance without any parameters,
     * it needs to return the distance between this Point and Point 0,0 as double.
     * d(A,B)=√ (xB − xA) * (xB - xA) + (yB − yA) * (yB - yA)
     */

    public double distance() {
        int xA = 0;
        int yA = 0;
        int xB = x;
        int yB = y;
        return Math.sqrt((xB - xA) * (xB - xA) + (yB - yA) * (yB - yA));
    }

    /**
     * Method named distance with two parameters x, y both of type int,
     * it needs to return the distance between this Point and Point x,y as double.
     */
    public double distance(int xA, int yA) {

        int xB = x;
        int yB = y;

        return Math.sqrt((xB - xA) * (xB - xA) + (yB - yA) * (yB - yA));
    }

    /**
     * Method named distance with parameter another of type Point,
     * it needs to return the distance between this Point and another Point as double.
     */
    public double distance(Point point) {
        int xA = point.x;
        int yA = point.y;
        int xB = x;
        int yB = y;
        return Math.sqrt((xB - xA) * (xB - xA) + (yB - yA) * (yB - yA));
    }


}

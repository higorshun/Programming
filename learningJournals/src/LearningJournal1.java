import javax.swing.*;
import java.awt.*;

public class LearningJournal1 {


    public static void main(String[] args) {
        double A, B, C;

        JFrame janelaTeste = new JFrame();
        janelaTeste.setSize(600, 500);
        janelaTeste.setLocation(400, 50);
        janelaTeste.setLayout(null);
        janelaTeste.setBackground(Color.BLACK);
        janelaTeste.setVisible(true);

        Label questionLabel = new Label("Type the numbers to calculate the the " +
                "largest root of quadratic equation.", Label.LEFT);
        questionLabel.setSize(500, 20);
        questionLabel.setLocation(10, 10);

        //Dimension dimension = new Dimension(20,20);
        int labelWidth = 150;
        int labelHeight = 20;

        Label aLabel = new Label("Type a value for A = ", Label.CENTER);
        aLabel.setLocation(40, 40);
        aLabel.setSize(labelWidth, labelHeight);

        Label bLabel = new Label("Type a value for B = ", Label.CENTER);
        bLabel.setLocation(40, 80);
        bLabel.setSize(labelWidth, labelHeight);

        Label cLabel = new Label("Type a value for C = ", Label.CENTER);
        cLabel.setLocation(40, 120);
        cLabel.setSize(labelWidth, labelHeight);

        int fieldWidth = 30;
        int fieldHeight = 30;

        int fieldHorizontal = 200;

        TextField aField = new TextField(Label.CENTER);
//        Scanner scanner = new Scanner(System.in);
//        double number = scanner.nextDouble();
        aField.setSize(fieldWidth, fieldHeight);
        aField.setLocation(fieldHorizontal, 40);


        TextField bField = new TextField(Label.CENTER);
        bField.setSize(fieldWidth, fieldHeight);
        bField.setLocation(fieldHorizontal, 80);

        TextField cField = new TextField(Label.CENTER);
        cField.setSize(fieldWidth, fieldHeight);
        cField.setLocation(fieldHorizontal, 120);

        Button calculateButton = new Button();
        calculateButton.setLabel("Calculate");
        calculateButton.setSize(100, 40);
        calculateButton.setLocation(250, 160);

        janelaTeste.add(questionLabel);
        janelaTeste.add(aLabel);
        janelaTeste.add(aField);
        janelaTeste.add(bLabel);
        janelaTeste.add(bField);
        janelaTeste.add(cLabel);
        janelaTeste.add(cField);
        janelaTeste.add(calculateButton);

        //variables of the equation
        char userChoice; //  variable to store a char with the user's answer


        do {
            /*guiding the user to type three numbers
            and storing in the previous declared variables */

            System.out.println("Type the numbers to calculate the the " +
                    "largest root of quadratic equation.");


            System.out.println("Type a value for A = ");
            A = TextIO.getlnDouble();
            System.out.println("Type a value for B = ");
            B = TextIO.getlnDouble();
            System.out.println("Type a value for C = ");
            C = TextIO.getlnDouble();

            //Print the solution or the reason why it could not be calculated

            try {
                System.out.println("The root largest of the equation "
                        + A + "x² + " + B + "x + " + C + " = 0 is " + root(A, B, C));

            } catch (IllegalArgumentException e) {
                System.out.println("It is not possible to calculate because " + e.getMessage());
            }

            // Store using variable to continue or quit the program


            System.out.println("******************************************************");
            System.out.println("Type 'y' if you want to calculate another expression or any other key to quit.");
            userChoice = TextIO.getlnChar();


        } while (userChoice == 'y');
        //message to make the program more user-friendly
        System.out.println("Thanks for using this program.");
    }

    /**
     * Returns the larger of the two roots of the quadratic equation
     * A*x*x + B*x + C = 0, provided it has any roots.  If A == 0 or
     * if the discriminant, B*B - 4*A*C, is negative, then an exception
     * of type IllegalArgumentException is thrown.
     */
    static public double root(double A, double B, double C)
            throws IllegalArgumentException {
        if (A == 0) {
            throw new IllegalArgumentException("A can't be zero.");
        } else {
            double disc = (B * B) - (4 * A * C);
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return (-B + Math.sqrt(disc)) / (2 * A);
        }
    }


}

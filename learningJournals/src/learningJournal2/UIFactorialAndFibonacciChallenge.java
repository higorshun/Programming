/*
package learningJournal2;

import javax.swing.*;
import java.util.Scanner;

*/
/**
 * This program test the factorial and fibonacci recursive function of non-negative Integer
 *//*

public class UIFactorialAndFibonacciChallenge {

    private JPanel panel1;
    private JLabel questionLabel;
    private JTextField numberField;
    private JLabel enterNumberLabel;
    private JLabel resultLabel;
    private JButton calculateButton;

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JLabel getQuestionLabel() {
        return questionLabel;
    }

    public void setQuestionLabel(JLabel questionLabel) {
        this.questionLabel = questionLabel;
    }

    public JTextField getNumberField() {
        return numberField;
    }

    public void setNumberField(JTextField numberField) {
        this.numberField = numberField;
    }

    public JLabel getEnterNumberLabel() {
        return enterNumberLabel;
    }

    public void setEnterNumberLabel(JLabel enterNumberLabel) {
        this.enterNumberLabel = enterNumberLabel;
    }

    public JLabel getResultLabel() {
        return resultLabel;
    }

    public void setResultLabel(JLabel resultLabel) {
        this.resultLabel = resultLabel;
    }

    public JButton getCalculateButton() {
        return calculateButton;
    }

    public void setCalculateButton(JButton calculateButton) {
        this.calculateButton = calculateButton;
    }

    */
/**
     * Obtains a non-negative integer from the user, passing it to
     * the factorial and fibonacci functions and printing the results
     * to standard output.
     * @param args Command line args (not used).
     *//*


    public static void main(String[] args) {
        UIFactorialAndFibonacciChallenge teste2 = new UIFactorialAndFibonacciChallenge();
        teste2.setQuestionLabel() = " ";



        Scanner s = new Scanner(System.in);
        int number = 0;
        boolean tryOneMoreTime = true;
        char answer;

        do {

            System.out.println("Enter a non-negative integer: ");
            String userInput = s.next(); // read what user typed
            try { // try to convert the String to Integer
                number = Integer.parseInt(userInput);
                if (number >= 0) { // if conversion was well-succeeded, start the methods
                    System.out.println("Factorial of " + number + " equals: " + factorial(number));
                    System.out.println("Fibonacci " + number + " equals: " + fibonacci(number));
                } else {
                    System.out.println("The number " + number + " is less than zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println(userInput + " is not an Integer. \n");
                tryOneMoreTime = true;
            }

            System.out.println("If you want to try again, type 'y'." +
                    " Type 'q' to quit this program.");
            answer = s.next().charAt(0);
            if (answer == 'y') {
                tryOneMoreTime = true;
            } else if (answer == 'q') {
                tryOneMoreTime = false;
            } else System.out.println("Invalid answer");

        } while (tryOneMoreTime);

        s.close();

    } // enf of main class

    */
/**
     * Calculates the factorial of num recursively.
     * Precondition: num is a non-negative integer.
     * @param number A non-negative integer.
     * @return The factorial of num.
     *//*

    private static int factorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }// end of method factorial

    */
/*** Calculates the "num"th Fibonacci number recursively.
     * Precondition: num is a non-negative integer.
     @param number A non-negative integer.
     @return The fibonacci of num.
     *//*

    private static int fibonacci(int number) {
        if (number <= 1) {
            return number;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    } // end of method fibonacci



    public void setData(UIFactorialAndFibonacciChallenge data) {
    }

    public void getData(UIFactorialAndFibonacciChallenge data) {
    }

    public boolean isModified(UIFactorialAndFibonacciChallenge data) {
        return false;
    }


} // end of class



*/

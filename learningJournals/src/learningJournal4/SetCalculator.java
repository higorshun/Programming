package learningJournal4;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * This program intents to find the union, intersection or
 * difference between two sets of real, non-negative numbers.
 */

public class SetCalculator {
    public static void main(String[] args) {

        System.out.println("Valid Examples:\n[12,2,3]+[3,44,2]\n[30,4,5]*[7,4,2]\n[3,42,5]-[74,4,2]\n" +
                "Enter your set of number:");
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        String userStringIn = scanner.nextLine();  // Read user input
        System.out.print("\r");
        String regexString = "\\[\\d{1,2}(,\\d{1,2})*\\](\\+|\\*|\\-)\\[\\d{1,2}(,\\d{1,2})+\\]";
        //check if string matches the syntax
        while (!Pattern.matches(regexString, userStringIn)) {
            if (userStringIn.matches("Q")) {
                scanner.close();
                break;
            }
            System.out.println("Your input is invalid: " + userStringIn);
            System.out.println("Type in Q if you want to quit or enter a valid set of numbers :");
            userStringIn = scanner.nextLine();
            scanner.close();
            System.out.println("The result of the set of numbers is: " + userStringIn);  // Output user input
        }

        int operatorIndex = 0;
        //put characters into array
        char[] userCharsArray = userStringIn.toCharArray();
        for (int i = 0; i < userCharsArray.length; i++) {
            //look for the operator
            char c = userStringIn.toCharArray()[i];
            if (c == '+' || c == '*' || c == '-') {
                operatorIndex = i;
                break;
            }
        }
        //build setA
        Set<Integer> setA = new TreeSet<>();
        for (int i = 1; i < operatorIndex - 1; i++) {
            if (userCharsArray[i] != ',') {
                setA.add(Integer.parseInt(String.valueOf(userCharsArray[i])));
            }

        }
        //build setB
        Set<Integer> setB = new TreeSet<>();
        for (int i = operatorIndex + 2; i < userCharsArray.length - 1; i++) {
            if (userCharsArray[i] != ',') {
                setB.add(Integer.parseInt(String.valueOf(userCharsArray[i])));
            }
        }
        //select the right operation
        switch (userCharsArray[operatorIndex]) {
            case '+':
                // To find union
                Set<Integer> union = new TreeSet<>(setA);
                union.addAll(setB);
                System.out.print("Union of the two Set");
                System.out.println(union);
                break;
            case '*':
                // To find intersection
                Set<Integer> intersection = new TreeSet<>(setA);
                intersection.retainAll(setB);
                System.out.print("Intersection of the two set");
                System.out.println(intersection);
                break;
            case '-':
                // To find the symmetric difference
                Set<Integer> difference = new TreeSet<>(setA);
                difference.removeAll(setB);
                System.out.print("Difference of the two Set");
                System.out.println(difference);
                break;

        } //end of switch
    } // end of main class
}// end of SetCalculator class





package firstChallenges;

import java.util.Scanner;

public class MinimumAndMaximumChallenge {

    public static void main(String[] args) {
        // instance scanner
        Scanner s = new Scanner(System.in);
//        int minimum = 2147483647;
//        int maximum = -2147483648;

        int minimum = Integer.MAX_VALUE; //wrapper class
        int maximum = Integer.MIN_VALUE;

        boolean first = true; // flag to check if the user input some number to deal with 0 problem
        while (true) {
            System.out.print("Enter number: ");
            boolean isAnInt = s.hasNextInt();
            if (isAnInt) {
                int number = s.nextInt();
//                //Flag boolean to deal with the 0 bug
//                if(first) {
//                    first = false;
//                    minimum = number;
//                    maximum = number;
//                }
                if (number > maximum) {
                    maximum = number;
                }
                if (number < minimum) {
                    minimum = number;
                }


            } else {
                System.out.println("Invalid number. Closing this program");
                break;
            }
            s.nextLine(); // deal with (enter key) problem
        }
        System.out.println("Minimum = " + minimum + " and Maximum = " + maximum);
        s.close(); // close scanner
    }
}

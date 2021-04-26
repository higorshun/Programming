package firstChallenges;

import java.util.Scanner;

public class InputCalculator {

    public static void main(String[] args) {

        inputThenPrintSumAndAverage();


    }

    public static void inputThenPrintSumAndAverage() {
        double XX = 0;
        double YY = 0;
        Scanner scanner = new Scanner(System.in);
        double counter = 0;

        while (true) {
            boolean isAnInt = scanner.hasNextInt();
            if (isAnInt) {
                double number = scanner.nextInt();
                XX = number + XX;
                counter++;
                YY = XX / counter;

            } else {
                System.out.println("SUM = " + (int)Math.round(XX) + " AVG = " + (int)Math.round(YY));
                break;
            }
            scanner.nextLine(); // deal with enter problem before end of loop
        }
        scanner.close();

    }

}

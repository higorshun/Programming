package firstChallenges;

import java.util.Scanner;

public class ReadingUserInputChallenge {
    public static void main(String[] args) {
        //create a new instance of scanner
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        int sum = 0;
        while (true) {
            int order = counter + 1;
            System.out.print("Please enter number #" + order + ": ");
            boolean isAnInt = scanner.hasNextInt();
            if (isAnInt) {
                int number = scanner.nextInt();
                counter++;
                sum += number;
                if (counter == 10) {
                    break;
                }
            } else {
                System.out.println("Invalid Number");
            }
            scanner.nextLine();// handle end of line enter key

        }
        System.out.println("The sum of the numbers that you typed is " + sum);
        scanner.close();

    }
}

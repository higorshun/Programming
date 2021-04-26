package firstChallenges;

import java.util.Scanner;

public class ReadingUserInput {

    public static void main(String[] args) {
        //create an instance of scanner -- I am gonna learn later what an instance is
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your year of birth: ");

        boolean hasNextInt = scanner.hasNextInt(); // is there an integer???
        if (hasNextInt) {
            int yearOfBirth = scanner.nextInt();
            scanner.nextLine(); // handle the enter problem
            System.out.println("Enter yor name: ");
            //read a line that the user input and storing in variable name
            String name = scanner.nextLine();
            int age = 2021 - yearOfBirth;

            if (age >= 0 && age <= 100) {
                System.out.println("Hello, " + name + "! So, you are " + age + " years old.");
            } else {
                System.out.println("Invalid year of birth.");
            } // end of checking the range of age

        } else {// end of checking if has a valid integer
            System.out.println("Unable to parse year of birth.");
        }
        scanner.close();

    } // end of main method
} // end of class

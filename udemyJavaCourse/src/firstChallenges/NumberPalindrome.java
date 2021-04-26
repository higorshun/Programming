package firstChallenges;

public class NumberPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-707));
    }

    public static boolean isPalindrome(int number) {

        int reverse = 0;
        int firstNumber = number;


        while (number != 0) {

            int lastDigit = number % 10;
            reverse = (reverse * 10) + lastDigit;
            number /= 10;

        }

        if (firstNumber == reverse) {
            return true;
        } else
            return false;
    }
}

package firstChallenges;

public class PerfectNumber {

    public static void main(String[] args) {
        System.out.println(isPerfectNumber(28));

    }

    public static boolean isPerfectNumber(int number) {
        int result = 0;
        int total = 0;
        if (number < 1)
            return false;

        for (int i = 1; i <= number; i++) {

            if (number % i == 0 && i != number) {
                result = i;
                total = total + result;
            }

        }

        if (number == total) {
            return true;
        } else
            return false;


    }

}

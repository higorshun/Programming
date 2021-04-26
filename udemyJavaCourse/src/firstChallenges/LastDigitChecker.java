package firstChallenges;

public class LastDigitChecker {


    public static void main(String[] args) {

        System.out.println(hasSameLastDigit(22, 23, 34));


    }

    public static boolean hasSameLastDigit(int number1, int number2, int number3) {
        int lastDigit1 = 0;
        int lastDigit2 = 0;
        int lastDigit3 = 0;

        if (!isValid(number1) || !isValid(number2) || !isValid(number3)) {
            return false;
        }

        while (isValid(number1) || isValid(number2) || isValid(number3)) {
            lastDigit1 = number1 % 10;
            lastDigit2 = number2 % 10;
            lastDigit3 = number3 % 10;
            break;

        }

        if ((lastDigit1 == lastDigit2) || (lastDigit1 == lastDigit3)
                || (lastDigit2 == lastDigit1) || (lastDigit2 == lastDigit3)
                || lastDigit3 == lastDigit1 || lastDigit3 == lastDigit2) {
            return true;
        } else
            return false;
    }


    public static boolean isValid(int number) {
        if (number >= 10 && number <= 1000) {
            return true;
        } else
            return false;

    }

}

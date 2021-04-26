package firstChallenges;

public class SharedDigit {

    public static void main(String[] args) {

        System.out.println(hasSharedDigit(12, 23));

    }

    public static boolean hasSharedDigit(int firstNumber, int secondNumber) {
        int lastOfFirstNumber = 0;
        int firstOfFirstNumber = 0;
        int lastOfSecondNumber = 0;
        int firstOfSecondNumber = 0;


        if (firstNumber < 10 || secondNumber < 10 || firstNumber > 99 || secondNumber > 99) {
            return false;
        }
        while (firstNumber != 0) {
            lastOfFirstNumber = firstNumber % 10;
            firstOfFirstNumber = firstNumber / 10;
            break;

        }

        while (secondNumber != 0) {
            lastOfSecondNumber = secondNumber % 10;
            firstOfSecondNumber = secondNumber / 10;
            break;
        }

        if (firstOfFirstNumber == firstOfSecondNumber || lastOfSecondNumber == lastOfFirstNumber || firstOfFirstNumber == lastOfSecondNumber || lastOfFirstNumber == firstOfSecondNumber) {
            return true;
        } else
            return false;


    }

}

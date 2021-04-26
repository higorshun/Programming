package firstChallenges;

public class EvenDigitSum {

    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(123456789));

    }

    public static int getEvenDigitSum(int number) {
        int sumOfEvenNumber = 0;

        if (number < 0) {
            return -1;
        }

        while (number != 0) {
            int lastDigit = number % 10;
            if (lastDigit % 2 == 0) {
                sumOfEvenNumber += lastDigit;
            }

            number /= 10;


        }
        return sumOfEvenNumber;

    }


}

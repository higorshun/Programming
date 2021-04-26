package firstChallenges;

public class NumberToWords {

    public static void main(String[] args) {
        numberToWords(1450);

    }

    public static void numberToWords(int number) {
        int newRemainingNumber = reverse(number);

        if (number < 0) {

            System.out.println("Invalid Value");

        } else if (newRemainingNumber == 0) {

            System.out.println("Zero");

        }


        int lastDigit = 0;


        while (newRemainingNumber > 0) {
            lastDigit = newRemainingNumber % 10;
            newRemainingNumber = newRemainingNumber / 10;


            switch (lastDigit) {
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
                default:
                    System.out.println("Invalid Value");
                    break;

            }
        }

        if (getDigitCount(number) != getDigitCount(reverse(number))) {

            int howDifferentInZeros = getDigitCount(number) - getDigitCount(reverse(number));

            for (int i = 0; i < howDifferentInZeros; i++) {
                System.out.println("Zero");
            }
        }


    }

    public static int reverse(int number) {
        int newNumber = number;
        int lastDigit = 0;
        int finalResult = 0;

        while (newNumber != 0) {
            lastDigit = newNumber % 10;
            newNumber = newNumber / 10;
            finalResult = finalResult * 10 + lastDigit;

        }

        return finalResult;


    }

    public static int getDigitCount(int number) {
        int count = 0;

        if (number < 0) {
            return -1;
        }
        if (number == 0) {
            count = 1;
        }

        int dividedNumber = number;

        while (dividedNumber != 0) {
            dividedNumber = dividedNumber / 10;
            count++;

        }

        return count;

    }

}

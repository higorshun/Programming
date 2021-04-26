package firstChallenges;

public class LargestPrime {

    public static void main(String[] args) {
        System.out.println(getLargestPrime(16));

    }

    public static int getLargestPrime(int number) {
        int largestNumber = number;

        if (number <= 1) {
            return -1;
        } else if (number % 1 == 0 && number % number == 0) {

            // equanto o numero for menor do que i, acrescenta um numero a mais


            for (int i = 1; i < number; i++) {

                while (number % i == 0 && i != 1) {

                    int fator = number /= i;
                    if (fator > 1) {
                        largestNumber = fator;
                    }


                }


            }


        }
        return largestNumber;


    }
    // write your code here

}

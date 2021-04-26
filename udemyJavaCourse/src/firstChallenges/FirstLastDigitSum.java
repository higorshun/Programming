package firstChallenges;

public class FirstLastDigitSum {

    public static void main(String[] args) {

        System.out.println(sumFirstAndLastDigit(10));

    }


    public static int sumFirstAndLastDigit(int number){

        if (number<0){
            return -1;
        }

        int firstNumber = 0;
        int lastNumber = 0;

        while (number!=0){
            //extract first number
            firstNumber = number%10;
            //ignore other numbers
            while (number>=10){
                number/=10;
            }
            lastNumber = number;
            break;
            }

        return firstNumber + lastNumber;

    }
}

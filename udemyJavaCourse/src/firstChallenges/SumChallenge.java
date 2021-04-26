package firstChallenges;

public class SumChallenge {


    public static void main(String[] args) {
        sumDigits(125);

    }

    public static int sumDigits(int number){
        if (number < 10){
            return -1;
        }
        int lastDigits = 0;


         while(number>=10){

              number = number%10;
             lastDigits = number/10;

             System.out.println(lastDigits);
        }




        return lastDigits;
    }



}

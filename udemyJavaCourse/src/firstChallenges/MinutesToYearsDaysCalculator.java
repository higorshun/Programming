package firstChallenges;

public class MinutesToYearsDaysCalculator {

    public static void printYearsAndDays (long minutes){
        if (minutes<0){
            System.out.println("Invalid Value");
        } else {

            long d = (minutes / 60) / 24;
            long y = (d / 365);
            long remainingDays = d % 365;

            System.out.println(minutes + " min = " + y + " y and " + remainingDays + " d ");
        }

    }


}

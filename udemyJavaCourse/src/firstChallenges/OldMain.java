package firstChallenges;

public class OldMain {

    private static final String INVALID_VALUE_MESSAGE = "Invalid value";


    public static void main(String[] args) {

        System.out.println(getDurationString(65, 45));
        System.out.println(getDurationString(3945));
        System.out.println((getDurationString(-41)));
        System.out.println(getDurationString(65, 9));
        System.out.println(AreaCalculator.area(5, 4));
        MinutesToYearsDaysCalculator.printYearsAndDays(525600);
        IntEqualityPrinter.printEqual(1, 2, 3);
        System.out.println(PlayingCat.isCatPlaying(true, 10));
        System.out.println(PlayingCat.isCatPlaying(false, 36));
        System.out.println(PlayingCat.isCatPlaying(false, 35));
        System.out.println(NumberOfDaysInMonth.isLeapYear(2020));
        System.out.println(NumberOfDaysInMonth.getDaysInMonth(2, 1600));

        int count = 0;
        int sum = 0;


        for (int i = 1; i <= 1000; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                count++;
                sum += i;
                System.out.println("Found number = " + i);
            }
            if (count == 5) {
                break;
            }
        }
        System.out.println("Sum = " + sum);


    }


    public static String getDurationString(int minutes, int seconds) {

        if ((minutes < 0) || (seconds < 0) || (seconds > 59)) {
            return INVALID_VALUE_MESSAGE;
        }

        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;


        String hoursString = hours + "h ";
        if (hours < 10) {
            hoursString = "0" + hoursString;
        }
        String minutesString = remainingMinutes + "m ";
        if (remainingMinutes < 10) {
            minutesString = "0" + minutesString;
        }
        String secondsString = seconds + "s ";
        if (seconds < 10) {
            secondsString = "0" + secondsString;
        }

        return (hoursString + minutesString + secondsString);

    }

    public static String getDurationString(int seconds) {

        if (seconds < 0) {
            return INVALID_VALUE_MESSAGE;
        }

        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;

        return getDurationString(minutes, remainingSeconds);
    }
}

package firstChallenges;

public class NumberOfDaysInMonth {

    public static void main(String[] args) {

    }

    public static boolean isLeapYear(int year) {
        if (year <= 0 || year >= 10000) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if ((year % 100 != 0) && (year % 4 == 0)) {
            return true;
        } else {
            return false;
        }

    }

    public static int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12) {
            return -1;
        } else if (year < 0 || year > 9999) {
            return -1;
        } else if (isLeapYear(year)) {
            switch (month) {
                case 2:
                    return 29;
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
                default:
                    return 31;

            }
        } else {
            switch (month) {
                case 2:
                    return 28;
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
                default:
                    return 31;
            }
        }
    }
}



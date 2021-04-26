package firstChallenges;

public class GreatestCommonDivisor {

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(12, 30));
    }

    public static int getGreatestCommonDivisor(int first, int second) {
        int numberFound = 0;

        if (first < 10 || second < 10) {
            return -1;
        }
        for (int i = 1; i >= 1; i++) {

            if (first % i == 0 && second % i == 0) {
                numberFound = i;
            }
            if (i == first || i == second) {
                break;

            }

        }
        return numberFound;

    }
}

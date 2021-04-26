import java.util.Arrays;

public class Lab1Main {
    public static void main(String[] args) {
        int a = 5;//var for giving the size of the arrays
        int[] B = new int[a];
        int[] A = new int[a];

        for (int j = 0; j < A.length; j++) {//array that
            A[j] = (int) (Integer.MAX_VALUE * Math.random());
            System.out.println("The value of A is: " + A[j] + " And the position is: " + j);
        }
        System.out.println("Copying array A to b ");

        for (int j = 0; j < A.length; j++) {
            B[j] = A[j];
            System.out.println("The value of B is: " + B[j] + " And the position is: " + j);
        }
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if (A[j] > A[j + 1]) {   // use < for Descending order
                    int temp = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = temp;
                }
            }
        }
        long endTime1 = System.currentTimeMillis();
        long timeElapsed1 = (endTime1 - startTime1);
        System.out.println(Arrays.toString(A));
        System.out.println("Time for sorting A: " + timeElapsed1);

        long startTime2 = System.currentTimeMillis();
        Arrays.sort(B);
        long endTime2 = System.currentTimeMillis();
        long timeElapsed2 = (endTime2 - startTime2);
        System.out.println("Sorted B: " + Arrays.toString(B));
        System.out.println("Time for sorting B: " + timeElapsed2);
    }
}



/*
******* Report *******
***** The time that has been token to run the SelectionSort Method *****
* when ArraySize is 1,000 The time is 0.0190 sec
* when ArraySize is 10,000 the time is 0.210 sec
* when ArraySize is 100,000 the time is 16.154
***** The time that has been token to run the Arrays.sort Method *****
* when ArraySize is 1,000 The time is 0.001 sec
* when ArraySize is 10,000 the time is 0.016 sec
* when ArraySize is 100,000 the time is 0.115 sec
 */

import java.util.Arrays;
public class lab2 {
    static void BenchmarkingSortingAlgorithms(){
        // initializing the arrays size
        int ArraySize = 1000;
        // Create two arrays of type int[].
        int[] Array1 = new int[ArraySize];
        int[] Array2 = new int[ArraySize];
        //Fill the arrays with same random integers
        for(int i = 0; i < Array1.length; i++){
            Array1[i] = Array2[i] = (int)(Integer.MAX_VALUE * Math.random());
        }
        // Calculate computing time for SelectionSort
        long startTimeArray1 = System.currentTimeMillis();
        selectionSort(Array1);
        long runTimeArray1 = System.currentTimeMillis() - startTimeArray1;
        // Calculate computing time for Array.sort
        long startTimeArray2 = System.currentTimeMillis();
        Arrays.sort(Array2);
        long runTimeArray2 = System.currentTimeMillis() - startTimeArray2;
        // The results
        System.out.println("selectionSort computing time is "+ runTimeArray1/1000.0+" sec");
        System.out.println("Arrays.sort computing time is "+runTimeArray2/1000.0+ "sec" );
    }
    static void selectionSort(int[] A) {
// Sort A into increasing order, using selection sort
        for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {
           // Find the largest item among A[0], A[1], ...,
           // A[lastPlace], and move it into position lastPlace
           // by swapping it with the number that is currently
           // in position lastPlace.
            int maxLoc = 0;
            // Location of largest item seen so far.
            for (int j = 1; j <= lastPlace; j++) {
                if (A[j] > A[maxLoc]) {
            // Since A[j] is bigger than the maximum we’ve seen
            // so far, j is the new location of the maximum value
            // we’ve seen so far.
                    maxLoc = j;
                }
            }
            int temp = A[maxLoc]; // Swap largest item with A[lastPlace].
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;
        }
        // end of for loop
    }
    public static void main(String[] args) {
        BenchmarkingSortingAlgorithms();
    }

}
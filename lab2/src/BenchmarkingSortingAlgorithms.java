/** Here are the results after running this program:
 *
 * For 1_000 numbers:
 * Time to sort 1000 numbers in Array1 = 4 milliseconds.
 * Time to sort 1000 numbers in Array2 = 1 milliseconds.
 *
 * for 10_000 numbers:
 * Time to sort 10000 numbers in Array1 = 65 milliseconds.
 * Time to sort 10000 numbers in Array2 = 4 milliseconds.
 *
 * for 100_000 numbers:
 * Time to sort 100000 numbers in Array1 = 5158 milliseconds.
 * Time to sort 100000 numbers in Array2 = 36 milliseconds.
 *
 */

import java.util.Arrays;

public class BenchmarkingSortingAlgorithms {

    public static void main(String[] args) {
        int length = 100_000; // the length of the array

        int[] array1 = new int[length]; //first array
        int[] array2 = new int[length]; //second array

        for (int i = 0; i < length; i++) { // while numbers of items in array is less than size, fill with numbers
            //using the provided calculation to generate random numbers
            int randomNumbersGenerator = (int) (Integer.MAX_VALUE * Math.random());
            // putting each number generated in array1
            array1[i] = randomNumbersGenerator;
            //Since array2 has to be the same size and filled with same numbers,
            // just clone the array1
            array2[i] = array1[i];
        } //end of for loop


        //get the current system time and store in a variable
        long starTimeOfFirstArray = System.currentTimeMillis();
        //use the method selectionSort to sort numbers in array1
        selectionSort(array1);
        // get the time right after finishing the Selection Sort Method and
        // subtract from the previous current system time
        long amountOfTimeToRunTheFirstArray = System.currentTimeMillis() - starTimeOfFirstArray;
        // print out the result on console
        System.out.println("Time to sort "+ length +" numbers in Array1 = " + (amountOfTimeToRunTheFirstArray) + " milliseconds.");


        //get the current system time and store in a variable
        long startTimeOfSecondArray = System.currentTimeMillis();
        //use this Java built-in method to sort the array
        Arrays.sort(array2);
        // get the time right after finishing the sort and subtract from the previous current system time
        long amountOfTimeToRunTheSecondArray = System.currentTimeMillis() - startTimeOfSecondArray;
        // print out the result on console
        System.out.println("Time to sort " + length + " numbers in Array2 = " + (amountOfTimeToRunTheSecondArray) + " milliseconds.");

    }


    static void selectionSort(int[] A) {
        // Sort A into increasing order, using selection sort
        for (int lastPlace = A.length - 1; lastPlace > 0; lastPlace--) {
            // Find the largest item among A[0], A[1], ...,
            // A[lastPlace], and move it into position lastPlace
            // by swapping it with the number that is currently
            // in position lastPlace.
            int maxLoc = 0;  // Location of largest item seen so far.
            for (int j = 1; j <= lastPlace; j++) {
                if (A[j] > A[maxLoc]) {
                    // Since A[j] is bigger than the maximum we've seen
                    // so far, j is the new location of the maximum value
                    // we've seen so far.
                    maxLoc = j;
                }
            }
            int temp = A[maxLoc];  // Swap largest item with A[lastPlace].
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;

        }  // end of for loop
    }

}

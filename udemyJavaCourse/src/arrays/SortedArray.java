package arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Create a program using arrays that sorts a list of integers in descending order.
 * <p>
 * Descending order is highest value to lowest.
 * <p>
 * In other words if the array had the values in it [106, 26, 81, 5, 15] your program
 * should ultimately have an array with [106, 81, 26, 15, 5] in it.
 * <p>
 * Set up the program so that the numbers to sort are read in from the keyboard (Scanner).
 * <p>
 * Implement the following methods:
 * <p>
 * <p>
 * <p>
 * <p>
 * sortIntegers accepts the unsorted array. It should sort the array and return a new array containing the sorted
 * numbers.
 * <p>
 * The scenario is:
 * <p>
 * 1. getIntegers() is called.
 * <p>
 * 2. The returned array from getIntegers() is then used to call sortIntegers().
 * <p>
 * 3. The returned array from sortIntegers() is then printed to the console.
 * <p>
 * [Do not try and implement this. It is to give you an idea of how the methods will be used]
 * <p>
 * TIP: you will have to figure out how to copy the array elements
 * from the passed array into a new array and sort them and return the new sorted array.
 * <p>
 * TIP: Instantiate (create) the Scanner object inside the method.
 * <p>
 * TIP: Be extremely careful about spaces in the printed message.
 * <p>
 * TIP: Make sure the Scanner class is imported.
 * <p>
 * NOTE: All methods should be defined as public static NOT public.
 * <p>
 * NOTE: Do not add a main method to the solution code.
 */

public class SortedArray {

    public static void main(String[] args) {

        SortedArray sortedArray = new SortedArray();

        System.out.println("Enter some number:");
        int[] array = sortedArray.getIntegers(3);
        sortArray(array);

    }

    /**
     * getIntegers has one parameter of type int which is the size of the array.
     * It returns an array of entered integers from the keyboard.
     */

    public static int[] getIntegers(int sizeOfArray) {
        Scanner s = new Scanner(System.in);
        int index = 0;
        int[] array = new int[sizeOfArray];
        for (index = 0; index < array.length; index++) {
            int number = s.nextInt();
            array[index] = number;
        }
        s.close();

        return array;

    }

    public static int[] sortArray(int[] array) {

        Arrays.sort(array);
        int[] reverseSortedNum = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reverseSortedNum[i] = array[array.length - 1 - i];
        }
        printArray(array);
        return array;
    }


    /**
     * printArray accepts an array and prints out the contents of the array.
     * It should be printed in the following format:
     * Element 0 contents 106
     * Element 1 contents 81
     * Element 2 contents 26
     * Element 3 contents 15
     * Element 4 contents 5
     */

    public static void printArray(int[] array) {
        int elementOfArray;
        for (elementOfArray = 0; elementOfArray < array.length; elementOfArray++) {
            int valueOfElement = array[elementOfArray];
            System.out.print("Element " + elementOfArray + " contents " + valueOfElement + "\n");
        }

    }

}

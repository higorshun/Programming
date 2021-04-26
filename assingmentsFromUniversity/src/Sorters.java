import java.util.Arrays;


/** @author lombe
 * @param `int[] A` : this is the array that is going to be sorted
 * by the algorithms
 * this program compares the processing time of 
 * two sorting algorithms:
 * insertionSort and selectionSort
 * against the processing time of the arrays built-in function:
 * Arrays.sort()
 */
public class Sorters {
	final static int CONST=10000;

	static int[] arr1 = new int[CONST];
	static int[] arr2 = new int[CONST];
	
	public static void insertionSort(int[] A) {
		// Sort the array A into increasing order.
		int itemsSorted; // Number of items that have been sorted so far.
		for (itemsSorted = 1; itemsSorted < A.length; itemsSorted++) {
		// Assume that items A[0], A[1], ... A[itemsSorted-1]
		// have already been sorted. Insert A[itemsSorted]
		// into the sorted part of the list.
			int temp = A[itemsSorted]; // The item to be inserted.
			int loc = itemsSorted - 1; // Start at end of list.
			while (loc >= 0 && A[loc] > temp) {
				A[loc + 1] = A[loc]; // Bump item from A[loc] up to loc+1.
				loc = loc - 1; // Go on to next location.
			}
			A[loc + 1] = temp; // Put temp in last vacated space.
		}
	}
	public static void selectionSort(int[] A) {
		// Sort A into increasing order, using selection sort
		for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {
			// Find the largest item among A[0], A[1], ...,
			// A[lastPlace], and move it into position lastPlace
			// by swapping it with the number that is currently
			// in position lastPlace.
			int maxLoc = 0; // Location of largest item seen so far.
			for (int j = 1; j <= lastPlace; j++) {
				if (A[j] > A[maxLoc]) {
					// Since A[j] is bigger than the maximum we�ve seen
					// so far, j is the new location of the maximum value
					// we�ve seen so far.
					maxLoc = j;
				}
			}
			int temp = A[maxLoc]; // Swap largest item with A[lastPlace].
			A[maxLoc] = A[lastPlace];
			A[lastPlace] = temp;
		} // end of for loop
	}
	
	public static void main(String[] args) {
		
		for( int i=0; i<arr1.length; i++) {
			// loop to assign values randomly 
			//to arr1 and arr2
			arr1[i] = (int)(Integer.MAX_VALUE * Math.random());
			arr2[i] =arr1[i];
		}
		
		
		long startTime_arr1= System.currentTimeMillis();//time at start of operation
		insertionSort(arr1);
		long endTime_arr1= System.currentTimeMillis();//time at end of operation
		long startTime_arr2= System.currentTimeMillis();//time at start of operation
		Arrays.sort(arr2);;
		long endTime_arr2= System.currentTimeMillis();//time at end of operation
	
		System.out.println("duration for insertSort in milliseconds: " + (endTime_arr1-startTime_arr1) );
		System.out.println("duration for Arrays.sort in milliseconds: " + (endTime_arr2-startTime_arr2) );
		
		//String a= Arrays.toString(arr1);//returns a string representation of the arrays
		//String b= Arrays.toString(arr2);
		//System.out.println(a);
		//System.out.println(b);
	}
	

}

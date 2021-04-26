public class Unit2 {

    public static void main(String[] args) {
        // xMethod(5);
        //xMethod1(5);
    }

    public static void xMethod(int length) {
        if (length > 1) {
            System.out.print((length - 1) + " ");
            xMethod(length - 1);
        }
    }


    public static void xMethod1(int length) {
        while (length > 1) {
            System.out.print((length - 1) + " ");
            xMethod(length - 1);
        }
    }


    public static void sort(double[] list) {
        //
    }

    public static void sort(double[] list, int high) {
        if (high > 1) {
            // Find the largest number and its index
            int indexOfMax = 0;
            double max = list[0];
            for (int i = 1; i <= high; i++) {
                if (list[i] > max) {
                    max = list[i];
                    indexOfMax = i;
                }
            }
// Swap the largest with the last number in the list
            list[indexOfMax] = list[high];
            list[high] = max;
// Sort the remaining list
            sort(list, high - 1);
        }
    }


}

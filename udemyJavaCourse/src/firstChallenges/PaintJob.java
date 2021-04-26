package firstChallenges;

public class PaintJob {

    public static void main(String[] args) {


        System.out.println(getBucketCount(3.4, 2.1, 1.5, 2));
        System.out.println(getBucketCount(3.4, 2.1, 1.5));
        System.out.println(getBucketCount(3.4, 1.5));

    }

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {
        double bucketsToTake = 0;
        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets <= 0) {
            return -1;

        } else {

            bucketsToTake = ((width * height) / areaPerBucket) - extraBuckets;

        }
        return (int) Math.ceil(bucketsToTake);

    } // end of the method getBucketCount

    public static int getBucketCount(double width, double height, double areaPerBucket) {
        double bucketsToTake = 0;
        if (width <= 0 || height <= 0 || areaPerBucket <= 0) {
            return -1;

        } else {

            bucketsToTake = ((width * height) / areaPerBucket);

        }
        return (int) Math.ceil(bucketsToTake);

    } // end of the method getBucketCount

    public static int getBucketCount(double area, double areaPerBucket) {

        double bucketsToTake = 0;
        if (area <= 0 || areaPerBucket <= 0) {
            return -1;
        } else {

            bucketsToTake = area / areaPerBucket;

        }
        return (int) Math.ceil(bucketsToTake);

    } // end of overload method getBucketCount

} // end of class Paint Job
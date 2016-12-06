import java.util.Random;

public class MyMath {

    /**
     * This method calculates the maximum number
     * @param num array of integers
     * @return maximum integer
     */

    public static Integer maxNumber(int[] num) {
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
            }
        }
        return max;
    }

    /**
     * This method calculates the average number in an array of doubles
     * @param num array of doubles
     * @return average number
     */

    public static Double averageNumber(double[] num) {
        double average = 0;
        for (int i = 0; i < num.length; i++) {
            average += num[i];
        }
        average = average / num.length;
        return average;
    }

    /**
     * This method calculates the average number in an array of ints
     * @param num array of integers
     * @return average number
     */

    public static Double averageNumber(int[] num) {
        double average = 0;
        for (int i = 0; i < num.length; i++) {
            average += num[i];
        }
        average = average / num.length;
        return average;
    }

    /**
     * This method computes a random int
     * @param min minimum number (inclusive)
     * @param max maximum number (inclusive)
     * @return random number between min and max parameters
     */

    public static int randomInt(int min, int max) {
        Random foo = new Random();
        int x = (max - min) + 1;
        int rand = foo.nextInt(x) + min;
        return rand;
    }


}

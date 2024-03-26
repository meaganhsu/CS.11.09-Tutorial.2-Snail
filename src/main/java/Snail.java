import java.util.*;

public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {
        if (array2d == null || !isPerfectSquare(array2d)) {
            return new int[0];
        }

        int[] x = new int[array2d.length*array2d.length];
        int row = 0;
        int col = 0;
        int direction = 1;       // n = 4, e = 1, s = 2, w = 3
        int count = 0;    // 4,3,3,2,2,1,1 (len.arr,len-1x2,len-2x2...)

        for (int i = 0; i < x.length; i++) {
            if (direction == 1) {      // right
                x[i] = array2d[row][col++];
                if (col == array2d.length-count-1) {
                    direction++;    // shifting down
                }
            } else if (direction == 2) {        // down
                x[i] = array2d[row++][col];
                if (row == array2d.length-count-1) {
                    direction++;    // shifting left
                }
            } else if (direction == 3) {      // left
                x[i] = array2d[row][col--];
                if (col == count) {
                    direction++;      // shifting up
                    count++;
                }
            } else if (direction == 4) {       // up
                x[i] = array2d[row--][col];
                if (row == count-1) {
                    direction = 1;      // shifting right
                    col++;
                    row++;
                }
            }
        }

        return x;
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        if (array1d == null || !isPerfectSquare(array1d)) {
            return new int[0][0];
        }

        int[][] x = new int[(int) Math.sqrt(array1d.length)][(int) Math.sqrt(array1d.length)];
        int row = 0;
        int col = 0;
        int direction = 1;       // n = 4, e = 1, s = 2, w = 3
        int count = 0;    // 4,3,3,2,2,1,1 (len.arr,len-1x2,len-2x2...)

        for (int i = 0; i < array1d.length; i++) {
            if (direction == 1) {      // right
                 x[row][col++] = array1d[i];
                 if (col == x.length-count-1) {
                     direction++;    // shifting down
                 }
            } else if (direction == 2) {        // down
                 x[row++][col] = array1d[i];
                 if (row == x.length-count-1) {
                     direction++;    // shifting left
                 }
            } else if (direction == 3) {      // left
                 x[row][col--] = array1d[i];
                 if (col == count) {
                     direction++;      // shifting up
                     count++;
                 }
            } else if (direction == 4) {       // up
                 x[row--][col] = array1d[i];
                 if (row == count-1) {
                     direction = 1;      // shifting right
                     col++;
                     row++;
                 }
            }
        }

        return x;
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        for (int i : array1d) {
            System.out.print(i + " ");
        }
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        for (int[] i : array2d) {
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        double x = Math.sqrt(array1d.length);
        return ((x - Math.floor(x)) == 0);
    }

    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        for (int i = 0; i < array2d.length; i++) {
            if (array2d.length != array2d[i].length) return false;
        }

        return true;
    }
}

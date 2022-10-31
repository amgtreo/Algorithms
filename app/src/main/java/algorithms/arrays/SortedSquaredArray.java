package algorithms.arrays;

;

public class SortedSquaredArray {
    public static void main(String[] args) {
        //[1, 4, 9, 16, 25]
        for (int i : sortedSquaredArray(new int[]{-5, -4, -3, -2, -1})) {
            System.out.print(i + ", ");
        }
        System.out.println();
        //[1, 4, 9, 25, 36, 64, 81]
        for (int i : sortedSquaredArray(new int[]{1, 2, 3, 5, 6, 8, 9})) {
            System.out.print(i + ", ");
        }
    }

    public static int[] sortedSquaredArray(int[] array) {
        int counter = array.length - 1;
        int firstIdx = 0;
        int lastIdx = array.length - 1;

        int[] out = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (Math.abs(array[firstIdx]) > Math.abs(array[lastIdx])) {
                out[counter - i] = array[firstIdx] * array[firstIdx];
                firstIdx++;
            } else {
                out[counter - i] = array[lastIdx] * array[lastIdx];
                lastIdx--;
            }
        }
        return out;
    }
}

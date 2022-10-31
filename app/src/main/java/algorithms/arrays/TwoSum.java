package algorithms.arrays;;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {

        System.out.println(twoNumberSum(new int[]{3, 5, 6, 7, 8, 9}, 10));
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {

        Set<Integer> vals = new HashSet<>();

        for (int num : array) {
            if (vals.contains(targetSum - num)) {
                return new int[]{targetSum - num, num};
            } else {
                vals.add(num);
            }
        }

        return new int[0];
    }
}


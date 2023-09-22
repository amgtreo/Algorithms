package algorithms.dynamic;

public class SlidingWindow {

    public static void main(String []args){
        int []arr = { 5, 7, 1, 4, 3, 6, 2, 9, 2 };
        System.out.println(getLargestSumOfFiveConsecutiveElements(arr));
    }

    private static int getLargestSumOfFiveConsecutiveElements (int []arr) {
        int currSum = getSum(arr, 0, 4);
        int largestSum = currSum;

        for (int i = 1; i <= arr.length - 5; i++) {
            currSum -= arr[i - 1]; // subtract element to the left of curr window
            currSum += arr[i + 4]; // add last element in curr window
            largestSum = Math.max(largestSum, currSum);
        }

        return largestSum;
    }

    private static int getSum (int []arr, int start, int end) {
        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }

        return sum;
    }
}

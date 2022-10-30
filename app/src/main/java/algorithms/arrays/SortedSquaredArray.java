package arrays;

public class SortedSquaredArray {
    public static void main(String[] args){
        System.out.println(sortedSquaredArray(new int[]{1, 2, 3, 5, 6, 8, 9})); //[1, 4, 9, 25, 36, 64, 81]
    }

    public static int[] sortedSquaredArray(int[] array) {
        int prev_val = 0;
        int current_val = 0;
        int[] output = new int[array.length];
        for(int x = 0; x < array.length; x++){
            current_val = (int)Math.sqrt(array[x]);
            if(current_val >= prev_val){
                output[x] = current_val;
            }else{
                prev_val = current_val;
                current_val = output[x - 1];
                output[x - 1] = prev_val;
                output[x] = current_val;
            }
        }
        return output;
    }
}

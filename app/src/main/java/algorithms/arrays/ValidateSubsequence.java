package algorithms.arrays;;

import java.util.List;

public class ValidateSubsequence {

    public static void main(String[] args) {
        System.out.println(isValidSubsequence(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(5, 1, 22, 25, 6, -1, 8, 10))); //true
        System.out.println(isValidSubsequence(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(1, 6, -1, -1))); //false
        System.out.println(isValidSubsequence(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(26))); //false
        System.out.println(isValidSubsequence(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(1, 6, -1, 10, 11, 11, 11, 11))); //false
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int seq_pointer = 0;
        int array_pointer = 0;

        while (array_pointer < array.size() && seq_pointer < sequence.size()) {
            if (sequence.get(seq_pointer) == array.get(array_pointer)) {
                seq_pointer++;
            }
            array_pointer++;
        }
        return seq_pointer == sequence.size();
    }
}


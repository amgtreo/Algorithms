package algorithms.strings;

public class ReverseWords {
    public static void main(String []args){
        String input = "guadalajara";
        String reverseWords = "lajaraguada";
        System.out.println(containsWord(input, reverseWords));
    }

    private static boolean containsWord(String input, String reverseWords) {
        return reverseWords.concat(reverseWords).contains(input);
    }
}

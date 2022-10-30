package strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public static void main(String[] args) {
        RomanToInt exec = new RomanToInt();
        System.out.println(exec.romanToInt("III")); //3
        System.out.println(exec.romanToInt("LVIII")); //58
        System.out.println(exec.romanToInt("MCMXCIV"));//1994
    }

    private static final Map<Character, Integer> roman = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    /*
      If present value is less than next value,
      subtract present from next value and add the
      resultant to the sum variable.
     */
    private static int romanToInt(String s) {

        int sum = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (i != n - 1 && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                sum += roman.get(s.charAt(i + 1)) - roman.get(s.charAt(i));
                i++;
            } else {
                sum += roman.get(s.charAt(i));
            }
        }
        return sum;
    }
}

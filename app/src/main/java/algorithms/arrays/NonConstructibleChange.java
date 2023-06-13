package algorithms.arrays;

import java.util.Arrays;

/**
 * Given an array of positive integers representing the values of coins in your
 * possession, write a function that returns the minimum amount of change (the
 * minimum sum of money) that you cannot create. The given coins can have
 * any positive integer value and aren't necessarily unique (i.e., you can have
 * multiple coins of the same value).
 * <p>
 * <p>
 * For example, if you're given coins = [1, 2, 5], the minimum
 * amount of change that you can't create is 4. If you're given no
 * coins, the minimum amount of change that you can't create is 1.
 * <p>
 * Start by sorting the input array. Since you're trying to find the minimum  amount of change that you can't create, it makes sense to
 * consider the smallest coins first.
 * <p>
 * <p>
 * One approach to solve this problem is to attempt to create every single amount
 * of change, starting at 1 and going up until you eventually can't create an
 * amount. While this approach works, there is a better one.
 * <p>
 * <p>
 * To understand the trick to this problem, consider the following example:
 * coins = [1, 2, 4]. With this set of coins, we can create
 * 1, 2, 3, 4, 5, 6, 7 cents worth of change. Now, if we were to add
 * a coin of value 9 to this set, we would not be able to
 * create 8 cents. However, if we were to add a coin of value
 * 7, we would be able to create 8 cents, and we
 * would also be able to create all values of change from 1 to
 * 15. Why is this the case?
 *
 *
 <p>
 Create a variable to store the amount of change that you can currently create
 up to. Sort all of your coins, and loop through them in ascending order. At
 every iteration, compare the current coin to the amount of change that you can
 currently create up to. Here are the two scenarios that you'll encounter:
 </p>
 <ul>
 <li>
 The coin value is <b>greater</b> than the amount of change that you can
 currently create plus 1.
 </li>
 <li>
 The coin value is <b>smaller than or equal to</b> the amount of change that
 you can currently create plus 1.
 </li>
 </ul>
 <p>
 In the first scenario, you simply return the current amount of change that you
 can create plus 1, because you can't create that amount of change. In the
 second scenario, you add the value of the coin to the amount of change that
 you can currently create up to, and you continue iterating through the coins.
 </p>
 <p>
 The reason for this is that, if you're in the second scenario, you can create
 all of the values of change that you can currently create plus the value of
 the coin that you just considered. If you're given coins <span>[1, 2]</span>,
 then you can make <span>1, 2, 3</span> cents. So if you add a coin of value
 <span>4</span>, then you can make <span>4 + 1</span> cents,
 <span>4 + 2</span> cents, and <span>4 + 3</span> cents. Thus, you can make up
 to <span>7</span> cents.
 </p>
 */

public class NonConstructibleChange {

    public static void main(String[] args) {
        int[] test1 = {5, 7, 1, 1, 2, 3, 22}; //20
        int[] test2 = {1, 2, 5};//4
        int[] test3 = {1, 1, 1, 1, 1};//5
        int[] test4 = {1, 5, 1, 1, 1, 10, 15, 20, 100};//55
        System.out.println(nonConstructibleChange(test1));
        System.out.println(nonConstructibleChange(test2));
        System.out.println(nonConstructibleChange(test3));
        System.out.println(nonConstructibleChange(test4));
    }

    private static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);

        int currentChangeCreated = 0;

        for (int coin : coins) {
            if (coin > currentChangeCreated + 1) return currentChangeCreated + 1;
            currentChangeCreated += coin;
        }

        return currentChangeCreated + 1;
    }
}

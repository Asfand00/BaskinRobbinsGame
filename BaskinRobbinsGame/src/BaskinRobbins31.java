import java.util.HashMap;
import java.util.Map;

/**
 * This is the BaskinRobbins31 game done using recursion
 * and incorporating Hashmap to store a cache of previous values
 * to track the recursion
 *
 * @author Asfandyar Tanwer
 * @version 1.0
 */
public class BaskinRobbins31 {

    /**
     * Handle Memoization using hashmap, integrated with
     * countWaysToReachEnd method
     */
    static Map<Integer, Integer> cache = new HashMap<>();

    /**
     * The main recursion method that takes an int n number ex. 31
     * and returns the number of ways to reach that n
     * @param n the base number
     * @return the number of ways to reach base number
     */
    public static int countWaysToReachEnd(int n) {
        // does the current key contain a value
        if(cache.containsKey(n)) {
            // return the value
            return cache.get(n);
        }
        int ways;
        if (n <= 0) {
            return 0; // for safety, no negatives
        }
        else if(n == 1) {
            return 1; // Baseline 1: one way to reach 1, say "1"
        }
        else if(n == 2) {
            return 2; // Baseline 2: two ways to say 2, say "1" or "1,2"
        }
        else {
            // the number of ways to reach 'n' is the sum of the ways to reach 'n-1' and 'n-2'
            ways = countWaysToReachEnd(n-1) + countWaysToReachEnd(n-2);
            // store in cache, (key n, value ways)
            cache.put(n, ways);
            // return recursion
            return ways;
        }
    }

    /**
     * The main method to run the recursion method above
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // test case: n = 5, 8 ways to say 5. See .drawio file for visual
        int testCase = 5;
        int testWay = countWaysToReachEnd(testCase);
        System.out.println("Number of ways to reach " + testCase + " is: " + testWay + "\n");
        int n = 31;
        int ways = countWaysToReachEnd(n);
        System.out.println("Number of ways to reach " + n + " is: " + ways);
    }
}

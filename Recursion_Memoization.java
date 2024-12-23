import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Recursion_Memoization {


    public static int countWaysRecursive(int[] balls, int white, int black) {
        return countWays(0, 0, balls, white, black, true, new HashMap<>());
    }

    private static int countWays(int index, int ballOffset, int[] balls, int white, int black, boolean isWhite, Map<String, Integer> memo) {

        if (index >= balls.length && ballOffset == 0) {
            return 1;
        }
        if (index >= balls.length) {
            return 0;
        }


        String key = index + "_" + ballOffset + "_" + isWhite;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int ways = 0;


        int currentBallCount = balls[index];
        int remainingBalls = currentBallCount - ballOffset;


        if (isWhite) {
            if (remainingBalls >= white) {
                ways += countWays(index, ballOffset + white, balls, white, black, false, memo);
            }
            if (remainingBalls == white) {
                ways += countWays(index + 1, 0, balls, white, black, false, memo);
            }
        }


        if (!isWhite) {
            if (remainingBalls >= black) {
                ways += countWays(index, ballOffset + black, balls, white, black, true, memo);
            }
            if (remainingBalls == black) {
                ways += countWays(index + 1, 0, balls, white, black, true, memo);
            }
        }

        
        memo.put(key, ways);
        return ways;
    }

    public static void main(String[] args) {
        int[] balls = {2, 2};
        int white = 1, black = 2;
        System.out.println("Single Function Result: " + countWaysRecursive(balls, white, black));

        balls = new int[]{2, 1, 3};
        white = 1;
        black = 1;
        System.out.println("Single Function Result: " + countWaysRecursive(balls, white, black));
    }
}

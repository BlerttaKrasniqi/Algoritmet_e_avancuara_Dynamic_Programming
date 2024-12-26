import java.util.*;

public class DynamicProgramming {

    public static int countWaysDP(int[] balls, int white, int black) {
        int n = Arrays.stream(balls).sum(); 
        int[] row = new int[n];


        int index = 0;
        boolean isWhite = true;
        for (int count : balls) {
            for (int j = 0; j < count; j++) {
                row[index++] = isWhite ? 1 : 0;
            }
            isWhite = !isWhite;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int whiteCount = 0, blackCount = 0;
            for (int j = i; j > 0; j--) {
                if (row[j - 1] == 1) {
                    whiteCount++;
                } else {
                    blackCount++;
                }

                if (whiteCount == white) {
                    dp[i] += dp[j - 1];
                }

                if (blackCount == black) {
                    dp[i] += dp[j - 1];
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] balls = {2, 2};
        int white = 1, black = 2;
        System.out.println("Dynamic Programming Result: " + countWaysDP(balls, white, black));

        balls = new int[]{2, 1, 3};
        white = 1;
        black = 1;
        System.out.println("Dynamic Programming Result: " + countWaysDP(balls, white, black));



        balls = new int[]{1,1,1,1,1};
        white = 1;
        black = 1;
        System.out.println("Dynamic Programming Result: " + countWaysDP(balls, white, black));

    }
}









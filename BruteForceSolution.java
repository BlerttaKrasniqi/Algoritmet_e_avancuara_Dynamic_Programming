import java.util.*;

public class BruteForceSolution {

    public static int countWaysBruteForce(int[] balls, int white, int black) {

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


        return countWaysHelper(row, 0, white, black);
    }

    private static int countWaysHelper(int[] row, int start, int white, int black) {

        if (start == row.length) {
            return 1;
        }

        int ways = 0;
        int whiteCount = 0, blackCount = 0;


        for (int i = start; i < row.length; i++) {
            if (row[i] == 1) {
                whiteCount++;
            } else {
                blackCount++;
            }


            if (whiteCount == white) {
                ways += countWaysHelper(row, i + 1, white, black);
            }


            if (blackCount == black) {
                ways += countWaysHelper(row, i + 1, white, black);
            }
        }

        return ways;
    }

    public static void main(String[] args) {
        int[] balls = {2, 2};
        int white = 1, black = 2;
        System.out.println("Brute Force Solution Result: " + countWaysBruteForce(balls, white, black));

        balls = new int[]{2, 1, 3};
        white = 1;
        black = 1;
        System.out.println("Brute Force Solution Result: " + countWaysBruteForce(balls, white, black));

        balls = new int[]{1, 1, 1, 1, 1};
        white = 1;
        black = 1;
        System.out.println("Brute Force Solution Result: " + countWaysBruteForce(balls, white, black));
    }
}

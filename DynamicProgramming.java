import java.util.*;

public class DynamicProgramming {

    public static int countWaysRecursive(int[] balls, int white, int black) {

        int n = Arrays.stream(balls).sum();
        int[] row = new int[n];
        int index = 0;
        boolean isWhite = true;

        for (int count : balls) {
            for (int i = 0; i < count; i++) {
                row[index++] = isWhite ? 1 : 0;
            }
            isWhite = !isWhite;
        }


        return backtrack(row, 0, white, black);
    }

    private static int backtrack(int[] row, int start, int white, int black) {
        if (start == row.length) {
            return 1;
        }

        int totalWays = 0;


        int whiteCount = 0;
        for (int i = start; i < row.length; i++) {
            if (row[i] == 1) {
                whiteCount++;
            }
            if (whiteCount == white) {
                totalWays += backtrack(row, i + 1, white, black);
                break;
            }
        }


        int blackCount = 0;
        for (int i = start; i < row.length; i++) {
            if (row[i] == 0) {
                blackCount++;
            }
            if (blackCount == black) {
                totalWays += backtrack(row, i + 1, white, black);
                break;
            }
        }

        return totalWays;
    }

    public static void main(String[] args){
        int[] balls = {2, 2};
        int white = 1, black = 2;
        System.out.println("Recursive Backtracking Result: " + countWaysRecursive(balls, white, black));

        balls = new int[]{2, 1, 3};
        white = 1;
        black = 1;
        System.out.println("Recursive Backtracking Result: " + countWaysRecursive(balls, white, black));

        balls = new int[]{1, 1, 1, 1, 1};
        white = 1;
        black = 1;
        System.out.println("Recursive Backtracking Result: " + countWaysRecursive(balls, white, black));

    }
}

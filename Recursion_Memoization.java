import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Recursion_Memoization {

    private static int simulate(int[] row, int white, int black) {
        int totalWays = 0;
        int currentIndex = 0;

        while (currentIndex < row.length) {
            int whiteCount = 0, blackCount = 0;


            for (int i = currentIndex; i < row.length; i++) {
                if (row[i] == 1) whiteCount++;
                if (whiteCount == white) {
                    totalWays++;
                    currentIndex = i + 1;
                    break;
                }
            }

            for (int i = currentIndex; i < row.length; i++) {
                if (row[i] == 0) blackCount++;
                if (blackCount == black) {
                    totalWays++;
                    currentIndex = i + 1;
                    break;
                }
            }
        }

        return totalWays;
    }


    public static int count_ways(int[] balls, int white, int black){
        int n = Arrays.stream(balls).sum();
        int[] row = new int[n];

        int index = 0;
        boolean WhiteBall = true;
        for (int count:balls){
            for(int j=0;j<count;j++){
                row[index++]=WhiteBall ?1:0;

            }
            WhiteBall=!WhiteBall;
        }

        return simulate(row, white, black);
    }
    public static void main(String[] args){
        int[] balls1 = {2, 2};
        int white1 = 1, black1 = 2;
        System.out.println(" Result: " + count_ways(balls1, white1, black1));

        int[] balls2 = {2, 1, 3};
        int white2 = 1, black2 = 1;
        System.out.println(" Result: " + count_ways(balls2, white2, black2));

        int[] balls3 = {1, 1, 1, 1, 1};
        int white3 = 1, black3 = 1;
        System.out.println(" Result: " + count_ways(balls3, white3, black3));

    }


}

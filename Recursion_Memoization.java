import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Recursion_Memoization {

    private static int simulate(int[] row, int white, int black, int start,Map<String, Integer>store) {
        if (start == row.length) {
            return 1;
        }

        String key = start + "-"+black;
        if(store.containsKey(key)){
            return store.get(key);
        }

        int whiteCount = 0, blackCount = 0, ways = 0;

        for (int i = start; i < row.length; i++) {
            if (row[i] == 1) {
                whiteCount++;
            } else {
                blackCount++;
            }


            if (whiteCount == white) {
                ways += countWaysHelper(row, white, black, i + 1,store);
            }

            
            if (blackCount == black) {
                ways += countWaysHelper(row, white, black, i + 1,store);
            }
        }
        store.put(key,ways);

        return ways;
    }


    public static int count_ways(int[] balls, int white, int black){
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

        Map<String, Integer>store = new HashMap<>();

        return countWaysHelper(row, white, black, 0,store);
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

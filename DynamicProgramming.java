import java.util.*;

public class DynamicProgramming {

    public static int DP_count(int[] balls, int white, int black){
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


        int[] count_ways = new int[n+1];
        count_ways[0]=1;

        for(int i=1;i<=n;i++){
            int whitecount=0;
            int blackcount  =0;
            for(int j=i;j>0;j--){
                if(row[j-1]==1){
                    whitecount++;
                }
                else{
                    blackcount++;
                }
                if (white == white) {
                    count_ways[i] += count_ways[j - 1];
                }
                if (blackcount == black) {
                    count_ways[i] += count_ways[j - 1];
                }
            }
        }
        return count_ways[n];
    }
    public static void main(String[] args){

        int[] balls = {2, 2};
        int white = 1, black = 2;
        System.out.println("Dynamic Programming Result: " + DP_count(balls, white, black));

        balls = new int[]{2, 1, 3};
        white = 1;
        black = 1;
        System.out.println("Dynamic Programming Result: " + DP_count(balls, white, black));

    }
}

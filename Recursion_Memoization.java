import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Recursion_Memoization {

    private static int BackTrack(int[] row, int start, int white, int black, boolean WhiteSegment){
        if(start==row.length){
            return 1;
        }
        int count=0;
        int whitecount=0;
        int blackcount=0;
        for(int i=start;i<row.length;i++){
            if(row[i]==1){
                whitecount++;
            }
            else{
                blackcount++;
            }
            if(WhiteSegment && whitecount==white){
                count+=BackTrack(row,i+1,white,black,false);
            }
            else if(!WhiteSegment && blackcount==black){
                count+=BackTrack(row,i+1,white,black,true);
            }
        }
        return count;
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

        return BackTrack(row,0,white,black,true)+BackTrack(row,0,white,black,false);
    }
    public static void main(String[] args){
        int[] balls = {2, 2};
        int white = 1, black = 2;
        System.out.println("Backtracking Result: " + count_ways(balls, white, black));

        balls = new int[]{2, 1, 3};
        white = 1;
        black = 1;
        System.out.println("Backtracking Result: " + count_ways(balls, white, black));

    }


}

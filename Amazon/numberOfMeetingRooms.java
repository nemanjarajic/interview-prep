package Amazon;

import java.util.*;

public class numberOfMeetingRooms {
    public static int solution(int [][] arr){
        int [][] starts = arr;
        int [][] ends = arr;
        Arrays.sort(starts, (a,b)->Integer.compare(a[0], b[0]));
        Arrays.sort(ends, (a,b)->Integer.compare(a[1], b[1]));


        
        int res = 0, curr =0;
        int s = 0, e = 0;

        while (s < arr.length){
            if(starts[s][0] < ends[e][1]){
                s++;
                curr++;
            }else{
                e++;
                curr--;
            }
            res = Math.max(res, curr);
        }

        return res;

    }

    public static void main(String[] args) {
        int [][] arr = {{9,10},{4,9},{5,7}};

        System.out.print(solution(arr));
    }
}

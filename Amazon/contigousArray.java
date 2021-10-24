package Amazon;

import java.util.*;

public class contigousArray {
    public static int solution(int [] nums){
        if(nums == null || nums.length == 0) return 0;

        int res = 0;

        HashMap<Integer,Integer> m = new HashMap<>();

        m.put(0,-1);
        int sum = 0;
        for(int i =0; i < nums.length; i++){
            sum += nums[i] == 0? -1:1;
            Integer prev = m.get(sum);
            if(prev != null){
                res = Math.max(res, i-prev);
            }else{
                m.put(sum,i);
            }
        }

        return res;
    }
}

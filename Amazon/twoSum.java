package Amazon;
import java.util.*;

public class twoSum {
    public static int[] solution(int arr[], int target){
        int res [] = new int[] {-1,-1};

        HashMap<Integer,Integer> m = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            if(m.get(target - arr[i]) != null){
                res[0] = m.get(target-arr[i]);
                res[1] = i;
                break;
            }else{
                m.put(arr[i], i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int [] arr = new int[] {2,7,11,15};

        int [] res = solution(arr, 13);

        System.out.print(res[0] + " " + res[1]);
    }
}

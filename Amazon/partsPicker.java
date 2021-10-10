package Amazon;
import java.util.*;



public class partsPicker {
    public static int solution(int [] arr){
        Queue<Integer> q = new PriorityQueue<>();

        for(int n: arr){
            q.add(n);
        }

        while(q.size() > 1){
            int t1 = q.poll(), t2 = q.poll();

            int sum = t1+t2;
            q.add(sum);
        }

        return q.poll();
    }
    public static void main(String[] args) {
        int arr [] = new int[] {1,3,5,6,7};

        int res= solution(arr);

        System.out.print(res);
    }
}

package Amazon;


import java.util.*;

public class minMaxImbalance {
    private static final int MOD = 1_000_000_007;
    public static int solution(int [] A){
        int n = A.length;
		
        /* monotonic stack storing indices; for two indice i < j in stack: A[i] <= A[j];
           Namely, every index is "waiting" for an incoming index k from the right s.t. A[j] > A[k] 
        */
        Deque<Integer> stack = new LinkedList<>();
        stack.offerLast(-1);
      
        long res = 0;
        
        for (int i = 0; i < n; i++) {
            while (stack.peekLast() != -1 && A[stack.peekLast()] > A[i]) {
                /* 
                For current index i, denote the top index of stack as idx, the element before idx
                as prev. Then if we have A[idx] > A[i], we know for A[idx],
                    1. A[i] is the next element s.t. A[i] < A[idx]
                    2. A[prev] is the prev element s.t. A[prev] <= A[idx]
                    
                Then A[idx] is the minimum element for all subarrays with 
                    1. starting point range from [prev + 1, idx]  ==> (idx - prev) choices 
                    2. ending point range from [idx, i - 1]       ==> (i - idx) choices
                */          
                int idx = stack.pollLast();
                res = (res + (long)A[idx] * (i - idx) * (idx - stack.peekLast())) % MOD;
            }
            stack.offerLast(i);
        }
        
        while (stack.peekLast() != -1) {
            int idx = stack.pollLast();
            res = (res + (long)A[idx] * (n - idx) * (idx - stack.peekLast())) % MOD;
        }
        
        return (int)res;
    }

    public static void main(String[] args) {
        int [] A = {1,3,2};

        System.out.println(solution(A));
    }
}

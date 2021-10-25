package Amazon;


import java.util.*;

/*
        int ans = 0;
        stack<int> stack;
        for (int i = 0, j; i <= A.size(); ++i) {
            while (!stack.empty() && A[stack.top()] > (i == A.size() ? 0 : A[i])) {
                j = stack.top(), stack.pop();
                int k = stack.empty() ? -1 : stack.top();
                ans = (ans + A[j] * (i - j) * (j - k)) % int(1e9 + 7);
            }
            stack.push(i);
        }
        return ans;


*/

public class minMaxImbalance {
    public static int mod = 1000000007;
    public static int minDiff(int [] arr){
        int sum = 0;
	    int currentStackValue = 0;

	// int[]{value, count}
	    Deque<int[]> stack = new ArrayDeque<>();
	    for (int i = 0; i < arr.length; i++) {
		    int currentCount = 1;
		    int currentValue = arr[i];
		
		    while (!stack.isEmpty() && stack.peek()[0] >= currentValue) {
			    int[] popped = stack.pop();
			    currentStackValue -= popped[1] * popped[0];
			    currentCount += popped[1]; // assign all previous count to current
		    }
		    stack.push(new int[]{currentValue, currentCount});
		    currentStackValue += currentValue * currentCount;
		    sum = (sum + currentStackValue) % mod;
	    }
	    return sum;
    }

    public static int maxDiff(int [] arr){
        int sum = 0;
	    int currentStackValue = 0;

	// int[]{value, count}
	    Deque<int[]> stack = new ArrayDeque<>();
	    for (int i = 0; i < arr.length; i++) {
		    int currentCount = 1;
		    int currentValue = arr[i];
		
		    while (!stack.isEmpty() && stack.peek()[0] <= currentValue) {
			    int[] popped = stack.pop();
			    currentStackValue -= popped[1] * popped[0];
			    currentCount += popped[1]; // assign all previous count to current
		    }
		    stack.push(new int[]{currentValue, currentCount});
		    currentStackValue += currentValue * currentCount;
		    sum = (sum + currentStackValue) % mod;
	    }
	    return sum;
    }

    public static void main(String[] args) {
        int [] A = {1,3,2};

        System.out.println(maxDiff(A)-minDiff(A));
    }
}

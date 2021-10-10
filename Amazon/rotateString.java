package Amazon;

public class rotateString {
    public static boolean solution(String s, String goal){
        if(s.length() > goal.length() || s.length() < goal.length()) return false;

        String t = s + s;

        if(t.contains(goal)) return true;

        return false;
    }

    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";

        System.out.print(solution(s, goal));
    }
}

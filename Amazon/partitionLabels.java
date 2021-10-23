package Amazon;

import java.util.*;

public class partitionLabels {
    public static List<Integer> solution(String s){
        int [] last = new int [26];

        for(int i = 0; i < s.length(); i++){
            last[s.charAt(i)-'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int j = 0, k = 0;

        for(int i = 0; i < s.length(); i++){
            j = Math.max(j, last[s.charAt(i)-'a']);
            if(j == i){
                res.add(i-k+1);
                k = i +1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s= "ababcbacadefegdehijhklij";

        solution(s).forEach(System.out::println);
    }
}

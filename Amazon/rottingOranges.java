package Amazon;

import java.util.*;



public class rottingOranges {
    public static int solution(int[][] grid){
        int fresh = 0;
        Queue<int []> q = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2) q.add(new int[] {i,j});
            }
        }

        int [][] dircs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};

        int time = 0;
        while(q.size() >= 1){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                int [] t = q.poll();

                for(int [] d: dircs){
                    int newI = t[0] + d[0];
                    int newJ = t[1] + d[1];

                    if(newI < 0 || newI >= grid.length || newJ < 0 || newJ >= grid[0].length || grid[newI][newJ] == 2 || grid[newI][newJ] == 0){
                        continue;
                    }else{
                        grid[newI][newJ] = 2;
                        fresh--;
                        q.add(new int[]{newI,newJ});
                    }
                }
            }
            time++;
        }

        return fresh == 0? time-1:-1;
    }

    public static void main(String[] args) {
        int [][] grid = new int [][]{{2,1,1},{1,1,0},{0,1,1}};

        System.out.print(solution(grid));
    }
}

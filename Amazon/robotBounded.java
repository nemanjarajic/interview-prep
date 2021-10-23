package Amazon;

public class robotBounded {
    public static boolean solution(String instructions){
        int x = 0, y = 0, angle = 0;
        char [] chars = instructions.toCharArray();
        for(char c: chars){
            if(c == 'L') angle += 90;
            else if(c == 'R') angle += 270;
            
            angle %= 360;
            
            if(c == 'G'){
                if(angle == 0) y+=1;
                else if(angle == 90) x -= 1;
                else if(angle == 180) y-=1;
                else if(angle == 270) x+=1;
            }
        }
        
        if(x == 0 && y == 0) return true;
        if(angle != 0) return true;
        
         return false;
    }
}

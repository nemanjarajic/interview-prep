package Facebook;

public class firstBadVersion {
    public static int solution(int n){
        int l = 1, h = n;

        while(l <= h){
            int mid = l+(h-l)/2;
            if(isBadVersion(mid) == false){
                l = mid+1;
            }else{
                h = mid - 1;
            }
        }

        return l;
    }
}

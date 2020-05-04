package LeetCode;


public class NthMagicalNumber {
    public int nthMagicalNumber(int N, int A, int B) {
        long mod = (long)1e9 + 7;
        long L = (A * B) / gcd(A, B);
        long low = 2;
        long high = (long) 1e14;

        while (low<high){
            long mid = low+(high-low)/2;
            if (mid/A+mid/B-mid/L <N) {
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return (int)(low%mod);

    }
    public int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }

}

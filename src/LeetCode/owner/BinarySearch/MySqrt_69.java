package LeetCode.owner.BinarySearch;

/**
 * Created by zinan.ji on 2020-05-12.
 */
public class MySqrt_69 {
    public int mySqrt(int x) {
        long low = 0;
        long high = x / 2 + 1;
        while (low < high) {
            long mid = low + (high - low + 1) / 2;
            long sq = mid * mid;
            if (sq > x) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return (int) low;
    }
}

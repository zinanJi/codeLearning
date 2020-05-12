package LeetCode.owner.BinarySearch;

/**
 * Created by zinan.ji on 2020-05-12.
 */
public class ShipWithinDays_1011 {
    public int shipWithinDays(int[] weights, int D) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canShip(weights, D, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canShip(int[] weights, int D, int K) {
        int cur = K;    // cur表示当前船的可承重量
        for (int weight : weights) {
            if (weight > K) return false;
            if (cur < weight) {
                cur = K;
                D--;
            }
            cur -= weight;
        }
        return D > 0;     // 能否在D天内运完
    }
}

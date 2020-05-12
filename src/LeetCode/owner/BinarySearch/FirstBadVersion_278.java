package LeetCode.owner.BinarySearch;

/**
 * Created by zinan.ji on 2020-05-12.
 */
public class FirstBadVersion_278 extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low<=n){
            int mid = low + ((high-low)>>1);
            if (isBadVersion(mid)) {
                if (!isBadVersion(mid-1)) return mid;
                high = mid - 1;
            } else{
                low = mid+1;
            }
        }
        return low;
    }
}

class VersionControl {
    public boolean isBadVersion(int version) {
        return  true;
    }
}

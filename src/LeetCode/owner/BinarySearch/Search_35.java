package LeetCode.owner.BinarySearch;

/**
 * Created by zinan.ji on 2020-05-12.
 */
public class Search_35 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {     // 左半部分有序
                // target在0-mid间
                if (target < nums[mid] && target >= nums[0]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {   // 右半部分有序
                // target在mid-nums.length间
                if (target > nums[mid] && target <= nums[nums.length - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}

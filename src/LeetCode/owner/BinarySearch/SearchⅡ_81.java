package LeetCode.owner.BinarySearch;

/**
 * Created by zinan.ji on 2020-05-12.
 */
public class SearchⅡ_81 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return nums[0] == target;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (target == nums[mid]) {
                return true;
            }
            // 10111 和 1110111101 这种。此种情况下 nums[start] == nums[mid]，分不清到底是前面有序还是后面有序，此时 start++ 即可。相当于去掉一个重复的干扰项。
            if (nums[low] == nums[mid]) {
                low++;
                continue;
            }
            if (nums[low] < nums[mid]) {     // 左半部分有序
                // target在0-mid间
                if (target < nums[mid] && target >= nums[low]) {
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
        return false;
    }
}

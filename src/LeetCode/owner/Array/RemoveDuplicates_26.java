package LeetCode.owner.Array;

/**
 * Created by zinan.ji on 2020-04-14.
 * 26. 删除排序数组中的重复项
 */
public class RemoveDuplicates_26 {
    // 双指针法
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}

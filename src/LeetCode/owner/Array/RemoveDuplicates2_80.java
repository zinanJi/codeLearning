package LeetCode.owner.Array;

/**
 * Created by zinan.ji on 2020-04-14.
 * 80. 删除排序数组中的重复项 II
 */
public class RemoveDuplicates2_80 {

    public int removeDuplicates(int[] nums) {
        int i = 1;
        int count = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[j - 1]) {
                count++;
            } else {
                count = 1;

            }
            if (count <= 2) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
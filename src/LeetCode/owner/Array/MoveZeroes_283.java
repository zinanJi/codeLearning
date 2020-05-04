package LeetCode.owner.Array;

import java.util.Optional;

/**
 * Created by zinan.ji on 2020-04-13.
 * 283. 移动零
 */
public class MoveZeroes_283 {
    // 和冒泡排序一个思路
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++)
                if (nums[i] == 0) {
                    swap(nums, i, j);
                }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



    // 遍历数组，遇0统计数量count
    // 遇到非零就往前挪count个位置
    public void moveZeroes2(int[] nums) {
        int n = nums.length;
        int count =0;
        for (int i = 0;i<n;i++) {
            if (nums[i]==0) count++;
            else {
                int temp = nums[i];
                nums[i] = nums[i-count];
                nums[i-count] = temp;
            }
        }
    }
}

package LeetCode;

import java.util.Queue;

import static java.lang.Math.min;

public class MinSubArrayLen {
    // 暴力 O(n^3)
    public int solution1(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum >= s) {
                    result = min(result, j - i + 1);
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    // 优化暴力，sum提前计算好。O(n^2)
    public int solution2(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int result = Integer.MAX_VALUE;

        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = sums[j] - sums[i] + nums[i];
                if (sum >= s) {
                    result = min(result, j - i + 1);
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    // 二分查找 O(nlogn)
    public int solution3(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int result = Integer.MAX_VALUE;

        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int to_find = s - nums[i];
            int bound = binarySearch(sums, to_find + sums[i], i, nums.length - 1);
            if (bound != -1) {
                result = Math.min(result, bound - i + 1);
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static int binarySearch(int[] array, int value, int start, int end) {
        int mid = -1;
        while (start <= end) {
            mid = (start + end) >>> 1;
            if (array[mid] < value) {
                start = mid + 1;
            } else if (array[mid] > value) {
                end = mid - 1;
            } else return mid;
        }
        return array[mid] > value ? mid : -1;
    }

    // 双指针法（滑动窗口）
    public int solution4(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int result = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        // 窗口从右边开始滑动
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // sum现在的值比s大的时候，记录下子数组的长度，与之前对比取min，窗口左边开始滑动
            while (sum >= s) {
                result = min(result, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}

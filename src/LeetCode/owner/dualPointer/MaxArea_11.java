package LeetCode.owner.dualPointer;

/**
 * Created by zinan.ji on 2020-05-11.
 */
public class MaxArea_11 {
    int max = 0;

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        while (i != j) {
            max = Math.max(Math.min(height[i], height[j]) * (j - i), max);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}

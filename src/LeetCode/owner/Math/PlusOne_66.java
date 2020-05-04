package LeetCode.owner.Math;

/**
 * Created by zinan.ji on 2020-04-19.
 * 66. 加一
 */
public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        // 进位的都是有9的，那么只要+1之后不是0就可以返回了，因为对前面的数字不会影响
        // 如果是0那就再进一位，最后处理9，99，999这类特殊情况
        int end = digits.length - 1;
        while (end >= 0) {

            digits[end]++;
            digits[end] = digits[end] % 10;
            if (digits[end] != 0) return digits;
            end--;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}

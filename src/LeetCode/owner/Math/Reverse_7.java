package LeetCode.owner.Math;

/**
 * Created by zinan.ji on 2020-04-19.
 * 7. 整数反转
 */
public class Reverse_7 {
    public int reverse(int x) {
        // num = x%10
        // sum = x/10
        // 要判断rev = rev * 10 + num 是否溢出rev>=Integer.MAX_VALUE/rev<=Integer.MIN_VALUE/10
        int rev = 0;
        while (x != 0) {
            int num = x % 10;
            x = x / 10;
            if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && num > 7) return 0;
            if (rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && num < -8) return 0;
            rev = rev * 10 + num;
        }
        return rev;
    }
}

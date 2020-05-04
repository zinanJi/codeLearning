package solution;

public class PalindromeNumber {
    // 1. 负数直接false
    // 2. 逆序输出，与输入做判断
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        ReverseInteger reverseInteger = new ReverseInteger();
        int copyx = x;
        int reverse = reverseInteger.reverse(copyx);
        return reverse == x;
    }
    // 1. 负数 || 10的倍数直接false
    // 2. 判断一半就足够，当result > copyx(即用来/10处理的数)时
    //    121:result / 10 == copyx?
    //    1221: result == copyx?
    public boolean isPalindrome2(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int result = 0;
        while(result > x) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result == x || result / 10 == x;
    }

}

package solution;

public class ReverseInteger {
    // 坑点：逆序输出溢出返回0
    public int reverse(int x) {
        // 十进制数 每次循环除以10后取余10就能得到从右到左位置上的数
        // result每次循环里 * 10 + x % 10就能实现逆序
        // result为long类型以便判断是否超出int范围
        long result = 0;
        for ( ; x != 0; x /= 10)
            result = result * 10 + x % 10;
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : (int) result;

    }
}

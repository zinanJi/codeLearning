package solution;

import org.junit.Test;

import static org.junit.Assert.*;

public class lengthOfLongestSubstringTest {
    @Test
    public void solution1() throws Exception {
        // 遍历数组
        // 斜着遍历数组：j=k+i-1
        for (int k = 2; k <= 5; k++) {
            for (int i = 0; i <= 5 - k; i++) {

                int j = k + i - 1;
                System.out.println(i + " " + j + " " + k);
            }
        }
    }

    @Test
    public void solution2() throws Exception {
    }

    @Test
    public void solution3() throws Exception {
    }

}
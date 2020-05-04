package LeetCode;

/**
 * Created by zinan.ji on 2020-03-28.
 * 494. 目标和
 */
public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];

        // 填入base case
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = -1000; j <= 1000; j++) {
                if (dp[i - 1][j + 1000] > 0){
                    dp[i][j + 1000 + nums[i]] += dp[i - 1][j + 1000];
                    dp[i][j + 1000 - nums[i]] += dp[i - 1][j + 1000];
                }

            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }
}

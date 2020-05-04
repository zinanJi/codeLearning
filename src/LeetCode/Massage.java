package LeetCode;

import static java.lang.Math.max;

public class Massage {
    public int massage(int[] nums) {
        int length = nums.length;
        if(nums==null||length==0) return 0;

        int[][] dp = new int[length][2];
        for (int i=0;i<length;i++){
            for (int j=0;j<2;j++){
                dp[i][j] = 0;
            }
        }
        // base case
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        // dp[i][j] j=1/0,表示前i个预约，第i个不预约的最长预约时间
        // dp[i][0] = max{dp[i-1][0],dp[i-1][1]}
        // dp[i][1] = dp[i-1][0]+nums[i]
        // 答案即为 max(dp[n][0],dp[n][1])，其中 n 表示预约的个数。
        for (int i = 1;i<length;i++) {
            dp[i][0] = max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0]+nums[i];
        }
        return dp[length-1][0]>dp[length-1][1]?dp[length-1][0]:dp[length-1][1];
    }
}

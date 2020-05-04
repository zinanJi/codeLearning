package LeetCode;

public class StoneGame {
    public class Pair {
        int fir;
        int sec;

        public Pair(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }
    }
    public boolean stoneGame(int[] piles) {
        // 初始化dp
        Pair[][] dp = new Pair[piles.length][piles.length];
        for (int i = 0;i<piles.length;i++) {
            for (int j =i;j<piles.length;j++) {
                dp[i][j] = new Pair(0,0);
            }
        }

        // 填入base case
        for (int i = 0;i<piles.length;i++) {
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }

        // 遍历数组
        // 斜着遍历数：j=k+i-1
        for (int k = 2;k<=piles.length;k++){
            for (int i = 0;i<=piles.length-k;i++){

                int j = k + i - 1;
                // 先手选择最左或最右的分数
                int left = dp[i+1][j].sec + piles[i];
                int right = dp[i][j-1].sec + piles[j];
                // 判断那个是最优分数，套用状态方程
                if (left>right) {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i+1][j].fir;
                }else{
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j-1].fir;
                }
            }
        }
        Pair res = dp[0][piles.length-1];
        return res.fir>res.sec;
    }
}

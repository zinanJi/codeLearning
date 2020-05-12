package LeetCode.owner.Tree.middle;

/**
 * Created by zinan.ji on 2020-03-25.
 * 96. 不同的二叉搜索树
 */
public class NumTrees_96 {
    /*
        用递归的思想，求出卡塔兰数
     */
    public int numTrees(int n) {
        long c = 1;
        for (int i = 0; i < n; i++) {
            c = c * (4 * i + 2) / (i + 2);
        }
        return (int) c;
    }

    /*
        动态规划思想
     */
    public int numTrees2(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        // 从2开始迭代填G[n]
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }
}

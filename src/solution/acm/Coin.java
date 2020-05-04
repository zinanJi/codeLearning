package solution.acm;

import java.util.Scanner;

import static java.lang.Math.min;

public class Coin {

    public static int[] value = {1, 5, 10, 50, 100, 500};
    public static int[] C = new int[6];
    public static int A;

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            C[i] = sc.nextInt();
        }
        A = sc.nextInt();
        solve();
    }

    private static void solve() {
        int ans = 0;

        for (int i = 5; i >=0; i--) {
            // 使用硬币i的枚数
            int t = min(A / value[i], C[i]);
            A -= t * value[i];
            ans += t;
        }
        System.out.println(ans);
    }
}

package solution.acm;

import java.util.Scanner;

public class LakeCounting {

    private static int N; // 高
    private static int M; // 宽

    private static int[][] field;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        // 限定field的最大范围 N = 100,M = 100
        System.out.println("请输入花园数据");
        // 存储数据{0 代表空地，1 代表积水}
        field = new int[100][100];
        for (int i = 0 ; i < N; i++){
            for (int j = 0; j < M; j++) {
                field[i][j] = sc.nextInt();
            }
        }
        solve(N, M);
    }

    public static void dfs(int x, int y) {
        field[x][y] = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                // 从当前位置挪到(nx, ny),挪动方式为：向x方向移动dx，向y方向移动dy
                int nx = x + dx;
                int ny = y + dy;
                // 判断是不是在园子里，以及是否有积水
                if (0 <= nx && nx < N && 0 <= ny && ny <M && field[nx][ny] == 1) dfs(nx, ny);
            }
        }
    }

    public static void solve(int x, int y) {
        int res = 0;
        for (int i = 0; i < x; i++ ) {
            for (int j = 0; j < y; j++) {
                if (field[i][j] == 1) {
                    dfs(i, j);
                    res++;
                }
            }
        }
        System.out.println(res);
        System.out.println("完成计算：" + System.currentTimeMillis());
        System.out.println("总共有 "  + res + " 处水洼");
    }
/*    10
      12
    请输入花园数据
        1 0 0 0 0 0 0 0 0 1 1 0
        0 1 1 1 0 0 0 1 0 1 1 1
        0 0 0 0 1 1 0 0 0 1 1 0
        0 0 0 0 0 0 0 0 0 1 1 0
        0 0 0 0 0 0 0 0 0 1 0 0
        0 0 1 0 0 0 0 0 0 1 0 0
        0 1 0 1 0 0 0 0 0 1 1 0
        1 0 1 0 1 0 0 0 0 0 1 0
        0 1 0 1 0 0 0 0 0 0 1 0
        0 0 1 0 0 0 0 0 0 0 1 0
            4
    完成计算：1552063038221
    总共有 4 处水洼*/
}

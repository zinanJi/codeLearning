package solution.acm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs {

    private static int N; // 高
    private static int M; // 宽

    private static char[][] field;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        int[] begin = new int [2];
        int[] end = new int [2];

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            field[i] = s.toCharArray();

            if (s.contains("S")) {
                begin[0] = i;
                begin[1] = s.indexOf("S");
            }
            if (s.contains("G")) {
                end[0] = i;
                end[1] = s.indexOf("G");
            }
        }
        System.out.println(solve(field, begin, end));

    }

    private static int solve(char[][] field, int[] begin, int[] end) {
        // 四个方向移动的向量
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        // 用来存储距离到起始点最短路径的二维数组
        int[][] d = new int [field.length][field[0].length];
        // 存储未进行处理的点
        // 链表队列
        Queue<int []> queue = new LinkedList<>();

        // 将所有的位置都初始化为最大
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[0].length; j++) {
                d[i][j] = Integer.MAX_VALUE;
            }
        }
        queue.offer(begin);
        // 将起始点的最短路径设置为0
        d[begin[0]][begin[1]] = 0;
        // 一直循环到队列为空
        while (!queue.isEmpty()) {
            // 取出队列中最前端的点
            int[] cur = queue.poll();
            // 如果是终点就结束循环
            if (cur[0] == end[0] && cur[1] == end[1]) break;
            // 四个方向循环
            for (int i = 0; i < 4; i++) {
                // 试探
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                // 判断是否可以走
                if (ny >= 0 && ny < d.length && nx >= 0 && nx < d[0].length && field[ny][nx] != '#' && d[ny][nx] == Integer.MAX_VALUE) {
                    d[ny][nx] = d[cur[0]][cur[1]] + 1;
                    int[] c = {ny, nx};
                    queue.offer(c);
                }
            }
        }

        return d[end[0]][end[1]];
    }
}

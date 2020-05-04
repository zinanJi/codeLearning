package LeetCode;

/**
 * Created by zinan.ji on 2020-03-26.
 * 999. 车的可用捕获量
 */
public class NumRookCaptures {
    public int numRookCaptures(char[][] board) {
        int rowR = 0, columnR = 0;
        int nums = 0;
        // 找到R的位置
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    rowR = i;
                    columnR = j;
                    break;
                }
            }
        }


        // 可以用四个for，也可以用方向数组模拟
        for (int i = rowR - 1; i > 0; i--) {
            switch (board[i][columnR]) {
                case 'p':
                    nums++;
                    break;
                case 'B':
                    break;
            }
        }

        for (int i = rowR + 1; i < board.length; i++) {
            switch (board[i][columnR]) {
                case 'p':
                    nums++;
                    break;
                case 'B':
                    break;
            }
        }

        for (int i = columnR - 1; i > 0; i--) {
            switch (board[rowR][i]) {
                case 'p':
                    nums++;
                    break;
                case 'B':
                    break;
            }
        }

        for (int i = columnR + 1; i < board[rowR].length; i++) {
            switch (board[rowR][i]) {
                case 'p':
                    nums++;
                    break;
                case 'B':
                    break;
            }
        }


        return nums;
    }
}

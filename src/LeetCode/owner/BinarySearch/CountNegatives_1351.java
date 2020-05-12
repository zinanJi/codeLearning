package LeetCode.owner.BinarySearch;

/**
 * Created by zinan.ji on 2020-05-12.
 */
public class CountNegatives_1351 {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            int[] row = grid[i];
            if (row[n - 1] >= 0) continue;
            if (row[0] < 0) {
                count += (m - i) * n;
                break;
            }
            int first = binarySearch(row);
            count += n - first;
        }
        return count;
    }

    private int binarySearch(int[] row) {
        int low = 0;
        int high = row.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (row[mid] >= 0) {
                low = mid + 1;
            } else {
                if (row[mid - 1] >= 0) return mid;
                high = mid;
            }
        }
        return low;
    }
}

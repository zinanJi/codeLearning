package algorithm.Search;

public class Search {


    // 顺序查找
    public static int sequenceSearch(int[] array, int value, int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == value)
                return i;
        }
        return -1;
    }

    // 二分查找迭代版
    public static int binarySearch(int[] array, int value, int n) {
        int low = 0, high = n - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (value > array[mid]) {
                low = mid + 1;
            } else if (value < array[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 二分查找递归版
    public static int binarySearchRecur(int[] nums, int target, int low, int high) {
        if (low >= high) return low; // base case
        int mid = low + (high - low) / 2;
        if (nums[mid] < target)
            return binarySearchRecur(nums, target, mid + 1, high);
        else if (nums[mid] > target)
            return binarySearchRecur(nums, target, low, mid - 1);
        else return mid;
    }

    // 二分查找含有重复数字的情况：
    // 二分查找包含重复数字迭代版
    //主要区别：等于mid也要将high-1；直到low>high结束，返回low（其实是高位，重复数字的第一位）
    public static int BinarySearchDuplicate(int a[], int value, int n) {
        int low = 0;
        int high = n - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (a[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // 二分查找包含重复数字递归版
    public static int firstOccurrenceRecur(int[] nums, int target, int low, int high) {
        if (low > high) return low;
        int mid = low + (high - low) / 2;
        if (nums[mid] < target) {
            return firstOccurrenceRecur(nums, target, mid + 1, high);
        } else {
            return firstOccurrenceRecur(nums, target, low, mid - 1);
        }
    }

    // 插值查找
    // 基于二分查找算法，将查找点的选择改进为自适应选择，适合表长较大，关键字分布较均匀的查找表
    // mid = low + (high - low) * (value - a[low]) / (a[high] - a[low]);
    public int InsertionSearch(int[] a, int value, int n) {
        int low = 0;
        int high = n - 1;
        int mid = 0;

        while (low <= high) {
            mid = low + (high - low) * (value - a[low]) / (a[high] - a[low]);
            if (a[mid] > value)
                high = mid - 1;
            if (a[mid] < value)
                low = mid + 1;
            else {
                return mid;
            }
        }
        return -1;
    }

    public final static int MAXSIZE = 20;

    // 斐波那契查找
    // 和折半查找相似，n = F(k) -1
    public static int fibonacciSearch(int[] a, int value, int n) {
        int low = 0;
        int high = n - 1;
        int mid = 0;

        // 获取斐波那契分割数值下标k
        int k = 0;
        int[] f = fibonacci();
        while (n > f[k] - 1) {
            k++;
        }

        // 创建临时数组,长度为f[k]-1
        int[] temp = new int[f[k] - 1];
        for (int j = 0; j < n; j++) {
            temp[j] = a[j];
        }

        for (int i = n; i < f[k] - 1; i++) {
            temp[i] = temp[high];
        }

        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (temp[mid] > value) {
                high = mid - 1;
                // 斐波那契，前半部分有f[k-1]个元素,后半部分有f[k-20]个元素
                // 所以k=k-1
                k = k - 1;
            } else if (temp[mid] < value) {
                low = mid + 1;
                k = k - 2;
            } else {
                if (mid <= high) {
                    return mid;
                }
                // 可能会有查找到补充的元素的情况，补充的元素与high位置的元素一样
                else {
                    return high;
                }
            }
        }
        return -1;
    }


    public static int[] fibonacci() {
        int[] f = new int[MAXSIZE];
        int i = 0;
        f[0] = f[1] = 1;
        for (i = 2; i < MAXSIZE; i++) {
            f[i] = f[i - 2] + f[i - 1];
        }
        return f;
    }

    // 树表查找
    // 二叉树查找算法
    // BinaryTreeSearch.java
    // 定义节点数据结构 - 构建二叉排序树 - 搜索算法

    // 平衡查找树——2-3查找树
    // Tree23.java
    // 内部节点（存在子节点的节点）要么有2个孩子和1个数据元素，要么有3个孩子和2个数据元素，
    // 叶子节点没有孩子，并且有1个或2个数据元素。

    // 平衡查找树——红黑树

    // B树/B+树

    // 分块查找
    // 省略了构建索引表的过程，只写了查找代码
    // index为索引表，放的是各块最大值
    // st为顺序表
    // key为要查找的值
    // m为各块长度
    public static int blockSearch(int[] index, int[] st, int key, int m) {
        // 用折半查找在index[]中确定要查找的key属于哪个块中
        int i = binarySearch(index, key, index.length);
        if (i >= 0) {
            int j = i > 0 ? i * m : i;
            int len = (i + 1) * m;
            // 在块内顺序查找
            for (int k = j; k < len; k++) {
                if (key == st[k]) {
                    return k;
                }
            }
        }
        return -1;
    }


    // 哈希查找
    public static int searchHash(int[] hash, int hashLength, int key) {
        int hashAddress = key * hashLength;
        while (hashAddress != 0 && hash[hashAddress] != key) {
            hashAddress = (++hashAddress) % hashLength;
        }

        if (hash[hashAddress] == 0)
            return -1;
        return hashAddress;
    }

    // 数据插入Hash表
    public static void insertHash(int[] hash, int hashLength, int data) {
        int hashAddress = data % hashLength;
        while (hash[hashAddress] != 0) {
            hashAddress = (++hashAddress) % hashLength;
        }

        hash[hashAddress] = data;
    }

    // 串的模式匹配算法

}



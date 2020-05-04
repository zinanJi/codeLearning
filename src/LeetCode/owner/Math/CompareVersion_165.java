package LeetCode.owner.Math;

/**
 * Created by zinan.ji on 2020-04-19.
 * 165. 比较版本号
 */
public class CompareVersion_165 {
    public int compareVersion(String version1, String version2) {
        // 分割字符串存储到数组
        // 遍历较长数组逐个比较
        // 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 版本号相同返回 0。
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int length1 = v1.length;
        int length2 = v2.length;
        int val1, val2;
        for (int i = 0; i < Math.max(length1, length2); i++) {
            val1 = i < length1 ? Integer.parseInt(v1[i]) : 0;
            val2 = i < length2 ? Integer.parseInt(v2[i]) : 0;
            if (val1 != val2) return val1 > val2 ? 1 : -1;
        }
        return 0;
    }
}

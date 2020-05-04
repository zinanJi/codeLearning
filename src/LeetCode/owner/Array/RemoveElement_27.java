package LeetCode.owner.Array;

/**
 * Created by zinan.ji on 2020-04-14.
 * 27. 移除元素
 */
public class RemoveElement_27 {
    // 自己写的
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int count=0;
        for(int i = 0;i<n;i++){
            if(nums[i]==val) {
                count++;
            }else{
                int temp = nums[i];
                nums[i] = nums[i-count];
                nums[i-count] = temp;
            }
        }
        for(int i = n-count;i<n;i++){
            nums[i]=0;
        }
        return n-count;
    }

    // 题解1 快慢指针,拷贝覆盖
    public int removeElement1(int[] nums, int val) {
        // ans为慢指针，num迭代为快指针，满足条件ans才会走
        int ans = 0;
        for (int num:nums){
            if (num!=val){
                nums[ans] = num;
                ans++;
            }
        }
        return ans;
    }


}

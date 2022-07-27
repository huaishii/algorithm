public class Exchange {
    /**
     * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
     *
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
     *
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     *
     *  双指针
     *      定义爽指针i,j分列数组两端，循环执行
     *       1、指针i从左到右寻找偶数
     *       2、指针j从右到左寻找奇数
     *       3、交换奇偶数
     *       4、当i==j时跳出
     */

    public int[] solution(int[] nums) {
        int i=0,j=nums.length-1,tmp;
        while(i<j){
            while(i<j && (nums[i]%2 == 1)) i++;
            while(i<j && (nums[j]%2 == 0)) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}

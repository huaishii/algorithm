/**
 * @Description:
 * @Author: Ljl
 * @date 2021/12/17 10:40
 */
public class CountKDifference {
    /**
     * 输入：nums = [3,2,1,5,4], k = 2
     * 输出：3
     * 解释：差的绝对值为 2 的数对为：
     * - [3,2,1,5,4]
     * - [3,2,1,5,4]
     * - [3,2,1,5,4]
     *
     * @param nums
     * @param k
     * @return
     */
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (Math.abs(nums[i]-nums[j])==k){
                    count ++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountKDifference countKDifference = new CountKDifference();
        int[] nums = {3,2,1,5,4};
        System.out.println(countKDifference.countKDifference(nums,2));
    }
}

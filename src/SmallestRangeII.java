import java.util.Arrays;

/**
 * @Description:
 * @Author: Ljl
 * @date 2021/12/20 10:55
 */
public class SmallestRangeII {
    /**
     * 给你一个整数数组 nums，和一个整数k 。
     *
     * 对于每个下标 i（0 <= i < nums.length），将 nums[i] 变成 nums[i] + k 或 nums[i] - k 。
     *
     * nums 的 分数 是 nums 中最大元素和最小元素的差值。
     *
     * 在更改每个下标对应的值之后，返回 nums 的最小 分数 。
     *
     * 输入：nums = [1,3,6], k = 3
     * 输出：3
     * 解释：将数组变为 [4, 6, 3] 。分数 = max(nums) - min(nums) = 6 - 3 = 3 。
     *
     * @param nums
     * @param k
     * @return
     */
    public int smallestRangeII(int[] nums, int k) {
        //先排序
        Arrays.sort(nums);
        //最大最小值得差值,当整个数据统一 +k/-k的时候，
        int ans = nums[nums.length-1] - nums[0];
        for (int i = 0; i < nums.length-1; i++) {
            //最小值
            int low = Math.min(nums[0] + k, nums[i + 1] - k);
            //最大值
            int high = Math.max(nums[i] + k, nums[nums.length-1] - k);
            //最小差值
            ans = ans < high - low ? ans : high - low;
        }
        return ans;
    }

    public static void main(String[] args) {
        SmallestRangeII smallestRangeII = new SmallestRangeII();
        int[] nums = {1,3,6};
        System.out.println(smallestRangeII.smallestRangeII(nums,3));
    }
}

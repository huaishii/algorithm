import sun.applet.Main;

/**
 * @Description:
 * @Author: Ljl
 * @date 2021/12/17 15:23
 */
public class MaxValue {
    /**
     * 给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：
     * <p>
     * nums.length == n
     * nums[i] 是 正整数 ，其中 0 <= i < n
     * abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
     * nums 中所有元素之和不超过 maxSum
     * nums[index] 的值被 最大化
     * 返回你所构造的数组中的 nums[index] 。
     * <p>
     * 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。
     * <p>
     * 输入：n = 4, index = 2,  maxSum = 6
     * 输出：2
     * 解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
     *
     * @param n
     * @param index
     * @param maxSum
     * @return
     */
    public int maxValue(int n, int index, int maxSum) {
        int l = index, r = index;
        //返回数
        //先底层全部设为1
        int ans = 1;
        //rest记录剩余个数
        int rest = maxSum - n;
        while (l > 0 || r < n - 1) {
            //每次填充的个数
            int len = r - l + 1;
            //剩余个数足够填充这一层
            if (rest >= len) {
                //返回数加1
                ans++;
                //现在剩余个数
                rest -= len;
                //重新定义边界
                l = Math.max(0, l - 1);
                r = Math.min(r + 1, n - 1);
            } else {
                break;
            }
        }
        //当第二层也将铺满整n个还有剩余时，相应第三层也能继续铺满
        ans += rest / n;
        return ans;
    }

    public static void main(String[] args) {
        MaxValue maxValue = new MaxValue();
        System.out.println(maxValue.maxValue(6,1,10));
    }
}

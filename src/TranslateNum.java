/**
 * @Description:
 * @Author: Ljl
 * @date 2021/12/3 9:50
 */
public class TranslateNum {

    public int translateNum(int num) {
        //数字转换为字符串
        String s = String.valueOf(num);
        int len = s.length();
        if (len < 2) {
            return len;
        }

        //转换为字符数组
        char[] chars = s.toCharArray();
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1];
            int currentNum = 10 * (chars[i - 1] - '0') + (chars[i] - '0');
            if (currentNum > 9 && currentNum < 26) {
                if (i < 2) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len - 1];
    }


    public static void main(String[] args) {
        TranslateNum solution = new TranslateNum();
        int num = 261221321;
        int res = solution.translateNum(num);
        System.out.println(res);
    }
}

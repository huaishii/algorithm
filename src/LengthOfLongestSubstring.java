import java.util.HashSet;

/**
 * @Description:
 * @Author: Ljl
 * @date 2022/4/24 17:00
 */
public class LengthOfLongestSubstring {


    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
     *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
     *
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> occ = new HashSet<>();
        int n = s.length();
        int right = 0, max = 0;
        for (int left = 0; left < n; left++) {
            if (left != 0) {
                occ.remove(s.charAt(left - 1));
            }

            while (right < n && !occ.contains(s.charAt(right))) {
                occ.add(s.charAt(right));
                right++;
            }

            max = Math.max(max, right - left);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        int i = lengthOfLongestSubstring.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}

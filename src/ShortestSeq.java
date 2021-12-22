import java.util.*;

/**
 * @Description:
 * @Author: Ljl
 * @date 2021/12/21 17:06
 */
public class ShortestSeq {
    /**
     * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
     *
     * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
     *
     * 输入:
     * big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
     * small = [1,5,9]
     * 输出: [7,10]
     * @param big
     * @param small
     * @return
     */
    /**
     * tips 滑动窗口
     * @param big
     * @param small
     * @return
     */
    public int[] shortestSeq(int[] big, int[] small) {
        //结果数组
        int[] res = {};
        //用来维护map中当前含有且未出现在大数组里的数字个数
        int smallLen = small.length;
        //最大长度
        int bigLen = big.length;
        //左右边界点
        int left=0,right=0;
        //结果子串长度
        int minLen = bigLen;
        //查找表map
        Map<Integer,Integer> map = new HashMap<>();
        //存放小数组所有元素，因为不会重复，直接赋为1
        for (int s : small) {
            map.put(s,1);
        }
        while (right < bigLen) {
            //判断right指针代表的元素是否在查找表
            if (map.containsKey(big[right])){
                //元素存在
                if (map.get(big[right]) >0){
                    //需要查找的字符数减一
                    smallLen--;
                }
                //查找表中的对应元素的值减一
                map.put(big[right],map.get(big[right])-1);
            }
            //全部找到
            while (smallLen == 0){
                //取最小查找长度
                if (right - left < minLen) {
                    minLen = right-left;
                    res = new int[]{left,right};
                }
                //对左边界判断是否是查找表的值
                if (map.containsKey(big[left])){
                    //每次都要将map含有的big数组元素+1
                    map.put(big[left],map.get(big[left])+1);
                    //只有当map中该元素数量大于0才可以让smallLen++
                    if(map.get(big[left])>0){
                        smallLen++;
                    }
                }
                left++;
            }
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        ShortestSeq shortestSeq = new ShortestSeq();
        int[] big = {7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};
        int[] small = {1,5,9};
        System.out.println(Arrays.toString(shortestSeq.shortestSeq(big,small)));
    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: Ljl
 * @date 2021/12/17 10:11
 */
public class SingleNumber {

    /**
     * 输入：nums = [2,2,3,2]
     * 输出：3
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int rtnInt = 0;
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 1){
                rtnInt = integer;
            }
        }
        return rtnInt;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums = {2,2,3,2};
        System.out.println(singleNumber.singleNumber(nums));
    }
}

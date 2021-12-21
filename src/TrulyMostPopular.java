import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: Ljl
 * @date 2021/12/16 16:19
 */
public class TrulyMostPopular {
    /**
     * 输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"],
     * synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
     * 输出：["John(27)","Chris(36)"]
     *
     * @param names
     * @param synonyms
     * @return
     */
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        //计数map
        Map<String, Integer> map = new HashMap<>();
        //并查集 key(子孙）->value(祖宗）
        Map<String, String> unionMap = new HashMap<>();
        for (String name : names) {
            int idx1 = name.indexOf("(");
            int idx2 = name.indexOf(")");
            int number = Integer.valueOf(name.substring(idx1 + 1, idx2));
            map.put(name.substring(0, idx1), number);
        }
        //合并同义词
        for (String synonym : synonyms) {
            String[] pair = synonym.split(",");
            String name1 = pair[0].substring(1, pair[0].length());
            String name2 = pair[1].substring(0, pair[1].length() - 1);
            //name1是否有同义词，有就替换为同义词
            while (unionMap.containsKey(name1)) {
                name1 = unionMap.get(name1);
            }
            //name2是否有同义词，有就替换为同义词
            while (unionMap.containsKey(name2)) {
                name2 = unionMap.get(name2);
            }
            //不是同义词
            if (!name1.equals(name2)) {
                //出现次数是两者之和
                int frequency = map.getOrDefault(name1, 0) + map.getOrDefault(name2, 0);
                //大名
                String trulyName = name1.compareTo(name2) < 0 ? name1 : name2;
                //小名
                String nickName = name1.compareTo(name2) < 0 ? name2 : name1;
                //大名是小名的祖宗
                unionMap.put(nickName, trulyName);
                map.remove(nickName);
                map.put(trulyName, frequency);
            }

        }
        //构造返回数据
        String[] res = new String[map.size()];
        int index = 0;
        for (String name : map.keySet()) {
            StringBuilder sb = new StringBuilder(name);
            sb.append("(");
            sb.append(map.get(name));
            sb.append(")");
            res[index++] = sb.toString();
        }
        return res;
    }

    public static void main(String[] args) {
        TrulyMostPopular t = new TrulyMostPopular();
        String[] names = {"John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"};
        String[] synonyms = {"(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)"};
        String[] strings = t.trulyMostPopular(names, synonyms);
        for (String string : strings) {
            System.out.println(string);
        }

    }
}

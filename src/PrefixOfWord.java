/**
 * @Description:
 * @Author: Ljl
 * @date 2021/12/3 11:33
 */
public class PrefixOfWord {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] split = sentence.split(" ");
        int rtn = -1;
        for (int i = 1; i <= split.length; i++) {
            if (split[i - 1].length() >= searchWord.length() && searchWord.equals(split[i - 1].substring(0, searchWord.length()))) {
                rtn = i;
            }
        }
        return rtn;
    }


    public static void main(String[] args) {
        PrefixOfWord prefixOfWord = new PrefixOfWord();
        int prefixOfWord1 = prefixOfWord.isPrefixOfWord("i love eating burger", "burg");
        System.out.println(prefixOfWord1);
    }

}

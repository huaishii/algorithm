import java.util.*;

/**
 * @Description:
 * @Author: Ljl
 * @date 2022/4/13 16:10
 */

/**
 * 给定一份单词的清单，设计一个算法，创建由字母组成的面积最大的矩形，其中每一行组成一个单词(自左向右)，每一列也组成一个单词(自上而下)。不要求这些单词在清单里连续出现，但要求所有行等长，所有列等高。
 * 如果有多个面积最大的矩形，输出任意一个均可。一个单词可以重复使用。
 *
 * 输入: ["this", "real", "hard", "trh", "hea", "iar", "sld"]
 * 输出:
 * [
 *    "this",
 *    "real",
 *    "hard"
 * ]
 */
class MaxRectangle {
    Trie trie = new Trie();
    int maxArea = 0;
    List<String> ans = null;
    //保存以长度为key，以单词集合为value的map，按照长度从大到小排序
    TreeMap<Integer, Set<String>> map = new TreeMap<>((o1, o2) -> o2 - o1);

    public String[] maxRectangle(String[] words) {
        //按照长度添加进map，同时添加到字典树中
        for (String word : words) {
            trie.add(word);
            map.putIfAbsent(word.length(), new HashSet<>());
            map.get(word.length()).add(word);
        }

        //对每一个相同长度的单词集合dfs，找到集合中能组成矩形的最多单词，并更新全局变量ans和maxArea
        for (int len : map.keySet()) {
            //关键，Node数组保存dfs时当前状态的所有字母在字典树中的位置，最开始时保存的都是字典树的根，如dfs了第一个单词this，
            // 数组变为{Node(t), Node(h), Node(i), Node(s)}，检查新单词的时候，直接从字典树的每个Node走到下一个位置，
            // 比如下一个单词是real，Node(t)的下一个节点中如果r不存在，说明无法构建，
            // 如果Node(t)->Node(r), Node(h)->Node(e), Node(i)->Node(a), Node(s)->Node(l)都存在，
            // 则可以继续尝试添加，另外如果这四个新的Node位置都是单词结尾（valid = true）,那么构成了一个有效矩形，可以尝试更新答案
            Node[] nodes = new Node[len];
            for (int i = 0; i < len; i++) {
                nodes[i] = trie.root;
            }
            List<String> list = new ArrayList<>(map.get(len));
            //四个参数：单词集合， 当前集合， Node数组
            dfs(list, new ArrayList<String>(), nodes);
        }
        return ans.toArray(new String[0]);
    }

    private void dfs(List<String> list, ArrayList<String> curList, Node[] nodes) {
        int len = nodes.length;
        //因为一个矩形有两种构成方式，这里只检查以len作为长边的矩形，如this, real, hard检查过以后，可以不用检查trh, hra, iar, srd，二者是一样的。
        if (len * len <= maxArea || curList.size() == len) return;
        search:
        for (int p = 0; p < list.size(); p++) {
            //如果每个新的Node都是单词结尾，allValid保持为true，是合格的矩形
            boolean allValid = true;
            Node[] next = new Node[nodes.length];
            for (int i = 0; i < len; i++) {
                if (nodes[i].children[list.get(p).charAt(i) - 'a'] == null) continue search;
                if (!nodes[i].children[list.get(p).charAt(i) - 'a'].valid) allValid = false;
                next[i] = nodes[i].children[list.get(p).charAt(i) - 'a'];
            }
            curList.add(list.get(p));
            if (allValid && maxArea < len * curList.size()) {
                maxArea = len * curList.size();
                ans = new ArrayList<>(curList);
            }
            dfs(list, curList, next);
            curList.remove(curList.size() - 1);
        }
    }
}

//常规字典树
class Trie {
    Node root = new Node('0');
    void add(String word) {
        Node ptr = root;
        for (char ch : word.toCharArray()) {
            if (ptr.children[ch - 'a'] == null) {
                ptr.children[ch - 'a'] = new Node(ch);
            }
            ptr = ptr.children[ch - 'a'];
        }
        ptr.valid = true;
    }
}

class Node {
    char ch;
    boolean valid;
    Node[] children = new Node[26];
    Node(char ch) {
        this.ch = ch;
    }
    public String toString() {
        return ch + " " + valid;
    }
}

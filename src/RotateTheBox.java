import java.util.Arrays;

/**
 * @Description:
 * @Author: Ljl
 * @date 2021/12/27 15:04
 */
public class RotateTheBox {
    /**
     * 给你一个m x n的字符矩阵box，它表示一个箱子的侧视图。箱子的每一个格子可能为：
     * <p>
     * '#'表示石头
     * '*'表示固定的障碍物
     * '.'表示空位置
     * 这个箱子被 顺时针旋转 90 度，由于重力原因，部分石头的位置会发生改变。每个石头会垂直掉落，直到它遇到障碍物，另一个石头或者箱子的底部。重力 不会影响障碍物的位置，同时箱子旋转不会产生惯性，也就是说石头的水平位置不会发生改变。
     * <p>
     * 题目保证初始时box中的石头要么在一个障碍物上，要么在另一个石头上，要么在箱子的底部。
     * <p>
     * 请你返回一个n x m的矩阵，表示按照上述旋转后，箱子内的结果。
     * <p>
     * 输入：box = [['#','.','*','.'],
     *             ['#','#','*','.']]
     * 输出：[['#','.'],
     *      ['#','#'],
     *      ['*','*'],
     *      ['.','.']]
     *
     * @param box
     * @return
     */
    public char[][] rotateTheBox(char[][] box) {
        //行数、列数
        int m = box.length, n = box[0].length;
        //构建返回数组
        char[][] ans = new char[n][m];
        //逐行处理 石头右移
        for (int i = 0; i < m; i++) {
            //假设当前i行可以放石头的位置是pos,先默认为最右边
            int pos = n-1;
            //从右到左遍历放置石头
            for(int j=n-1;j>=0;j--){
                //遇到石头
                if (box[i][j] == '#'){
                    //将石头放到pos位置上,并将pos左移
                    box[i][pos--] = '#';
                    //将当前位置为空，需放置将起始位置的石头置空
                    if(pos != j-1)
                        box[i][j] = '.';
                }else if(box[i][j] == '*'){
                    //遇到障碍物,将pos位置充值
                    pos = j-1;
                }
            }
        }

        //将结构旋转90°，放到映射ans中
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                ans[j][m-i-1] = box[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        RotateTheBox rotateTheBox = new RotateTheBox();
        char[][] box = {{'#','.','*','.'},
                {'#','#','*','.'}};
        System.out.println(Arrays.toString(rotateTheBox.rotateTheBox(box)));
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjia
 * @title: Q54_螺旋矩阵
 * @date 2019/7/29 14:02
 */
public class Q54_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = -1;
        int y = 0;
        boolean[][] isVisit = new boolean[row][col];
        int count = row * col;
        int i = 0;
        while (count > 0) {
            while (y + dy[i] >= 0 && y + dy[i] < row && x + dx[i] >= 0 && x + dx[i] < col && !isVisit[y + dy[i]][x + dx[i]]) {
                y = y + dy[i];
                x = x + dx[i];
                res.add(matrix[y][x]);
                isVisit[y][x] = true;
                count--;
            }
            i = (i + 1) % 4;
        }
        return res;
    }
}

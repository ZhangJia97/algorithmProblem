package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjia
 * @title Q149_直线上最多的点数
 * @date 2019-08-2315:59
 *
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 *
 * 示例 1:
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 *
 * 示例 2:
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-points-on-a-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q149_直线上最多的点数 {

    public static void main(String[] args) {
        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
//        int[][] points = {{1,1},{2,2},{3,3}};
        System.out.println(maxPoints(points));
    }

    public static int maxPoints(int[][] points) {
        int len = points.length;
        if(len == 0){
            return 0;
        }
        Map<Double, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int s = 0;
        for(int i = 0; i < len; i++){
            int zero = 0;
            for(int j = i + 1; j < len; j++){
//                if(i == j){
//                    continue;
//                }
                if(points[i][0] == points[j][0] && points[i][1] == points[j][1]){
                    map.replaceAll((k, v) -> v + 1);
                }
                if(points[i][0] == points[j][0]){
                    zero++;
                    continue;
                }
                double num = (double) (points[i][1] - points[j][1]) / (double) (points[i][0] - points[j][0]);
                if(map.containsKey(num)){
                    int n = map.get(num);
                    map.put(num, n + 1);
                }else{
                    map.put(num, 2);
                }
                System.out.println(num + " " + map.get(num));
                max = Math.max(max, map.get(num));
            }
            max = Math.max(zero, max);
            map.clear();
        }
        return max;
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjia
 * @title: Q56_合并区间
 * @date 2019/7/30 13:57
 * <p>
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q56_合并区间 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        int l = 0;
        int start = 0;
        List<int[]> list = new ArrayList<>();
        while (l < intervals.length) {
            if (l < intervals.length - 1) {
                int ll = intervals[l][0];
                int lr = intervals[l][1];
                int rl = intervals[l + 1][0];
                int rr = intervals[l + 1][1];
                int lNum;
                int rNum;
                if (ll >= rl && ll <= rr) {
                    lNum = rl;
                } else if (ll <= rl && lr >= ll) {
                    lNum = ll;
                }
                if (lr > rl && lr < rr) {
                    rNum = rr;
                } else if (rr > ll && rr < lr) {
                    rNum = lr;
                }
                l++;
                continue;
            }
            if (start < l) {
                list.add(new int[]{intervals[start][0], intervals[l][1]});
            } else {
                list.add(intervals[start]);
            }
            l++;
            start = l;
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

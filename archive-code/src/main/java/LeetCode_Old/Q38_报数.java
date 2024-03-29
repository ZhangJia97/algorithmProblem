package LeetCode_Old;

/**
 * @author zhangjia
 * @title: Q38_报数
 * @date 2019/7/24 14:32
 * <p>
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * 示例 1:
 * 输入: 1
 * 输出: "1"
 * <p>
 * 示例 2:
 * 输入: 4
 * 输出: "1211"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q38_报数 {
    public String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }
        return countAndSay("1", 1, n);
    }

    public String countAndSay(String str, int m, int n) {
        if (m == n) {
            return str;
        }
        StringBuilder res = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
                res.append(count).append(str.charAt(i));
                count = 1;
            } else {
                count++;
            }
        }
        return countAndSay(String.valueOf(res), m + 1, n);
    }

}

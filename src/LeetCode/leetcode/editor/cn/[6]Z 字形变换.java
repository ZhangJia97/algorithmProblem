package leetcode.editor.cn;

//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
//
// Related Topics 字符串 👍 1736 👎 0

import com.sun.tools.javac.util.StringUtils;

class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
        System.out.println(solution.convert(null, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert1(String s, int numRows) {
            if (numRows == 1 || s == null || "".equals(s)) {
                return s;
            }
            final char[] charArray = s.toCharArray();
            final String[][] strings = new String[numRows][charArray.length];
            boolean down = true;
            int a = 0;
            int b = 0;
            for (char c : charArray) {
                strings[a][b] = String.valueOf(c);
                if (down) {
                    a++;
                } else {
                    a--;
                    b++;
                }
                if (a == 0) {
                    down = true;
                } else if (a == numRows - 1) {
                    down = false;
                }
            }
            final StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < charArray.length; j++) {
                    final String c = strings[i][j];
                    if (c != null && !"".equals(c)) {
                        stringBuilder.append(c);
                    }
                }
            }
            return stringBuilder.toString();
        }


        /**
         * https://blog.csdn.net/Inthesilence/article/details/107253469
         *
         * @return java.lang.String
         * @author zhangjia
         * @title convert
         * @date 2022/7/20 19:52
         */
        public String convert(String s, int numRows) {
            if (numRows == 1 || s == null || "".equals(s)) {
                return s;
            }
            int len = s.length() - 1;  //解法2，直接求解每一行每一列位置
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                int start = i;
                int downUp = 2 * (numRows - 1 - i); //先下降再上升的间隔
                int upDown = 2 * i; //先上升再下降的间隔
                if (i == 0 || i == numRows - 1) {
                    int step = i == 0 ? downUp : upDown;//判断第一行和最后一行
                    while (start <= len) {
                        str.append(s.charAt(start));
                        start += step;
                    }
                } else {
                    int count = 0;
                    while (start <= len) {//需设置计数器来判断是哪种路径
                        str.append(s.charAt(start));
                        count++;
                        if (count % 2 == 1) {
                            start += downUp;
                        } else {
                            start += upDown;
                        }
                    }
                }
            }
            return str.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

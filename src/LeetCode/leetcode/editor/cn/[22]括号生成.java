package leetcode.editor.cn;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 2792 👎 0

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        solution.generateParenthesis(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            generateParenthesis(ans, new StringBuilder(), 0, 0, n);
            return ans;
        }

        public void generateParenthesis(List<String> ans, StringBuilder s, int l, int r, int n) {
            if (s.length() == n * 2) {
                ans.add(s.toString());
                return;
            }
            if (l < n) {
                s.append("(");
                generateParenthesis(ans, s, l + 1, r, n);
                s.deleteCharAt(s.length() - 1);
            }

            if (r < l) {
                s.append(")");
                generateParenthesis(ans, s, l, r + 1, n);
                s.deleteCharAt(s.length() - 1);
            }
        }

//        class Solution {
//            public List<String> generateParenthesis(int n) {
//                List<String> ans = new ArrayList<String>();
//                backtrack(ans, new StringBuilder(), 0, 0, n);
//                return ans;
//            }
//
//            public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
//                if (cur.length() == max * 2) {
//                    ans.add(cur.toString());
//                    return;
//                }
//                if (open < max) {
//                    cur.append('(');
//                    backtrack(ans, cur, open + 1, close, max);
//                    cur.deleteCharAt(cur.length() - 1);
//                }
//                if (close < open) {
//                    cur.append(')');
//                    backtrack(ans, cur, open, close + 1, max);
//                    cur.deleteCharAt(cur.length() - 1);
//                }
//            }
//        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

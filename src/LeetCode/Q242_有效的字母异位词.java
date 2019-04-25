package LeetCode;

/**
 * @author zhangjia
 * @title: Q242_有效的字母异位词
 * @date 2019-04-22 19:20
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class Q242_有效的字母异位词 {
    public static void main(String args[]) {
        String s1="abc" + "def";
        String s2=new String(s1);
        if(s1 == s2)
            System.out.println("===succeed===");
                    if(s1.equals(s2))
            System.out.println("===equals() succeed===");
    }
    static void print() {
        System.out.print("DP");
    }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            if (--arr[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}

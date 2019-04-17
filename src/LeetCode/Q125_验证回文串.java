package LeetCode;

/**
 * @author zhangjia
 * @title: Q125_验证回文串
 * @date 2019-04-17 15:07
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class Q125_验证回文串 {
    public boolean isPalindrome(String s) {
        char[] ch = s.toLowerCase().toCharArray();
        int len = ch.length;
        int i = 0;
        int j = len - 1;
        while(i <= j){
            while(i < j && !isStr(ch[i])){
                i++;
            }
            while(i < j && !isStr(ch[j])){
                j--;
            }
            if(i <= j && ch[i] == ch[j]){
                i++;
                j--;
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean isStr(char c){
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))
            return true;
        return false;
    }
}

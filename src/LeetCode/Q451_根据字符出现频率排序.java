package LeetCode;

/**
 * @author zhangjia
 * @title: Q451_根据字符出现频率排序
 * @date 2019-04-22 20:42
 * <p>
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * 输入:
 * "tree"
 * 输出:
 * "eert"
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * <p>
 * 示例 2:
 * 输入:
 * "cccaaa"
 * 输出:
 * "cccaaa"
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * <p>
 * 示例 3:
 * 输入:
 * "Aabb"
 * 输出:
 * "bbAa"
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 */
public class Q451_根据字符出现频率排序 {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        // 记录每个字符出现的频次, 数字下标为字符ASCII码, LeetCode这题的测试用例128已经够用了
        int[] freq = new int[128];
        // 遍历字符数组, 计算每个字符出现的频次, 这一步时间复杂度O(n)
        for (int i = s.length() - 1; i >= 0; i--) {
            freq[chars[i]]++;
        }

        // 对chars数组进行三路快排, 设定频次越高的字符值越大,频次相等时再按照字符ASCII码进行比较
        // 排序这一步时间复杂度为O(nlogn), 所以整个算法的时间复杂度是O(nlogn)
        quicksort3Ways(chars, 0, s.length() - 1, freq);
        // 排序完成之后
        return new String(chars);
    }

    /**
     * 三路快排, 递归算法, 对chars数组的[l...r]前闭后闭区间进行排序
     *
     * @param chars : 要排序的字符数组
     * @param l     : 数组左边界
     * @param r     : 数组右边界
     * @param freq  : 字符出现频次, 设定字符大小与频次高低一致
     */
    private void quicksort3Ways(char[] chars, int l, int r, int[] freq) {
        if (r - l < 1) {
            return;
        }
        char p = chars[l];
        int left = l;
        int right = r + 1;
        int i = left + 1;
        while (i < right) {
            if (compare(chars[i], p, freq) > 0) {
                swap(chars, left + 1, i);
                left++;
                i++;
            } else if (compare(chars[i], p, freq) < 0) {
                swap(chars, right - 1, i);
                right--;
            } else {
                i++;
            }
        }
        swap(chars, l, left);
        quicksort3Ways(chars, l, left, freq);
        // 递归对大于pivot的元素再进行排序
        quicksort3Ways(chars, right, r, freq);
    }

    public int compare(char c1, char c2, int[] freq) {
        if (freq[c1] == freq[c2]) {
            return c1 - c2;
        }
        return freq[c1] - freq[c2];
    }

    /**
     * 对数组chars数组中index1,index2位置的两个元素进行交换
     *
     * @param chars
     * @param index1
     * @param index2
     */
    private void swap(char[] chars, int index1, int index2) {
        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
    }
}

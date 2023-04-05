package 程序员代码面试指南;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangjia
 * @title Q7_生成窗口最大值数组
 * @date 2020/1/5 19:04
 * @description //todo
 * 【题目】
 * 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个位置。
 * 例如，数组为[4，3，5，4，3，3，6，7]，窗口大小为3时：
 * [4  3  5] 4  3  3  6  7     窗口中最大值为5
 * 4 [3  5  4] 3  3  6  7     窗口中最大值为5
 * 4  3 [5  4  3] 3  6  7     窗口中最大值为5
 * 4  3  5 [4  3  3] 6  7     窗口中最大值为4
 * 4  3  5  4 [3  3  6] 7     窗口中最大值为6
 * 4  3  5  4  3 [3  6  7]    窗口中最大值为7
 * <p>
 * 如果数组长度为n，窗口大小为w，则一共产生n-w+1个窗口的最大值。请实现一个函数。
 * ● 输入：
 * 整型数组arr，窗口大小为w。
 * <p>
 * ● 输出：
 * 一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。
 * 以本题为例，结果应该返回{5，5，5，4，6，7}。
 */
public class Q7_生成窗口最大值数组 {
    public int[] getMaxWindows(int[] arr, int w){
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            if (deque.peekFirst() == i - w){
                deque.pollFirst();
            }
            if (i >= w - 1){
                res[index++] = arr[deque.peekFirst()];
            }
            System.out.print(deque + "     ");
            System.out.println(Arrays.toString(res));
        }
        return res;
    }

    public static void main(String[] args) {
        Q7_生成窗口最大值数组 q7_生成窗口最大值数组 = new Q7_生成窗口最大值数组();
        int[] arr = new int[]{4,3,5,4,3,3,6,7};
        q7_生成窗口最大值数组.getMaxWindows(arr, 3);
    }
}

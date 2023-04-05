package 程序员代码面试指南.Q6;

import java.util.ArrayList;

/**
 * @author zhangjia
 * @title HanoiPillar
 * @date 2020/1/5 13:55
 * @description //todo
 */
public class HanoiPillar {
    public int n; // 记录传递hanoi的圆盘数量
    public String name; // 柱子名称
    public ArrayList<Integer> arr = new ArrayList<>(); //用于记录当前柱子上所存在的圆盘

    // 初始化A柱
    public HanoiPillar(int n, String name) {
        this.n = n;
        this.name = name;
        for (int i = n; i > 0; i--) {
            this.arr.add(i);
        }
    }

    // 初始化B柱和C柱
    public HanoiPillar(String name) {
        this.name = name;
    }

    // 判断该柱子上方是否为顶部盘子
    public boolean top() {
        boolean result = false;
        if (!arr.isEmpty() && arr.size() != 0 && arr.get(arr.size() - 1) == 1) {
            result = true;
        }
        return result;
    }

    public void moveTo(HanoiPillar hanoiPillar) {
        hanoiPillar.arr.add(this.getDiskSize());
        this.arr.remove(this.arr.size() - 1);
        System.out.println(this.name + " -> " + hanoiPillar.name);
    }

    // 得到当前柱子的圆盘的列表，转化为String
    public String getStore() {
        StringBuilder result = new StringBuilder();
        if (this.arr.size() > 0) {
            for (int i = this.arr.size() - 1; i >= 0; i--) {
                result.append(this.arr.get(i)).append(",");
            }
        }
        return result.length() == 0 ? "null" : result.toString().trim();
    }

    // 得到该柱子中最小的圆盘的数值。以1、2、3、4、......、n来表示各个圆盘的大小。并且方便比较
    public Integer getDiskSize() {
        return this.arr.get(this.arr.size() - 1);
    }
}

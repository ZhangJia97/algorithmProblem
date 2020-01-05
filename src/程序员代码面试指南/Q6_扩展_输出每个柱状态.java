package 程序员代码面试指南;

import 程序员代码面试指南.Q6.HanoiPillar;

/**
 * @author zhangjia
 * @title Q6_扩展解法
 * @date 2020/1/5 13:54
 * @description //todo
 * 我们尝试更改一下题目要求，我们不只是需要输出交换步骤，我们需要记录交换过程中的三个柱子的圆盘存在情况
 * 这是我们需要创建一个类用于表示汉诺塔的每一个柱子，并且这个类将记录每个柱子上的圆盘情况
 * https://blog.csdn.net/weixin_42636076/article/details/81031580
 */
public class Q6_扩展_输出每个柱状态 {
    private int n;
    private int step;
    private HanoiPillar a;
    private HanoiPillar b;
    private HanoiPillar c;

    public void hanoi(int n, String a, String b, String c) {
        this.step = (int) (Math.pow(2, n) - 1);
        this.a = new HanoiPillar(n, a);
        this.b = new HanoiPillar(b);
        this.c = new HanoiPillar(c);
        this.n = n;
        if (n % 2 != 0) {
            HanoiPillar tmp = this.b;
            this.b = this.c;
            this.c = tmp;
        }
        while (this.step > 0) {

            // 进行top的移动
            if (this.a.top()) {
                list();
                this.a.moveTo(this.b);
                this.step--;
            } else if (this.b.top()) {
                list();
                this.b.moveTo(this.c);
                this.step--;
            } else if (this.c.top()) {
                list();
                this.c.moveTo(this.a);
                this.step--;
            }

            // 因为step为奇数，而最后完成后step=0；
            // 同时可以理解为最后一次移动一定是top移动，所以需要进行一次循环判断
            if (this.step == 0) {
                break;
            }

            // 执行第二步移动
            if (this.a.top()) {
                move2(this.b, this.c);
            } else if (this.b.top()) {
                move2(this.a, this.c);
            } else if (this.c.top()) {
                move2(this.a, this.b);
            }
        }
        list();
    }

    private void list() {
        if (n % 2 == 0) {
            System.out.print(this.a.name + "柱：" + this.a.getStore() +
                    "		" + this.b.name + "柱：" + this.b.getStore() +
                    "		" + this.c.name + "柱：" + this.c.getStore() + "			");
        } else {
            System.out.print(this.a.name + "柱：" + this.a.getStore() +
                    "		" + this.c.name + "柱：" + this.c.getStore() +
                    "		" + this.b.name + "柱：" + this.b.getStore() + "			");
        }

    }

    // 执行第二部移动
    private void move2(HanoiPillar a, HanoiPillar b) {
        if (a.arr.size() == 0) { // a柱为空，则将b上层的盘子移到a
            list();
            b.moveTo(a);
            this.step--;
        } else if (b.arr.size() == 0) { // b柱为空，则将a上层的盘子移到b
            list();
            a.moveTo(b);
            this.step--;
        } else if (a.getDiskSize() > b.getDiskSize()) { // 由于b盘子小于a盘子，所以将b的top盘子移动到a的top盘子
            list();
            b.moveTo(a);
            this.step--;
        } else { // 由于a盘子小于b盘子，所以将a的top盘子移动到b的top盘子
            list();
            a.moveTo(b);
            this.step--;
        }
    }

    public static void main(String[] args) {
        Q6_扩展_输出每个柱状态 q6_扩展_输出每个柱状态 = new Q6_扩展_输出每个柱状态();
        q6_扩展_输出每个柱状态.hanoi(3, "A", "B", "C");
    }
}

package 程序员代码面试指南;

import java.util.Stack;

/**
 * @author zhangjia
 * @title Q6_用栈来解决汉诺塔问题_非递归
 * @date 2020/1/5 13:27
 * @description //todo
 * 【题目】
 * 汉诺塔问题比较经典，这里修改一下游戏规则：
 * 现在限制不能从最左侧的塔直接移动到最右侧，也不能从最右侧直接移动到最左侧，而是必须经过中间。
 * 求当塔有N层的时候，打印最优移动过程和最优移动总步数。
 * <p>
 * 例如，当塔数为两层时，最上层的塔记为1，最下层的塔记为2，则打印：
 * Move 1 from left to mid
 * Move 1 from mid to right
 * Move 2 from left to mid
 * Move 1 from right to mid
 * Move 1 from mid to left
 * Move 2 from mid to right
 * Move 1 from left to mid
 * Move 1 from mid to right
 * It wi11 move 8 steps.
 */
public class Q6_用栈来解决汉诺塔问题_非递归 {

    public int hanoiProblem(int num, String left, String mid, String right) {
        Stack<Integer> lS = new Stack<>();
        Stack<Integer> mS = new Stack<>();
        Stack<Integer> rS = new Stack<>();
        // 初始化这四个栈，可以避免栈溢出问题，同时可以使while循环中的四个函数无论谁在前，都必定会限制性 l -> m
        lS.push(Integer.MAX_VALUE);//最大值：2147483647(2的7次方-1)
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);
        for (int i = num; i > 0; i--) {//将数字(最小数字在栈顶)压入左栈[1,2,3]
            lS.push(i);
        }
        //调用枚举，记录上一步操作 创建一个数组而不是直接创建一个Action对象是为了使用引用传递而不是值传递
        Action[] record = {Action.No};
        int step = 0;
        //size();stack类从vector继承的方法；返回此向量中的组件数
        while (rS.size() != num + 1) {//当右栈未将数字全部存入时
            //按顺序移动,下面这四个函数顺序并不影响因为每次必定只会有一个函数是满足条件的
            step += fStackToStack(record, Action.MToL, Action.LToM, lS, mS, left, mid);
            step += fStackToStack(record, Action.LToM, Action.MToL, mS, lS, mid, left);
            step += fStackToStack(record, Action.RToM, Action.MToR, mS, rS, mid, right);
            step += fStackToStack(record, Action.MToR, Action.RToM, rS, mS, left, mid);
        }
        return step;
    }

    public static int fStackToStack(Action[] record,
                                    Action preNoAet,
                                    Action nowAct,
                                    Stack<Integer> fStack,
                                    Stack<Integer> tStack,
                                    String from,
                                    String to) {
        // fStack.peek() < tStack.peek() 必然可以保证 record[0] != nowAct 两条件互斥
        if (record[0] != preNoAet && fStack.peek() < tStack.peek()) {//发生移动且必须小的数字往大的数字上移动
            tStack.push(fStack.pop());//fStack 移动到 tStack 且删掉from的栈顶元素
            System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Q6_用栈来解决汉诺塔问题_非递归 q6_用栈来解决汉诺塔问题_非递归 = new Q6_用栈来解决汉诺塔问题_非递归();
        int step = q6_用栈来解决汉诺塔问题_非递归.hanoiProblem(3, "左", "中", "右");
        System.out.println("总共需要" + step + "步");
    }

    enum Action {
        No, // 无操作
        LToM, // 从左移到中
        MToL, // 从中移到左
        MToR, // 从中移到右
        RToM // 从右移到中
    }
}

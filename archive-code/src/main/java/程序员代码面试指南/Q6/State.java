package 程序员代码面试指南.Q6;

/**
 * @author zhangjia
 * @title State
 * @date 2020/1/5 15:20
 * @description //todo
 */
public class State {
    public int n; // 当前层数
    public String x; // 起始柱
    public String y; // 辅助柱
    public String z; // 目标柱

    public State(int n, String x, String y, String z) {
        this.n = n;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

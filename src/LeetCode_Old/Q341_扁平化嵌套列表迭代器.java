package LeetCode_Old;

import LeetCode_Old.comm.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhangjia
 * @title: Q341_扁平化嵌套列表迭代器
 * @date 2019-04-26 22:18
 * <p>
 * 给定一个嵌套的整型列表。设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * 列表中的项或者为一个整数，或者是另一个列表。
 * <p>
 * 示例 1:
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * <p>
 * 示例 2:
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回false，next 返回的元素的顺序应该是: [1,4,6]。
 */
public class Q341_扁平化嵌套列表迭代器 {
    public class NestedIterator implements Iterator<Integer> {

        private List<Integer> list = new ArrayList<>();
        private int index;

        private void add(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    list.add(nestedInteger.getInteger());
                } else {
                    add(nestedInteger.getList());
                }
            }
        }

        public NestedIterator(List<NestedInteger> nestedList) {
            add(nestedList);
        }

        @Override
        public Integer next() {
            return list.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index < list.size();
        }
    }

}

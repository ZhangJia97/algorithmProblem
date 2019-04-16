package 剑指Offer;

/**
 * 二维数组中的查找
 *
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 样例
 * 输入数组：
 * [
 *   [1,2,8,9]，
 *   [2,4,9,12]，
 *   [4,7,10,13]，
 *   [6,8,11,15]
 * ]
 * 如果输入查找数值为7，则返回true，
 * 如果输入查找数值为5，则返回false。
 */
public class Solution4 {
    public boolean searchArray(int[][] array, int target) {
        if(array.length == 0 || array[0].length == 0){
            return false;
        }
        int row = 0;
        int col = array[0].length - 1;
        while(row < array.length && col >= 0){
            if(array[row][col] > target){
                col--;
            }else if(array[row][col] < target){
                row++;
            }else{
                return true;
            }
        }
        return false;
    }
}

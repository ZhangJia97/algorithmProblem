/**
 * @author zhangjia
 * @title: Q29_两数相除
 * @date 2019/7/29 16:24
 */
public class Q29_两数相除 {
    public static int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)){//考虑特殊情况
            return Integer.MAX_VALUE;
        }
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;//异或运算
        long ms = (long)dividend;
        long ns = (long)divisor;
        ms = Math.abs(ms);
        ns = Math.abs(ns);
        int num = 0;
        while(ms >= ns){
            long m = ns;
            long n = 1;
            while(ms >= (m << 1)){
                m <<= 1;
                n <<= 1;
            }
            num += n;
            ms -= m;
        }

        System.out.println(Integer.valueOf("-2147483648"));
        String res = "-" + (long)num;
        System.out.println(res);
        System.out.println(String.valueOf(num).substring(1));
        if(sign == -1 && num < 0){
            return Math.toIntExact(Long.parseLong(String.valueOf(num).substring(1)));
        }else if(sign == -1 && num > 0){
            return Integer.parseInt(("-" + (long)num).trim());
        }else {
            return num;
        }

    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 1));
    }
}

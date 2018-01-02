package Easy;

/**
 * Created by Vincent on 2017/11/22.
 *
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 *
 * Did you notice that the reversed inte ger might overflow? Assume the input is a 32-bit
 * integer, then the reverse of1000000003 overflows. How should you handle such cases?
 *
 * 题意是给你一个整型数，求它的逆序整型数，而且有个小坑点，当它的逆序整型数溢出的话，那么就返回0，
 * 用我们代码表示的话可以求得结果保存在long中，最后把结果和整型的两个范围比较即可。
 */
public class ReverseInteger {

    public static void main(String[] args){

        int a = -13;

        ReverseInteger ri = new ReverseInteger();
        int b = ri.reverse(a);
        System.out.println(b);
    }

    public int reverse(int x) {
        long res = 0;
        /*每次循环的时候做两件事情
        * 1.x%10--->其实是将原始数据的最后一位数取到
        * 2.x=x/10--->取余完成之后，将整个数缩小10倍，这个时候原始数据的倒数第二位就变成了倒数第一位
        *
        */
        for (; x != 0; x /= 10)
            res = res * 10 + x % 10;
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;//结果如果溢出(结果不在整数的范围内)，则将结果定为0
    }
}

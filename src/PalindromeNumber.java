/**
 * Created by Vincent on 2017/11/22.
 *
 * Determine whether an integer is a palindrome
 * 判断一个数是不是回文数，首先负数不是回文数
 *
 */
public class PalindromeNumber {

    public static void main(String[] args){

        int a = 111;

        PalindromeNumber pn = new PalindromeNumber();
        System.out.println("通过取反序整数的方式:"+pn.isPalindromeByReverse(a));
        System.out.println("通过数字长度的方式:"+pn.isPalindromeByReverse(a));

    }

    /**
     * 采用将一个数倒序输出，此过程中应该注意计算的结果会不会有溢出的可能
     * @param value
     * @return
     */
    public boolean isPalindromeByReverse(int value){

        if (value<0) return false;

        int copyX = value,reverse = 0;
        for (;copyX>0;copyX/=10){
            reverse = reverse*10+copyX%10;
        }
        return value == reverse;
    }

    /**
     * 采用将原始数据根根据长度，算后边一部分的倒序，而前面一部分通过不断/10的方式来进行比较
     * @param value
     * @return
     */
    public boolean isPalindromeByLength(int value){

        if(value<0||(value!=0&&value%10==0))
            return false;
        int reverseX = 0;
        while (value>reverseX){
            reverseX = reverseX*10+value%10;
            value/=10;
        }
        return value==reverseX||reverseX/10==value;
    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vincent on 2017/11/24.
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * 题意是罗马数字转整型数，范围从1到3999
 *
 *
 */
public class RomanToInteger {

    private Map<Character,Integer> map;//Character是char的包装类

    public static void main(String[] args){

        RomanToInteger rti = new RomanToInteger();
        rti.init();

        System.out.println(rti.getInteger("IIIV"));
    }

    private void init(){
        map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }

    /**
     * 解题思路：
     * 相同的数字连写，所表示的数等于这些数字相加得到的数，如 Ⅲ=3；
     * 小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数，如 Ⅷ=8、Ⅻ=12；
     * 小的数字（限于 Ⅰ、X 和 C）在大的数字的左边，所表示的数等于大数减小数得到的数，如 Ⅳ=4、Ⅸ=9；
     *
     * 罗马数字与整数的联系：
     * I-->1
     * V-->5
     * X-->10
     * L-->50
     * C-->100
     * D-->500
     * M-->1000
     * @param key
     * @return
     */
    private int getInteger(String key){

        int len = key.length();
        int sum = map.get(key.charAt(len-1));
        for (int i = len-2;i>=0;i--){
            if (map.get(key.charAt(i))<map.get(key.charAt(i+1))){
                sum -=map.get(key.charAt(i));
            }else {
                sum +=map.get(key.charAt(i));
            }
        }

        return sum;
    }

}

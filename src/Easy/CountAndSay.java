package Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vincent on 2018/1/2 16:08
 * <p>
 * Description:
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * 题目的要求：题意是数和说，根据如下序列 1, 11, 21, 1211, 111221, ...，求第 n 个数，规则很简单,就是数和说，
 * 数就是数这个数数字有几个，说就是说这个数，所以 1 就是 1 个 1：11,11 就是有 2 个 1：21，21 就是 1 个 2、1 个 1：1211，
 * 可想而知后面就是 111221，思路的话就是按这个逻辑模拟出来即可。
 **/
public class CountAndSay {

    public static void main(String[] args) {

        CountAndSay cas = new CountAndSay();

        System.out.println(cas.countAndSay(7));
    }

    /**
     * 方法一：我去遍历整个字符串，根据遍历到的每个字符的个数，往StringBuffer中添加对应的字符，比如"1121"中有两个1，
     * 我就往StringBuffer中添加"211211"这样来构造下一个字符串。
     * @param index
     * @return
     */
    private String countAndSay(int index) {

        StringBuffer sb = new StringBuffer();


        Map<Integer, String> values = new HashMap<>();

        for (int i = 1; i <= index; i++) {

            if (i == 1) {
                if (values.get(1) == null || values.get(1).equals("")) {

                    sb = sb.append(1);

                }
            } else {
                String s = values.get(i - 1);
                int index_n = -1;
                for (int j = 0; j < s.length(); j++) {
                    if (j+1<=s.length()-1) {
                        if (s.charAt(j) == s.charAt(j + 1)) {
                            //相邻的两个字符相同时的处理
                            continue;
                        } else {
                            //相邻的两个字符不相同时的处理
                            int k = j - index_n;
                            index_n = j;
                            sb.append(k);

                            sb.append(s.charAt(j));
                        }
                    }else {
                        //前一个位置的值为两位数的问题
                        if (s.length()<=2) {
                            sb.delete(0, sb.length());
                            switch (s.length()) {
                                case 1:
                                    sb.append(s.length()).append(s.charAt(0));
                                    break;
                                case 2:
                                    if (s.charAt(0) == s.charAt(1)) {
                                        sb.append(s.length()).append(s.charAt(0));
                                    } else {
                                        sb.append(1).append(s.charAt(0)).append(1).append(s.charAt(1));
                                    }
                                    break;
                            }
                        }else {
                            //处理末两位相同的问题
                            System.out.println("j = " + j);
                            System.out.println("index_n2 = "+index_n);
                            int k = j - index_n;
                            index_n = j;
                            System.out.println("k = " + k);
                            sb.append(k);

                            sb.append(s.charAt(j));

                        }
                    }

                }

            }
            values.put(i, sb.toString());
            sb.delete(0, sb.length());
        }

        return values.get(index);
    }

    /**
     * 方法二：这个方法不是我自己实现的，不过思路是一样的，我的代码相对而言要比较渣...
     * @param n
     * @return
     */
    public String countAndSay2(int n) {
        String str = "1";
        while (--n > 0) {
            int times = 1;
            StringBuilder sb = new StringBuilder();
            char[] chars = str.toCharArray();
            int len = chars.length;
            for (int j = 1; j < len; j++) {
                if (chars[j - 1] == chars[j]) {
                    times++;
                } else {
                    sb.append(times).append(chars[j - 1]);
                    times = 1;
                }
            }
            str = sb.append(times).append(chars[len - 1]).toString();
        }
        return str;
    }
}

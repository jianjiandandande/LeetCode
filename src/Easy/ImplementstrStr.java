package Easy;

/**
 * Created by Vincent on 2018/1/2 9:14
 *
 * Description:
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * 题目要求：从主串中找到子串的索引，如果找不到则返回-1，当字串长度大于主串，直接返回-1，然后我们只需要遍历比较即可。
 **/
public class ImplementstrStr {

    public static void main(String[] args){

        ImplementstrStr is = new ImplementstrStr();

        int value = is.strStr("aaaaa","aa");

        System.out.println(value);

    }

    /**
     * 方法一：依次根据索引遍历
     * @param haystack
     * @param needle
     * @return
     */
    private int getIndex(String haystack,String needle){

        int lenHaystack = haystack.length();

        int lenNeedle = needle.length();

        if (lenNeedle>lenHaystack) return -1;

        for (int i = 0; i <lenHaystack ; i++) {

            if (haystack.charAt(i)==needle.charAt(0)){

                for (int j = 1;j<lenNeedle;j++){

                    if (haystack.charAt(i+j)!=needle.charAt(j)){
                        return -1;
                    }
                }
                return i;

            }else
                continue;

        }
        return -1;

    }

    /**
     * 第二种方法
     * @param haystack
     * @param needle
     * @return
     */
    private int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) return -1;
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == l2) return i;
                if (i + j == l1) return -1;
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
    }

}

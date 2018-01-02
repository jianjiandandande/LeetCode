package Easy;

/**
 * Created by Vincent on 2017/11/24.
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * 题意是让你从字符串数组中找出公共前缀
 */
public class LongestCommonPrefix {

    public static void main(String[] args){

        LongestCommonPrefix lcp = new LongestCommonPrefix();

        System.out.println(lcp.getCommonPrefix(new String[]{"a1cff","abcww","ab--","abc"}));

    }


    /**
     * 思路：
     * 找到字符串数组中，长度最短的字符串
     * 然后通过遍历最短字符串的每一个字符来与别的字符串进行比较，如果有不同的，则停止比较，返回当前所比字符之前的字符串
     * 否则，返回整个最短字符串
     * @param strings
     * @return
     */
    private String getCommonPrefix(String[] strings){

        int len = strings.length;
        if (len==0) return "";
        int minLen = Integer.MAX_VALUE;
        for (String s : strings) {
            minLen = Math.min(s.length(),minLen);
        }
        for (int i = 0; i < minLen; i++) {
            for (int j = 1; j <len ; j++) {
                if (strings[0].charAt(i)!=strings[j].charAt(i)){
                    return strings[0].substring(0,i);
                }
            }
        }
        return strings[0].substring(0,minLen);
    }
}

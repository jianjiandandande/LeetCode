package Easy;

/**
 * Created by Vincent on 2017/11/26.
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if
 * the input string is valid.The brackets must close in the correct order, "()" and "()[]{}" are
 * all valid but "(]" and "([)]" are not.
 *
 * 题意是判断括号匹配是否正确
 *
 */
public class ValidParentheses {

    public static void main(String[] args){

        ValidParentheses vp = new ValidParentheses();

        System.out.println(vp.checkIsMate("({sfhjdhfsdjkfh})"));

    }

    /**
     * 可以通过栈的方式来解决这个问题
     * 当出现左括号的时候入栈，当遇到右括号时，判断栈顶的左括号是否何其匹配，不匹配的话直接返回false即可
     * @param s
     * @return
     */
    private boolean checkIsMate(String s){
        char[] stack = new char[s.length() + 1];
        int top = 1;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack[top++] = c;
            } else if (c == ')' && stack[--top] != '(') {
                return false;
            } else if (c == ']' && stack[--top] != '[') {
                return false;
            } else if (c == '}' && stack[--top] != '{') {
                return false;
            }
        }
        return top == 1;
    }

}

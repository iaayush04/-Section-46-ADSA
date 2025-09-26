// create a custom stackless & perform the above operation
public class ValidParenthesesCustom {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1; // empty stack pointer

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack[++top] = c; // push
            } else {
                if (top == -1) return false; // no matching open
                char open = stack[top--];    // pop

                if ((c == ')' && open != '(') ||
                    (c == '}' && open != '{') ||
                    (c == ']' && open != '[')) {
                    return false;
                }
            }
        }

        return top == -1; // valid if stack is empty
    }

    public static void main(String[] args) {
        ValidParenthesesCustom vp = new ValidParenthesesCustom();

        System.out.println(vp.isValid("()"));      // true
        System.out.println(vp.isValid("()[]{}"));  // true
        System.out.println(vp.isValid("(]"));      // false
        System.out.println(vp.isValid("([])"));    // true
        System.out.println(vp.isValid("([)]"));    // false
    }
}

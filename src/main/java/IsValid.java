import java.util.Stack;

// Given a String S consisting of opening and closing parenthesis, square brackets, curly brackets, find out if the brackets are balanced or not
// Brackets are said to be balanced if the bracket which opens last, closes first.
// You will be given three types of brackets: (), [] and {}.
// Assume that the string doesn't contain any other character than these, no spaces words or numbers.
// Return valid if the brackets are balanced, else return invalid.


public class IsValid {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        if (isValid(s)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}

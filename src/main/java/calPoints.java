import java.util.Stack;

//
public class calPoints {
    public static int calPoints(String[] ops) {
        int result = 0;
        Stack<Integer> stack = new Stack();
        for (String op : ops) {
            switch (op) {
                case "C" -> result -= stack.pop();
                case "D" -> {
                    int temp = stack.peek() * 2;
                    stack.push(temp);
                    result += temp;
                }
                case "+" -> {
                    int temp = stack.pop();
                    int temp2 = stack.peek() + temp;
                    stack.push(temp);
                    stack.push(temp2);
                    result += temp2;
                }
                default -> {
                    int temp = Integer.parseInt(op);
                    stack.push(temp);
                    result += temp;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(calPoints(ops));
    }
}



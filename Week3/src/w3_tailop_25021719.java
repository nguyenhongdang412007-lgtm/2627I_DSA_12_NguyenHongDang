import java.util.Scanner;
import java.util.Stack;

public class w3_tailop_25021719 {
    public static int priority(char c) {
        if (c == '+' || c == '-')
            return 1;

        if (c == '*' || c == '/')
            return 2;

        return 0;
    }

    public static String infixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == ' ')
                continue;

            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            }

            else if (c == '(') {
                stack.push(c);
            }

            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            else if (c == '+' || c == '-' || c == '*' || c == '/') {

                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && priority(stack.peek()) >= priority(c)) {

                    postfix.append(stack.pop());
                }

                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        System.out.println( infixToPostfix(expression));

        scanner.close();
    }
}
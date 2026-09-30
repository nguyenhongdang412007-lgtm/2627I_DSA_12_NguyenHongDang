import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    public static String isBalanced(String s) {

        Stack<Character> stack = new Stack<>();

        for (char kyTu : s.toCharArray()) {

            if (kyTu == '(' || kyTu == '[' || kyTu == '{') {
                stack.push(kyTu);
            } else {

                if (stack.isEmpty()) {
                    return "NO";
                }

                char dauTrenCung = stack.pop();

                if (kyTu == ')' && dauTrenCung != '(') {
                    return "NO";
                }

                if (kyTu == ']' && dauTrenCung != '[') {
                    return "NO";
                }

                if (kyTu == '}' && dauTrenCung != '{') {
                    return "NO";
                }
            }
        }

        if (stack.isEmpty()) {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            System.out.println(isBalanced(s));
        }

        sc.close();
    }
}
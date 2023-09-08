import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 괄호의 값
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;
        int value = 1;

        for(int i = 0; i < input.length(); i++) {
            Character now = input.charAt(i);

            if(now.equals('(')) {
                stack.push(now);
                value *= 2;
            }
            else if(now.equals('[')) {
                stack.push(now);
                value *= 3;
            }
            else if(now.equals(')')) {
                if(stack.isEmpty() || stack.peek() != '('){
                    result = 0;
                    break;
                }
                else if(input.charAt(i-1) == '(') {
                    result += value;
                }
                stack.pop();
                value /= 2;
            }
            else if(now.equals(']')) {
                if(stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }
                else if(input.charAt(i-1) == '[') {
                    result += value;
                }
                stack.pop();
                value /= 3;
            }
        }
        if(!stack.isEmpty()) sb.append(0).append("\n");
        else sb.append(result).append("\n");
        System.out.println(sb);

    }
}

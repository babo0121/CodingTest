import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 괄호 제거
public class Main {
    static List<Pair> pairs = new ArrayList<>();
    static int pairCount;
    static Set<String> results = new TreeSet<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            if(now == '(') stack.add(i);    // ( 의 인덱스를 스택에 삽입
            else if (now == ')') pairs.add(new Pair(stack.pop(), i));   // (와 짝맞는 )의 인덱스를 배열에 삽입
        }

        pairCount = pairs.size();

        makeResult(0,input + "");

        // set에 포함된 입력값 제거
        results.remove(input);

        StringBuilder answer = new StringBuilder();
        for(String result: results) {
            answer.append(result).append("\n");
        }
        System.out.print(answer);
    }

    static void makeResult(int idx, String str) {
        if(idx == pairCount) {
            // 공백 제거 후 results에 add
            results.add(str.replaceAll(" ", ""));
            return;
        }

        // idx에 해당하는 괄호 제거
        Pair pair = pairs.get(idx);
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(pair.left, ' ');
        sb.setCharAt(pair.right, ' ');
        makeResult(idx + 1, sb.toString()); // idx에 해당하는 제거한 str에서 idx+1에 해당하는 괄호 제거

        // 제거 안함
        makeResult(idx + 1, str);
    }

    static class Pair {
        int left, right;

        public Pair(int left, int right) {
            this.left = left;     // ( 의 인덱스 값
            this.right = right;   // ) 의 인덱스 값
        }
    }

}

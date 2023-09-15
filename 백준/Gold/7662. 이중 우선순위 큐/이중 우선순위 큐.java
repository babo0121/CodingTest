// 이중 우선순위 큐

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int K;
        String operator = "";
        int n = 0;

        for(int i = 0; i < T; i++){
            K = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap();

            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                operator = st.nextToken();
                n = Integer.parseInt(st.nextToken());

                if(operator.equals("I")) {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                }
                else { // D
                    if(map.size() == 0)
                        continue;

                    int key = n == 1 ? map.lastKey() : map.firstKey();
                    int count = map.get(key);

                    if (count == 1) {
                        map.remove(key);
                    }
                    else {
                        map.put(key, count - 1);
                    }
                }
            }
            if(map.isEmpty())     // 비어있을 경우
                System.out.println("EMPTY");
            else
                System.out.println(map.lastKey() + " " + map.firstKey());   // 최댓값 최솟값 출력
        }

    }
}

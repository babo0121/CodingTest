import java.io.*;
import java.util.StringTokenizer;

// 동전
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스의 개수
        int N; // 동전의 가지 수
        int[] coins;    // N가지 동전의 각 금액
        int M; //  N가지 동전으로 만들어야 할 금액
        int[] dp;   // 동전으로 i원을 만들 수 있는 경우의 수

        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            coins = new int[N];
            for(int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            M = Integer.parseInt(br.readLine());   // 주어진 N가지 동전으로 만들어야 할 금액

            dp = new int[M+1];
            dp[0] = 1;
            for(int i = 0; i < N; i++) {
                int coin = coins[i];
                for(int j = coin; j <=M; j++) {
                    dp[j] += dp[j-coin];
                }
            }
            bw.write(dp[M] +"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

// 1, 5, 10, 50, 100, 500 원

// 30원
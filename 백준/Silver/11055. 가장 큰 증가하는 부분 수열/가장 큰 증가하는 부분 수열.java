// 가장 큰 증가하는 부분 순열

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());     // 수열의 크기

        st = new StringTokenizer(br.readLine());
        int dp[] = new int[N+1];  // 합을 저장하는 배열
        int[] sequence = new int[N+1];
        for(int i = 1; i <= N; i++) {
            dp[i] = sequence[i] = Integer.parseInt(st.nextToken());
        }

        int result = dp[1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j < i; j++) {
                if(sequence[j] < sequence[i]) {
                    dp[i] = Math.max(dp[j]+sequence[i], dp[i]);
                    result = Math.max(result, dp[i]);
                }
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        br.close();
        bw.close();
    }
}

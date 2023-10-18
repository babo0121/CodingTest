import java.io.*;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열
public class Main {
    public static int[] sequence;
    public static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        sequence = new int[N];
        dp = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            LIS(i);
        }

        int max = dp[0];
        // 최댓값 찾기
        for(int i = 1; i < N; i++) {
            if(max < dp[i]) {
                max = dp[i];
            }
        }
        bw.write(Integer.toString(max));
        bw.flush();
        br.close();
        bw.close();
    }

    static int LIS(int N) {
        // 만약 탐색하지 않던 위치의 경우
        if(dp[N] == null) {
            dp[N] = 1;  // 1로 길이를 초기화

            for(int i = N-1; i >= 0; i--) {
                if(sequence[i] < sequence[N]) {
                    dp[N] = Math.max(dp[N], LIS(i) + 1);
                }
            }
        }
        return dp[N];
    }
}

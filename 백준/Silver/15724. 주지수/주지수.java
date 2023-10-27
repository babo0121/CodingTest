import java.io.*;
import java.util.StringTokenizer;

// 주지수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int area[][] = new int[N+1][M+1];

        for(int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 1; m <= M; m++) {
                area[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        int[][]dp = new int[N+1][M+1];

        for(int n = 1; n <= N; n++) {
            for(int m = 1; m <= M; m++) {
                dp[n][m] = dp[n-1][m] + dp[n][m-1] + area[n][m] - dp[n-1][m-1];
            }
        }
        int x1, y1, x2, y2;

        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            bw.write(Integer.toString(dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]) + '\n');
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

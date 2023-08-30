
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int K;
    public static int N;
    public static long[] lans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        K = Integer.parseInt(st.nextToken());  // 이미 가지고 있는 랜선의 개수
        N = Integer.parseInt(st.nextToken());  // 필요한 랜선의 개수

        lans = new long[K];  // 랜선의 길이들

//        st = new StringTokenizer(br.readLine());  // lans 입력 받기
        for(int i = 0; i < K; i++) {
            lans[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lans);

        System.out.println(binarySearch());

    }

    public static long binarySearch() {
        long low = 1;
        long high = lans[K-1];
        long mid = (low + high) / 2;
        long result = mid;

        while(low <= high) {
            mid = (low + high) / 2;

            if (isManyLans(mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static boolean isManyLans(long mid) {
        long sum = 0;
        for(int i = 0; i < K; i++) {
            sum += lans[i] / mid;
        }

        if (sum >= N) {
            return true;
        }
        return false;
    }
}

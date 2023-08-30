
import java.io.*;
import java.nio.file.ClosedWatchServiceException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;
    public static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        N = Integer.parseInt(st.nextToken());   // 나무의 수
        M = Integer.parseInt(st.nextToken());   // 가져갈려는 나무의 길이

        trees = new int[N];   // 나무들 길이 배열

        // 나무 길이 배열에 담기
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);


        System.out.println(binarySearch());
    }

    public static long binarySearch() {
        long low = 0;
        long high = 1_000_000_000;
        long mid = (high + low) / 2;
        long result = mid;

        while(low < high) {
            mid = (high + low) / 2;
            if (isTreeLengthHigh(mid)) {
                low = mid + 1;
                result = mid;
            }
            else {
                high = mid;
            }
        }

        return result;
    }

    public static boolean isTreeLengthHigh(long mid) {
        long sum = 0;
        for(int i = 0; i < N; i++) {
            if (trees[i] - mid > 0) {
                sum += trees[i] - mid;
            }
        }
        if (sum >= M) {
            return true;
        }
        return false;

    }
}

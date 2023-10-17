// 잃어버린 괄호

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        int result = 0;

        String[] splitByMinus = input.split("-");

        for(int i = 0; i < splitByMinus.length; i++) {
            String[] splitByPlus = splitByMinus[i].split("\\+");
            int plusSum = 0;
            for(int j = 0; j < splitByPlus.length; j++) {
                plusSum += Integer.parseInt(splitByPlus[j]);
            }

            if(i == 0) {
                result = plusSum;
            } else {
                result -= plusSum;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        br.close();
        br.close();
    }
}

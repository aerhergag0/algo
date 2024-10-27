package leetcode.dynamicprogramming.baekjoon9095;

import java.io.*;

public class Baekjoon9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] testcases = new int[T];
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            testcases[t] = N;
        }

        int max = 0;
        for (int i = 0; i < T; i++) {
            if (testcases[i] > max) {
                max = testcases[i];
            }
        }

        if (max >= 4) {
            for (int i = 4; i <= max; i++) {
                dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
            }
        }

        for (int i = 0; i < T; i++) {
            bw.write(dp[testcases[i]] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

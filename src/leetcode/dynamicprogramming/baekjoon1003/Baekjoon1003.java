package leetcode.dynamicprogramming.baekjoon1003;

import java.io.*;

public class Baekjoon1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] ans = fibo(N);
            int answer0 = ans[0];
            int answer1 = ans[1];

            bw.write(answer0 + " " + answer1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] fibo(int N) {
        if (N == 0) {
            return new int[]{1, 0};
        } else if (N == 1) {
            return new int[]{0, 1};
        }

        int[] first = {1, 0};
        int[] second = {0, 1};
        int[] result = {0, 0};

        for (int i = 1; i < N; i++) {
            result[0] = first[0] + second[0];
            result[1] = first[1] + second[1];

            first = second;
            second = result.clone();
        }

        return result;
    }
}

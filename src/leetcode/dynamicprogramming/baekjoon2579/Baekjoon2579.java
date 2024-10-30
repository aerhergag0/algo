package leetcode.dynamicprogramming.baekjoon2579;

import java.io.*;

public class Baekjoon2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] stair = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            bw.write(String.valueOf(stair[0]));
        } else if (N == 2) {
            bw.write(String.valueOf(Math.max(stair[0] + stair[1], stair[1])));
        } else {
            int first = stair[0];
            int second = Math.max(stair[0] + stair[1], stair[1]);
            int current = Math.max(stair[0] + stair[2], stair[1] + stair[2]);

            for (int i = 3; i < N; i++) {
                int next = Math.max(second + stair[i], stair[i - 1] + stair[i] + first);
                first = second;
                second = current;
                current = next;
            }

            bw.write(String.valueOf(current));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

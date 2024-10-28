package leetcode.dynamicprogramming.baekjoon11726;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(fibo(N) % 10007));
        bw.flush();
        bw.close();
        br.close();
    }

    private static long fibo(int n) {
        long result = 0;

        if (n <= 2) {
            result = n;
            return result;
        }

        long first = 1;
        long second = 2;

        for (int i = 1; i <= n-2; i++) {
            result = first + second;
            first = second;
            second = result;
        }

        return result;
    }
}

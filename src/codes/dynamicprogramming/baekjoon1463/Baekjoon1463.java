package codes.dynamicprogramming.baekjoon1463;

import java.io.*;

public class Baekjoon1463 {
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			int answer = 0;
			int X = Integer.parseInt(br.readLine());
			int[] dp = new int[X + 1];
			int max = Integer.MAX_VALUE;
			for (int i = 2; i < dp.length; i++) {
				dp[i] = max;
			}
			dp[1] = 0;

			for (int i = 1; i < X + 1; i++) {
				if (i * 3 <= X) {
					dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
				}

				if (i * 2 <= X) {
					dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
				}

				if (i + 1 <= X) {
					dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
				}
			}
			answer = dp[X];
			bw.write(String.valueOf(answer));
		}
	}
}

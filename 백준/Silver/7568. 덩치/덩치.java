import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] ranks = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			ranks[i][0] = Integer.parseInt(st.nextToken());
			ranks[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			int rank = 1;

			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;

				if (ranks[i][0] < ranks[j][0] && ranks[i][1] < ranks[j][1]) {
					rank++;
				}
			}

			System.out.println(rank);
		}
	}
}
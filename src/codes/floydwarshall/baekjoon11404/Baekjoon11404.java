package codes.floydwarshall.baekjoon11404;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11404 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		long[][] graph = new long[N + 1][N + 1];

		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(graph[i], 1000000000);
		}

		for (int i = 0; i < N + 1; i++) {
			graph[i][i] = 0;
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (c < graph[a][b]) {
				graph[a][b] = c;
			}
		}

		for (int k = 1; k < N + 1; k++) {
			for (int a = 1; a < N + 1; a++) {
				for (int b = 1; b < N + 1; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (graph[i][j] == 1000000000) {
					bw.write("0" + " ");
					continue;
				}
				bw.write(graph[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
